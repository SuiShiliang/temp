package com.bookstore.pojo;

public class Authors {
	private int ID;
	private String NAME;
	private String INTRODUCTION;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getINTRODUCTION() {
		return INTRODUCTION;
	}

	public void setINTRODUCTION(String iNTRODUCTION) {
		INTRODUCTION = iNTRODUCTION;
	}

	@Override
	public String toString() {
		return "Authors [ID=" + ID + ", NAME=" + NAME + ", INTRODUCTION=" + INTRODUCTION + "]";
	}

}
