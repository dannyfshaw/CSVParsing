package com.corprotex.csv.ui;

public class InboundCSVFormat {
//private String employeeName;
//private int emloyeeNumber;
//private String branchDetails;
//private J140M j104M;
	private String name;
	private String employeeNumber;
	private String branchDetails;
	private String size;
	private String fit;
	private String inchSize;
//	private String column8;
//	private String column9;
//	private String column10;
//	private String column12;
//	private String column13;
//	private String column14;
//	private String column15;
//	private String column16;
//	private String column17;
//	private String column18;
//	private String column19;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getBranchDetails() {
		return branchDetails;
	}
	public void setBranchDetails(String branchDetails) {
		this.branchDetails = branchDetails;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getFit() {
		return fit;
	}
	public void setFit(String fit) {
		this.fit = fit;
	}
	public String getInchSize() {
		return inchSize;
	}
	public void setInchSize(String inchSize) {
		this.inchSize = inchSize;
	}
	@Override
	public String toString() {
		return "InboundCSVFormat [name=" + name + ", employeeNumber=" + employeeNumber + ", branchDetails="
				+ branchDetails + ", size=" + size + ", fit=" + fit + ", inchSize=" + inchSize
				+ "]";
	}
}
