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
import com.organization.entity.Organization;
import com.organization.service.DeptService;
import com.organization.service.OrgService;

@Controller
public class DeptControl {

	@Autowired
	private DeptService dService;

	@GetMapping("/deptc")
	public String Home(Model m) {

		List<Department> departments = dService.getAllDept();

		m.addAttribute("dept", departments);

		return "Deptindex";
	}

	@GetMapping("/deptc/edit/{id}")
	public String editdept(@PathVariable Integer id, Model m) {

		Department d = dService.getdeptById(id);

		m.addAttribute("edit", d);

		return "AddandUpdDept";
	}

	@PostMapping("/deptc/register")
	public String adddept(@ModelAttribute Department department) {

		dService.addDept(department);

		return "redirect:/deptc";
	}

	@PostMapping("/deptc/update")
	public String updateorg(@ModelAttribute Department department) {

		dService.addDept(department);

		return "redirect:/deptc";
	}

	@GetMapping("/deptc/delete/{id}")
	public String delete(@PathVariable int id) {

		dService.deleteDept(id);
		return "redirect:/deptc";
	}

}
