package com.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.organization.dto.EmpDto;
import com.organization.entity.Department;
import com.organization.entity.Employee;
import com.organization.entity.Organization;
import com.organization.service.DeptService;
import com.organization.service.EmpService;
import com.organization.service.OrgService;

@Controller
public class EmpControl {

	@Autowired
	private EmpService service;

	@Autowired
	private DeptService dService;

	@Autowired
	private OrgService oService;

	@GetMapping("/")
	public String Home(Model m) {
		List<Employee> employees = service.getAllEmp();

		m.addAttribute("emp", employees);

		List<Department> departments = dService.getAllDept();

		List<Organization> organizations = oService.getAllOrg();

		System.out.println(departments.toString());
		m.addAttribute("dept", departments);
		m.addAttribute("org", organizations);

		return "index";
	}

	@GetMapping("/edit/{id}")
	public String editEmp(@PathVariable Integer id, Model m) {

		Employee e = service.getEmpById(id);
		List<Department> departments = dService.getAllDept();

		List<Organization> organizations = oService.getAllOrg();
		m.addAttribute("dept", departments);
		m.addAttribute("org", organizations);
		m.addAttribute("edit", e);

		return "AddandUpdemp";
	}

	@PostMapping("/register")
	public String addEmp(@ModelAttribute Employee employee) {

		System.out.println(employee.toString());
		service.addEmployee(employee);

		return "redirect:/";
	}

	@RequestMapping(value = "/getfilter", method = RequestMethod.POST)
	public String filter(@RequestParam("department") String dept, @RequestParam("organization") String org,
			Model model) {

		if (dept.equals("null")) {

			List<Employee> employees = service.finduser(org);
			model.addAttribute("emp", employees);
		} else if (org.equals("null")) {
			List<Employee> employees = service.findempByDept(dept);
			model.addAttribute("emp", employees);
		} else {
			List<Employee> employees = service.findByDeptandOrg(dept, org);
			model.addAttribute("emp", employees);
		}

		List<Department> departments = dService.getAllDept();

		List<Organization> organizations = oService.getAllOrg();

		model.addAttribute("dept", departments);
		model.addAttribute("org", organizations);

		System.out.println(departments);
		System.out.println(organizations);

		return "index";
	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee employee) {

		System.out.println(employee.toString());
		service.addEmployee(employee);

		return "redirect:/";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id) {

		service.deleteEmp(id);
		return "redirect:/";
	}

}
