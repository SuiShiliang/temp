package com.bookstore.pojo.all;

import com.bookstore.pojo.Accounts;
import com.bookstore.pojo.Consignees;
import com.bookstore.pojo.ImagesM;

public class AccountsAll {

	private Accounts accounts;
	private ImagesM imagesM;
	private Consignees consignees;
	private AddressAll addressAll;
	public Accounts getAccounts() {
		return accounts;
	}
	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}
	public ImagesM getImagesM() {
		return imagesM;
	}
	public void setImagesM(ImagesM imagesM) {
		this.imagesM = imagesM;
	}
	public Consignees getConsignees() {
		return consignees;
	}
	public void setConsignees(Consignees consignees) {
		this.consignees = consignees;
	}
	public AddressAll getAddressAll() {
		return addressAll;
	}
	public void setAddressAll(AddressAll addressAll) {
		this.addressAll = addressAll;
	}
	@Override
	public String toString() {
		return "AccountsAll [accounts=" + accounts + ", imagesM=" + imagesM + ", consignees=" + consignees
				+ ", addressAll=" + addressAll + "]";
	}
	
}
