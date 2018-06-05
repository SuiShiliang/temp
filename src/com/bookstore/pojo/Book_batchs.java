package com.bookstore.pojo;

import java.util.Date;

public class Book_batchs {
	private int ID;
	private int BOOK_ID;
	private Date BOOKDATE;
	private int QUANTITY;
	private double PRICE;
	private String ISBN;
	private String BOOK_CONCERN;

	@Override
	public String toString() {
		return "Book_batchs [ID=" + ID + ", BOOK_ID=" + BOOK_ID + ", BOOKDATE=" + BOOKDATE + ", QUANTITY=" + QUANTITY
				+ ", PRICE=" + PRICE + ", ISBN=" + ISBN + ", BOOK_CONCERN=" + BOOK_CONCERN + "]";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getBOOK_ID() {
		return BOOK_ID;
	}

	public void setBOOK_ID(int bOOK_ID) {
		BOOK_ID = bOOK_ID;
	}

	public Date getBOOKDATE() {
		return BOOKDATE;
	}

	public void setBOOKDATE(Date bOOKDATE) {
		BOOKDATE = bOOKDATE;
	}

	public int getQUANTITY() {
		return QUANTITY;
	}

	public void setQUANTITY(int qUANTITY) {
		QUANTITY = qUANTITY;
	}

	public double getPRICE() {
		return PRICE;
	}

	public void setPRICE(double pRICE) {
		PRICE = pRICE;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getBOOK_CONCERN() {
		return BOOK_CONCERN;
	}

	public void setBOOK_CONCERN(String bOOK_CONCERN) {
		BOOK_CONCERN = bOOK_CONCERN;
	}

}
