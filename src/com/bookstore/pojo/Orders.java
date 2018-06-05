package com.bookstore.pojo;

import java.util.Date;

public class Orders {

	private int ID;
	private int CONSIGNEE_ID;
	private int ADDRESS_ID;
	private Date ORDERSDATE;
	private String STATUS;
	private String EXTRA;

	@Override
	public String toString() {
		return "Orders [ID=" + ID + ", CONSIGNEE_ID=" + CONSIGNEE_ID + ", ADDRESS_ID=" + ADDRESS_ID + ", ORDERSDATE="
				+ ORDERSDATE + ", STATUS=" + STATUS + ", EXTRA=" + EXTRA + "]";
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

	public int getADDRESS_ID() {
		return ADDRESS_ID;
	}

	public void setADDRESS_ID(int aDDRESS_ID) {
		ADDRESS_ID = aDDRESS_ID;
	}

	public Date getORDERSDATE() {
		return ORDERSDATE;
	}

	public void setORDERSDATE(Date oRDERSDATE) {
		ORDERSDATE = oRDERSDATE;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getEXTRA() {
		return EXTRA;
	}

	public void setEXTRA(String eXTRA) {
		EXTRA = eXTRA;
	}
}
