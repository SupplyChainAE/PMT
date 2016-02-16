package com.snapdeal.entity;

import java.io.Serializable;


public class SellerInformation  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	
	private String sellerCode;
	private String sellerEmail;
	private String sellerMobile;
	private String sellerName;
	private String sellerAddress;
	private String sellerCity;
	private String sellerState;
	private String sellerPincode;
	private String dateRange;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSellerAddress() {
		return sellerAddress;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	public String getSellerCity() {
		return sellerCity;
	}
	public void setSellerCity(String sellerCity) {
		this.sellerCity = sellerCity;
	}
	public String getSellerState() {
		return sellerState;
	}
	public void setSellerState(String sellerState) {
		this.sellerState = sellerState;
	}
	public String getSellerPincode() {
		return sellerPincode;
	}
	public void setSellerPincode(String sellerPincode) {
		this.sellerPincode = sellerPincode;
	}
	
	
	public String getSellerCode() {
		return sellerCode;
	}
	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public String getSellerMobile() {
		return sellerMobile;
	}
	public void setSellerMobile(String sellerMobile) {
		this.sellerMobile = sellerMobile;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getDateRange() {
		return dateRange;
	}
	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}
	

}
