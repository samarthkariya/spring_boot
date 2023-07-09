package com.organization.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.dto.DeptDto;
import com.organization.dto.OrgDto;
import com.organization.entity.Department;
import com.organization.entity.Employee;
import com.organization.entity.Organization;
import com.organization.repo.DeptRepo;
import com.organization.repo.EmpRepo;

@Service
public class DeptService {

	@Autowired
	DeptRepo repo;

	@Autowired
	private ModelMapper modelMapper;

	public void addDept(Department emp) {

		repo.save(emp);
	}

	public DeptDto createDept(DeptDto dto) {

		Department employee = modelMapper.map(dto, Department.class);

		System.out.println(employee);
		repo.save(employee);
		return modelMapper.map(employee, DeptDto.class);
	}

	public Department getdeptById(Integer id) {

		Optional<Department> employees = repo.findById(id);

		System.out.println(employees.toString());
		return employees.get();

	}

	public List<Department> getAllDept() {

		List<Department> employees = repo.findAll();

		System.out.println(employees.toString());
		return employees;

	}

	public void deleteDept(Integer id) {

		repo.deleteById(id);
	}

	public Department getdeptbyname(String name) {

		return repo.findByDeptName(name);
	}
}
