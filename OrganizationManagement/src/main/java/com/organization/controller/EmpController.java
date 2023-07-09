package com.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.organization.dto.EmpDto;
import com.organization.entity.Employee;
import com.organization.repo.EmpRepo;
import com.organization.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	EmpService service;

	@Autowired
	EmpRepo repo;

	@GetMapping("/emp")
	public List<Employee> egetAll() {

		return service.getAllEmp();
	}

	@PostMapping("/emp/add-emp")
	public ResponseEntity<EmpDto> createStudent(@RequestBody EmpDto dto) {
		return new ResponseEntity<>(service.createEmp(dto), HttpStatus.CREATED);
	}

	@GetMapping("/emp/get/{id}")
	public Employee egetById(@PathVariable int id) {

		return service.getEmpById(id);
	}

	@GetMapping("/emp/byorgname/{name}")
	public List<Employee> getByName(@PathVariable String name) {

		return service.finduser(name);
	}

	@GetMapping("/emp/bydeptname/{name}")
	public List<Employee> getbydeptName(@PathVariable String name) {

		return service.findempByDept(name);
	}

	@GetMapping("/emp/bydeptandorg/{dname}&{oname}")
	public List<Employee> getbydeptandorg(@PathVariable String dname, @PathVariable String oname) {

		return service.findByDeptandOrg(dname, oname);
	}

	@DeleteMapping("/emp/delete/{id}")
	public void eDelete(@PathVariable int id) {
		service.deleteEmp(id);
	}

	/*
	 * @PostMapping("/emp/add") public List<Employee> addEmp(@Validated @RequestBody
	 * Employee e) {
	 * 
	 * service.addEmployee(e); return service.getAllEmp(); }
	 */

	@PutMapping("/emp/update")
	public List<Employee> updateEmp(@RequestBody Employee e) {

		service.addEmployee(e);
		return service.getAllEmp();
	}

}
