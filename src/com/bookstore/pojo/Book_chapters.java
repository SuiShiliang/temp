package com.bookstore.pojo;

public class Book_chapters {
	private int ID;
	private String NAME;
	private int BOOK_ID;
	private int CHAPTER_ID;

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

	public int getBOOK_ID() {
		return BOOK_ID;
	}

	public void setBOOK_ID(int bOOK_ID) {
		BOOK_ID = bOOK_ID;
	}

	public int getCHAPTER_ID() {
		return CHAPTER_ID;
	}

	public void setCHAPTER_ID(int cHAPTER_ID) {
		CHAPTER_ID = cHAPTER_ID;
	}

	@Override
	public String toString() {
		return "Book_chapters [ID=" + ID + ", NAME=" + NAME + ", BOOK_ID=" + BOOK_ID + ", CHAPTER_ID=" + CHAPTER_ID
				+ "]";
	}

}
