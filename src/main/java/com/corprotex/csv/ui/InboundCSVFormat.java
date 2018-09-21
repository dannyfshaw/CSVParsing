package com.corprotex.csv.ui;

public class InboundCSVFormat {
	private String name;
	private String employeeNumber;
	private String branchDetails;
	private String shellJacketSize;
	private String fit;
	private String inchSize;
	private String waterproofJacketSize;
	private int quantity;

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getWaterproofJacketSize() {
		return waterproofJacketSize;
	}

	public void setWaterproofJacketSize(String waterproofJacketSize) {
		this.waterproofJacketSize = waterproofJacketSize;
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

	public String getShellJacketSize() {
		return shellJacketSize;
	}

	public void setShellJacketSize(String shellJacketSize) {
		this.shellJacketSize = shellJacketSize;
	}

	@Override
	public String toString() {
		return "InboundCSVFormat [name=" + name + ", employeeNumber=" + employeeNumber + ", branchDetails="
				+ branchDetails + ", shellJacketSize=" + shellJacketSize + ", fit=" + fit + ", inchSize=" + inchSize
				+ ", waterproofJacketSize=" + waterproofJacketSize + ", quantity=" + quantity + "]";
	}

}
