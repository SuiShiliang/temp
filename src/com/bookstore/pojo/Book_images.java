package com.bookstore.pojo;

public class Book_images {
	private int BOOK_ID;
	private int IMAGE_ID;
	private String CATEGORY;

	@Override
	public String toString() {
		return "Book_images [BOOK_ID=" + BOOK_ID + ", IMAGE_ID=" + IMAGE_ID + ", CATEGORY=" + CATEGORY + "]";
	}

	public int getBOOK_ID() {
		return BOOK_ID;
	}

	public void setBOOK_ID(int bOOK_ID) {
		BOOK_ID = bOOK_ID;
	}

	public int getIMAGE_ID() {
		return IMAGE_ID;
	}

	public void setIMAGE_ID(int iMAGE_ID) {
		IMAGE_ID = iMAGE_ID;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

}
