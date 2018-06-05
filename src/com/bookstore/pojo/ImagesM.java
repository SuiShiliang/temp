package com.bookstore.pojo;

public class ImagesM {
	private int ID;
	private String URL;
	private String EXTRA;

	@Override
	public String toString() {
		return "ImagesM [ID=" + ID + ", URL=" + URL + ", EXTRA=" + EXTRA + "]";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getEXTRA() {
		return EXTRA;
	}

	public void setEXTRA(String eXTRA) {
		EXTRA = eXTRA;
	}
}
