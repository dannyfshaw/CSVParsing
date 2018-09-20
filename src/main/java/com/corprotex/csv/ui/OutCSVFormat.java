package com.corprotex.csv.ui;

public class OutCSVFormat {
private String fullName;
//	private String firstName;
//	private String surname;
	private String employeeNumber;
	private String branch;
	private String product;
	private String size;
	private int quantity;
	private String fit;
	private String inchSize;
	
	

	public String getInchSize() {
		return inchSize;
	}

	public void setInchSize(String inchSize) {
		this.inchSize = inchSize;
	}

	public String getFit() {
		return fit;
	}

	public void setFit(String fit) {
		this.fit = fit;
	}



	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
