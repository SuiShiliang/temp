package com.bookstore.pojo;

public class Consignees {
	private int ID;
	private int ACCOUNT_ID;
	private String FULL_NAME;
	private String TEL;

	@Override
	public String toString() {
		return "Consignees [ID=" + ID + ", ACCOUNT_ID=" + ACCOUNT_ID + ", FULL_NAME=" + FULL_NAME + ", TEL=" + TEL
				+ "]";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getACCOUNT_ID() {
		return ACCOUNT_ID;
	}

	public void setACCOUNT_ID(int aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}

	public String getFULL_NAME() {
		return FULL_NAME;
	}

	public void setFULL_NAME(String fULL_NAME) {
		FULL_NAME = fULL_NAME;
	}

	public String getTEL() {
		return TEL;
	}

	public void setTEL(String tEL) {
		TEL = tEL;
	}
}
