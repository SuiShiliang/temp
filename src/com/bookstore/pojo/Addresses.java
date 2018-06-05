package com.bookstore.pojo;

public class Addresses {
	private int ID;
	private int CONSIGNEE_ID;
	private int COUNTRY;
	private int PROVINCE;
	private int CITY;
	private int STREET;
	private String EXTRA;

	@Override
	public String toString() {
		return "Addresses [ID=" + ID + ", CONSIGNEE_ID=" + CONSIGNEE_ID + ", COUNTRY=" + COUNTRY + ", PROVINCE="
				+ PROVINCE + ", CITY=" + CITY + ", STREET=" + STREET + ", EXTRA=" + EXTRA + "]";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getCONSIGNEE_ID() {
		return CONSIGNEE_ID;
	}

	public void setCONSIGNEE_ID(int cONSIGNEE_ID) {
		CONSIGNEE_ID = cONSIGNEE_ID;
	}

	public int getCOUNTRY() {
		return COUNTRY;
	}

	public void setCOUNTRY(int cOUNTRY) {
		COUNTRY = cOUNTRY;
	}

	public int getPROVINCE() {
		return PROVINCE;
	}

	public void setPROVINCE(int pROVINCE) {
		PROVINCE = pROVINCE;
	}

	public int getCITY() {
		return CITY;
	}

	public void setCITY(int cITY) {
		CITY = cITY;
	}

	public int getSTREET() {
		return STREET;
	}

	public void setSTREET(int sTREET) {
		STREET = sTREET;
	}

	public String getEXTRA() {
		return EXTRA;
	}

	public void setEXTRA(String eXTRA) {
		EXTRA = eXTRA;
	}

}
