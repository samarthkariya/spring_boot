package com.organization.entity;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dId;

	private String dName;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Employee> employ_Dept_List;

	public Department(int dId, String dName, List<Employee> employ_Dept_List) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.employ_Dept_List = employ_Dept_List;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int dId, String dName) {
		super();
		this.dId = dId;
		this.dName = dName;
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

	@Override
	public String toString() {
		return "Department [dId=" + dId + ", dName=" + dName + "]";
	}

}
