package com.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.organization.entity.Department;
import com.organization.entity.Employee;
import com.organization.entity.Organization;
import com.organization.service.OrgService;

@Controller
public class OrgControl {

	@Autowired
	private OrgService oService;

	@GetMapping("/orgc")
	public String Home(Model m) {

		List<Organization> organizations = oService.getAllOrg();

		m.addAttribute("org", organizations);

		return "Orgindex";
	}

	@GetMapping("/orgc/edit/{id}")
	public String editorg(@PathVariable Integer id, Model m) {

		Organization o = oService.getorgById(id);

		m.addAttribute("edit", o);

		return "AddandUpdOrg";
	}

	@PostMapping("/orgc/register")
	public String addorg(@ModelAttribute Organization organization) {

		oService.addOrg(organization);

		return "redirect:/orgc";
	}

	@PostMapping("/orgc/update")
	public String updateorg(@ModelAttribute Organization organization) {

		oService.addOrg(organization);

		return "redirect:/orgc";
	}

	@GetMapping("/orgc/delete/{id}")
	public String delete(@PathVariable int id) {

		oService.deleteOrg(id);
		return "redirect:/orgc";
	}

}
