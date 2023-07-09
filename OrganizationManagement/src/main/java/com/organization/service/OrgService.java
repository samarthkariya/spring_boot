package com.organization.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.dto.EmpDto;
import com.organization.dto.OrgDto;
import com.organization.entity.Employee;
import com.organization.entity.Organization;
import com.organization.repo.EmpRepo;
import com.organization.repo.OrgRepo;

@Service
public class OrgService {

	@Autowired
	OrgRepo repo;

	@Autowired
	private ModelMapper modelMapper;

	public void addOrg(Organization emp) {

		repo.save(emp);
	}

	public OrgDto createOrg(OrgDto dto) {

		Organization employee = modelMapper.map(dto, Organization.class);

		System.out.println(employee);
		repo.save(employee);
		return modelMapper.map(employee, OrgDto.class);
	}

	public List<Organization> getAllOrg() {

		List<Organization> employees = repo.findAll();

		System.out.println(employees.toString());
		return employees;

	}

	public Organization getorgById(Integer id) {

		Optional<Organization> employees = repo.findById(id);

		System.out.println(employees.toString());
		return employees.get();

	}

	public void deleteOrg(Integer id) {

		repo.deleteById(id);
	}

	public Organization getbyorgname(String name) {

		return repo.findByName(name);
	}
}
