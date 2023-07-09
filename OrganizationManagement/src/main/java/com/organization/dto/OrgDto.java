package com.organization.dto;

import java.util.List;

import com.organization.entity.Employee;

import lombok.Data;

@Data
public class OrgDto {

	private int oId;

	private String oName;

	private String oAddress;

	private String oContact_no;

	private String oOwner_name;

	private List<Employee> employ_Org_List;

	public OrgDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrgDto(int oId, String oName, String oAddress, String oContact_no, String oOwner_name,
			List<Employee> employ_Org_List) {
		super();
		this.oId = oId;
		this.oName = oName;
		this.oAddress = oAddress;
		this.oContact_no = oContact_no;
		this.oOwner_name = oOwner_name;
		this.employ_Org_List = employ_Org_List;
	}

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public String getoAddress() {
		return oAddress;
	}

	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}

	public String getoContact_no() {
		return oContact_no;
	}

	public void setoContact_no(String oContact_no) {
		this.oContact_no = oContact_no;
	}

	public String getoOwner_name() {
		return oOwner_name;
	}

	public void setoOwner_name(String oOwner_name) {
		this.oOwner_name = oOwner_name;
	}

	public List<Employee> getEmploy_Org_List() {
		return employ_Org_List;
	}

	public void setEmploy_Org_List(List<Employee> employ_Org_List) {
		this.employ_Org_List = employ_Org_List;
	}

}
