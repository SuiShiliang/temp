package com.bookstore.pojo;

public class Order_items {
	private int ORDER_ID;
	private int BOOK_ID;
	private int QUANTITY;

	@Override
	public String toString() {
		return "Order_items [ORDER_ID=" + ORDER_ID + ", BOOK_ID=" + BOOK_ID + ", QUANTITY=" + QUANTITY + "]";
	}

	public int getORDER_ID() {
		return ORDER_ID;
	}

	public void setORDER_ID(int oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}

	public int getBOOK_ID() {
		return BOOK_ID;
	}

	public void setBOOK_ID(int bOOK_ID) {
		BOOK_ID = bOOK_ID;
	}

	public int getQUANTITY() {
		return QUANTITY;
	}

	public void setQUANTITY(int qUANTITY) {
		QUANTITY = qUANTITY;
	}

}
