package com.bookstore.pojo;

public class Books {
	private int ID;
	private String NAME;
	private String INTRODUCTION;
	private int SALES_QUANTITY;
	private int GRADE;
	private double SELLING_PRICE;

	@Override
	public String toString() {
		return "Books [ID=" + ID + ", NAME=" + NAME + ", INTRODUCTION=" + INTRODUCTION + ", SALES_QUANTITY="
				+ SALES_QUANTITY + ", GRADE=" + GRADE + ", SELLING_PRICE=" + SELLING_PRICE + "]";
	}

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

	public int getSALES_QUANTITY() {
		return SALES_QUANTITY;
	}

	public void setSALES_QUANTITY(int sALES_QUANTITY) {
		SALES_QUANTITY = sALES_QUANTITY;
	}

	public int getGRADE() {
		return GRADE;
	}

	public void setGRADE(int gRADE) {
		GRADE = gRADE;
	}

	public double getSELLING_PRICE() {
		return SELLING_PRICE;
	}

	public void setSELLING_PRICE(double sELLING_PRICE) {
		SELLING_PRICE = sELLING_PRICE;
	}
}
