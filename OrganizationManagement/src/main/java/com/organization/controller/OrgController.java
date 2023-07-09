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

import com.organization.dto.EmpDto;
import com.organization.dto.OrgDto;
import com.organization.entity.Department;
import com.organization.entity.Employee;
import com.organization.entity.Organization;
import com.organization.service.DeptService;
import com.organization.service.EmpService;
import com.organization.service.OrgService;

@RestController
public class OrgController {

	@Autowired
	OrgService service;

	@GetMapping("/org")
	public List<Organization> ogetAll() {

		return service.getAllOrg();
	}

	@DeleteMapping("/org/delete/{id}")
	public void oDelete(@PathVariable int id) {
		service.deleteOrg(id);
	}

	/*
	 * @PostMapping("/org/add") public List<Organization> addOrg(@RequestBody
	 * Organization e) {
	 * 
	 * service.addOrg(e); return service.getAllOrg(); }
	 */

	@GetMapping("/org/get/{id}")
	public Organization egetById(@PathVariable int id) {

		return service.getorgById(id);
	}

	@PostMapping("/org/add-org")
	public ResponseEntity<OrgDto> createorg(@RequestBody OrgDto dto) {
		return new ResponseEntity<>(service.createOrg(dto), HttpStatus.CREATED);
	}

	@PutMapping("/org/update")
	public List<Organization> updateOrg(@RequestBody Organization e) {

		service.addOrg(e);
		return service.getAllOrg();
	}

}
