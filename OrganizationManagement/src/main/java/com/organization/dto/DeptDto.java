package com.organization.dto;

import java.util.List;

import com.organization.entity.Employee;

import lombok.Data;

@Data
public class DeptDto {

	private int dId;

	private String dName;

	private List<Employee> employ_Dept_List;

	public DeptDto(int dId, String dName, List<Employee> employ_Dept_List) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.employ_Dept_List = employ_Dept_List;
	}

	public DeptDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public List<Employee> getEmploy_Dept_List() {
		return employ_Dept_List;
	}

	public void setEmploy_Dept_List(List<Employee> employ_Dept_List) {
		this.employ_Dept_List = employ_Dept_List;
	}

}
