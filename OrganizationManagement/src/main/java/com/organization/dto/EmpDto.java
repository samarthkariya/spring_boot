package com.organization.dto;

import com.organization.entity.Department;
import com.organization.entity.Organization;

import lombok.Data;

@Data
public class EmpDto {

	private int eId;

	private String eFirst_name;

	private String eLast_name;

	private String eContact_no;

	private String eDesignation;

	private String orgName;

	private String deptName;

	private Organization organization;

	private Department department;

	private int oId;

	private int dId;

	public EmpDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public EmpDto(int eId, String eFirst_name, String eLast_name, String eContact_no, String eDesignation, int oId,
			int dId) {
		super();
		this.eId = eId;
		this.eFirst_name = eFirst_name;
		this.eLast_name = eLast_name;
		this.eContact_no = eContact_no;
		this.eDesignation = eDesignation;
		this.oId = oId;
		this.dId = dId;
	}

	public EmpDto(int eId, String eFirst_name, String eLast_name, String eContact_no, String eDesignation,
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

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

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

	@Override
	public String toString() {
		return "EmpDto [eId=" + eId + ", eFirst_name=" + eFirst_name + ", eLast_name=" + eLast_name + ", eContact_no="
				+ eContact_no + ", eDesignation=" + eDesignation + ", orgName=" + orgName + ", deptName=" + deptName
				+ ", organization=" + organization + ", department=" + department + "]";
	}

}
