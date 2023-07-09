package com.organization.service;

import java.util.List;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.dto.EmpDto;
import com.organization.entity.Department;
import com.organization.entity.Employee;
import com.organization.repo.EmpRepo;

@Service
public class EmpService {

	@Autowired
	EmpRepo repo;

	@Autowired
	private ModelMapper modelMapper;

	public void addEmployee(Employee emp) {
		repo.save(emp);
	}

	public EmpDto createEmp(EmpDto dto) {

		Employee employee = modelMapper.map(dto, Employee.class);

		System.out.println(employee);
		repo.save(employee);
		return modelMapper.map(employee, EmpDto.class);
	}

	public List<Employee> finduser(String name) {

		return repo.findAllEmpByOrgName(name);
	}

	public List<Employee> findempByDept(String name) {

		return repo.findbyDept(name);
	}

	public List<Employee> findByDeptandOrg(String dname, String oname) {

		return repo.findBydeptandorg(dname, oname);
	}

	public List<Employee> getAllEmp() {

		List<Employee> employees = repo.findAll();

		System.out.println(employees.toString());
		return employees;

	}

	public Employee getEmpById(Integer id) {

		Optional<Employee> employees = repo.findById(id);

		System.out.println(employees.toString());
		return employees.get();

	}

	public void deleteEmp(Integer id) {

		repo.deleteById(id);
	}

	public EmpDto editEmp(EmpDto dto) throws Exception {
		Employee employee = repo.findById(dto.geteId())
				.orElseThrow(() -> new Exception("Employee not found with this id::"));
		repo.save(employee);
		return modelMapper.map(employee, EmpDto.class);
	}

}
