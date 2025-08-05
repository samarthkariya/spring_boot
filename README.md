Test data
Hello I am testing for PR Hwllo This is dummy request



public String getReviewFromRAG(List<String> diffs) {
        try {
            // Combine all diffs into a single string
            StringBuilder diffBuilder = new StringBuilder();
            for (String diff : diffs) {
                diffBuilder.append(diff).append("\n");
            }
            String diffPayload = diffBuilder.toString();

            // Prepare payload as a Map
            Map<String, String> payload = new HashMap<>();
            payload.put("diff", diffPayload);

            // Convert to JSON
            String jsonPayload = objectMapper.writeValueAsString(payload);

            // Send HTTP POST request
            URL url = new URL("http://localhost:5000/review");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Send JSON body
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonPayload.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Read response
            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line.trim());
                }
            }

            // Parse response JSON (assumes {"review": "..."})
            Map<String, Object> result = objectMapper.readValue(response.toString(), Map.class);
            return (String) result.getOrDefault("review", "No review found in response.");

        } catch (Exception e) {
            e.printStackTrace();
            return "Error communicating with RAG service: " + e.getMessage();
        }
    }
    
public List<String> extractPRDiffsFromWebhook(Map<String, Object> payload) {
    try {
        Map<String, Object> pullRequest = (Map<String, Object>) payload.get("pull_request");
        Map<String, Object> repository = (Map<String, Object>) payload.get("repository");

        if (pullRequest == null || repository == null) {
            throw new IllegalArgumentException("Invalid GitHub webhook payload: missing PR or repository");
        }

        int prNumber = (Integer) pullRequest.get("number");
        String repoFullName = (String) repository.get("full_name"); // e.g. "samarthkariya/spring_boot"
        String filesUrl = "https://api.github.com/repos/" + repoFullName + "/pulls/" + prNumber + "/files";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(githubToken); // Your GitHub token
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(filesUrl, HttpMethod.GET, entity, String.class);

        List<Map<String, Object>> files = objectMapper.readValue(response.getBody(), List.class);
        List<String> diffs = new ArrayList<>();

        for (Map<String, Object> file : files) {
            String filename = (String) file.get("filename");
            String status = (String) file.get("status");
            String patch = (String) file.get("patch");

            StringBuilder sb = new StringBuilder();
            sb.append("File: ").append(filename).append(" (").append(status).append(")\n");

            if (patch != null) {
                sb.append("Patch:\n").append(patch);
            } else {
                sb.append("⚠️ No patch available (possibly binary or deleted file).");
            }

            diffs.add(sb.toString());
        }

        return diffs;

    } catch (Exception e) {
        e.printStackTrace();
        return List.of("❌ Error extracting PR diffs: " + e.getMessage());
    }
}

public void commentOnPullRequest(String repoFullName, int prNumber, String commentText) {
        String url = "https://api.github.com/repos/" + repoFullName + "/issues/" + prNumber + "/comments";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(githubToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        Map<String, String> body = Map.of("body", commentText);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
            System.out.println("✅ PR comment posted: " + response.getStatusCode());
        } catch (Exception e) {
            System.out.println("❌ Failed to post PR comment: " + e.getMessage());
        }
    }
