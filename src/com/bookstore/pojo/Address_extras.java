package com.bookstore.pojo;

public class Address_extras {
	private int ID;
	private String CONTENT;
	private String CATEGORY;

	@Override
	public String toString() {
		return "Address_extras [ID=" + ID + ", CONTENT=" + CONTENT + ", CATEGORY=" + CATEGORY + "]";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

}
