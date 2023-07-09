package com.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.organization.dto.DeptDto;
import com.organization.dto.OrgDto;
import com.organization.entity.Department;
import com.organization.entity.Employee;
import com.organization.entity.Organization;
import com.organization.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	DeptService service;

	@GetMapping("/dept")
	public List<Department> dgetAll() {

		return service.getAllDept();
	}

	@DeleteMapping("/dept/delete/{id}")
	public void dDelete(@PathVariable int id) {
		service.deleteDept(id);
	}

	/*
	 * @PostMapping("/dept/add") public List<Department> addDept(@RequestBody
	 * Department e) {
	 * 
	 * service.addDept(e); return service.getAllDept(); }
	 */

	@GetMapping("/dept/get/{id}")
	public Department egetById(@PathVariable int id) {

		return service.getdeptById(id);
	}

	@PostMapping("/dept/add-dept")
	public ResponseEntity<DeptDto> createdept(@RequestBody DeptDto dto) {
		return new ResponseEntity<>(service.createDept(dto), HttpStatus.CREATED);
	}

	@PutMapping("/dept/update")
	public List<Department> updateDept(@RequestBody Department e) {

		service.addDept(e);
		return service.getAllDept();
	}
}
