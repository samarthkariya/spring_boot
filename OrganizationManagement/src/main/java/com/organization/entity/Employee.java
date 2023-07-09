package com.organization.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eId;

	private String eFirst_name;

	private String eLast_name;

	private String eContact_no;

	private String eDesignation;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organization;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	public Employee(int eId, String eFirst_name, String eLast_name, String eContact_no, String eDesignation,
			Organization organization, Department department) {
		super();
		this.eId = eId;
		this.eFirst_name = eFirst_name;
		this.eLast_name = eLast_name;
		this.eContact_no = eContact_no;
		this.eDesignation = eDesignation;
		this.organization = organization;
		this.department = department;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public Employee(int eId, String eFirst_name, String eLast_name, String
	 * eContact_no, String eDesignation) { super(); this.eId = eId; this.eFirst_name
	 * = eFirst_name; this.eLast_name = eLast_name; this.eContact_no = eContact_no;
	 * this.eDesignation = eDesignation; }
	 */

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteFirst_name() {
		return eFirst_name;
	}

	public void seteFirst_name(String eFirst_name) {
		this.eFirst_name = eFirst_name;
	}

	public String geteLast_name() {
		return eLast_name;
	}

	public void seteLast_name(String eLast_name) {
		this.eLast_name = eLast_name;
	}

	public String geteContact_no() {
		return eContact_no;
	}

	public void seteContact_no(String eContact_no) {
		this.eContact_no = eContact_no;
	}

	public String geteDesignation() {
		return eDesignation;
	}

	public void seteDesignation(String eDesignation) {
		this.eDesignation = eDesignation;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eFirst_name=" + eFirst_name + ", eLast_name=" + eLast_name + ", eContact_no="
				+ eContact_no + ", eDesignation=" + eDesignation + ", organization=" + organization + ", department="
				+ department + "]";
	}

}
