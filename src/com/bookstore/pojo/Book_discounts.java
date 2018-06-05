package com.bookstore.pojo;

import java.util.Date;

public class Book_discounts {
	private int BOOK_ID;
	private int DISCOUNT;
	private Date STRAT_DATE;
	private Date END_DATE;

	@Override
	public String toString() {
		return "Book_discounts [BOOK_ID=" + BOOK_ID + ", DISCOUNT=" + DISCOUNT + ", STRAT_DATE=" + STRAT_DATE
				+ ", END_DATE=" + END_DATE + "]";
	}

	public int getBOOK_ID() {
		return BOOK_ID;
	}

	public void setBOOK_ID(int bOOK_ID) {
		BOOK_ID = bOOK_ID;
	}

	public int getDISCOUNT() {
		return DISCOUNT;
	}

	public void setDISCOUNT(int dISCOUNT) {
		DISCOUNT = dISCOUNT;
	}

	public Date getSTRAT_DATE() {
		return STRAT_DATE;
	}

	public void setSTRAT_DATE(Date sTRAT_DATE) {
		STRAT_DATE = sTRAT_DATE;
	}

	public Date getEND_DATE() {
		return END_DATE;
	}

	public void setEND_DATE(Date eND_DATE) {
		END_DATE = eND_DATE;
	}

}
