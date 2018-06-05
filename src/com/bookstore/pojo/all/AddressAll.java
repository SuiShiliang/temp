package com.bookstore.pojo.all;

import com.bookstore.pojo.Address_extras;
import com.bookstore.pojo.Addresses;

public class AddressAll {

	private Addresses addresses;
	private Address_extras country;
	private Address_extras province;
	private Address_extras city;
	private Address_extras street;
	@Override
	public String toString() {
		return "AddressAll [addresses=" + addresses + ", country=" + country + ", province=" + province + ", city="
				+ city + ", street=" + street + "]";
	}
	public Addresses getAddresses() {
		return addresses;
	}
	public void setAddresses(Addresses addresses) {
		this.addresses = addresses;
	}
	public Address_extras getCountry() {
		return country;
	}
	public void setCountry(Address_extras country) {
		this.country = country;
	}
	public Address_extras getProvince() {
		return province;
	}
	public void setProvince(Address_extras province) {
		this.province = province;
	}
	public Address_extras getCity() {
		return city;
	}
	public void setCity(Address_extras city) {
		this.city = city;
	}
	public Address_extras getStreet() {
		return street;
	}
	public void setStreet(Address_extras street) {
		this.street = street;
	}
}
