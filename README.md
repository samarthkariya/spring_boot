Test data
Hello I am testing for PR
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
