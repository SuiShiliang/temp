package com.bookstore.pojo.all;

import com.bookstore.pojo.Accounts;
import com.bookstore.pojo.Consignees;
import com.bookstore.pojo.ImagesM;
import com.bookstore.pojo.Order_items;
import com.bookstore.pojo.Orders;

public class OrdersAll {

	private Order_items items;
	private Orders orders;
	private Consignees consignees;
	private AddressAll addressAll;
	private Accounts accounts;
	private ImagesM imagesM;
	public Order_items getItems() {
		return items;
	}
	public void setItems(Order_items items) {
		this.items = items;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
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
	@Override
	public String toString() {
		return "OrdersAll [items=" + items + ", orders=" + orders + ", consignees=" + consignees + ", addressAll="
				+ addressAll + ", accounts=" + accounts + ", imagesM=" + imagesM + "]";
	}
	
}
