package com.organization.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "organization")

public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int oId;

	private String oName;

	private String oAddress;

	private String oContact_no;

	private String oOwner_name;

	@OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
	private List<Employee> employ_Org_List;

	public Organization(int oId, String oName, String oAddress, String oContact_no, String oOwner_name,
			List<Employee> employ_Org_List) {
		super();
		this.oId = oId;
		this.oName = oName;
		this.oAddress = oAddress;
		this.oContact_no = oContact_no;
		this.oOwner_name = oOwner_name;
		this.employ_Org_List = employ_Org_List;
	}

	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organization(int oId, String oName, String oAddress, String oContact_no, String oOwner_name) {
		super();
		this.oId = oId;
		this.oName = oName;
		this.oAddress = oAddress;
		this.oContact_no = oContact_no;
		this.oOwner_name = oOwner_name;
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

	@Override
	public String toString() {
		return "Organization [oId=" + oId + ", oName=" + oName + ", oAddress=" + oAddress + ", oContact_no="
				+ oContact_no + ", oOwner_name=" + oOwner_name + "]";
	}

}
