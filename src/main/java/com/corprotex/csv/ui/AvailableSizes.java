package com.corprotex.csv.ui;

public enum AvailableSizes {
	
	SMALL(1),
	MEDIUM(2),
	LARGE(3),
	XLARGE(4),
	XXLarge(5);
	
	private final int size;
	
	AvailableSizes(int Size){
		this.size = Size;
	}

	public int getSize() {
		return size;
	}
}
