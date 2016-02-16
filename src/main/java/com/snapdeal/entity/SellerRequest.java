package com.snapdeal.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Seller_Request")
public class SellerRequest extends BaseEntity implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="para1" ,nullable=true)
	private Integer para1;

	@Column(name="para2",nullable=true)
	private Integer para2;

	@Column(name="para3",nullable=true)
	private Integer para3;

	@Column(name="para4",nullable=true)
	private Integer para4;

	@Column(name="para5",nullable=true)
	private Integer para5;

	@Column(name="para6",nullable=true)
	private Integer para6;

	@Column(name="para7",nullable=true)
	private Integer para7;

	@Column(name="para8",nullable=true)
	private Integer para8;
	
	@Column(name="para9",nullable=true)
	private Integer para9;
	
	@Column(name="para10",nullable=true)
	private Integer para10;
	
	@Column(name="para11",nullable=true)
	private Integer para11;

	
	
	@Column(name="price1" ,nullable=true)
	private Double price1;

	@Column(name="price2",nullable=true)
	private Double price2;

	@Column(name="price3",nullable=true)
	private Double price3;

	@Column(name="price4",nullable=true)
	private Double price4;

	@Column(name="price5",nullable=true)
	private Double price5;

	@Column(name="price6",nullable=true)
	private Double price6;

	@Column(name="price7",nullable=true)
	private Double price7;

	@Column(name="price8",nullable=true)
	private Double price8;
	
	@Column(name="price9",nullable=true)
	private Double price9;
	
	@Column(name="price10",nullable=true)
	private Double price10;
	@Column(name="price11",nullable=true)
	private Double price11;
	
	

	public Double getPrice10() {
		return price10;
	}

	public void setPrice10(Double price10) {
		this.price10 = price10;
	}

	public Double getPrice11() {
		return price11;
	}

	public void setPrice11(Double price11) {
		this.price11 = price11;
	}

	public Double getPrice1() {
		return price1;
	}

	public void setPrice1(Double price1) {
		this.price1 = price1;
	}

	public Double getPrice2() {
		return price2;
	}

	public void setPrice2(Double price2) {
		this.price2 = price2;
	}

	public Double getPrice3() {
		return price3;
	}

	public void setPrice3(Double price3) {
		this.price3 = price3;
	}

	public Double getPrice4() {
		return price4;
	}

	public void setPrice4(Double price4) {
		this.price4 = price4;
	}

	public Double getPrice5() {
		return price5;
	}

	public void setPrice5(Double price5) {
		this.price5 = price5;
	}

	public Double getPrice6() {
		return price6;
	}

	public void setPrice6(Double price6) {
		this.price6 = price6;
	}

	public Double getPrice7() {
		return price7;
	}

	public void setPrice7(Double price7) {
		this.price7 = price7;
	}

	public Double getPrice8() {
		return price8;
	}

	public void setPrice8(Double price8) {
		this.price8 = price8;
	}

	public Double getPrice9() {
		return price9;
	}

	public void setPrice9(Double price9) {
		this.price9 = price9;
	}

	public Integer getPara9() {
		return para9;
	}

	public Integer getPara10() {
		return para10;
	}

	public void setPara10(Integer para10) {
		this.para10 = para10;
	}

	public Integer getPara11() {
		return para11;
	}

	public void setPara11(Integer para11) {
		this.para11 = para11;
	}

	public void setPara9(Integer para9) {
		this.para9 = para9;
	}

	@Column(name="requeststatus", length=100, nullable=false)
	private String requeststatus;
	
	@Column(name="comment", length=200, nullable=true)
	private String comment;

	@Column(name="seller_name", length=200, nullable=true)
	private String seller_name;
	
	@Column(name="seller_address", length=1000, nullable=true)
	private String seller_address;
	
	@Column(name="seller_city", length=200, nullable=true)
	private String seller_city;
	@Column(name="seller_state", length=200, nullable=true)
	private String seller_state;
	
	@Column(name="seller_pincode", length=200, nullable=true)
	private String seller_pincode;
	
	@Column(name="seller_Tin", length=200, nullable=true)
	private String seller_Tin;
	
	public String getSeller_Tin() {
		return seller_Tin;
	}

	public void setSeller_Tin(String seller_Tin) {
		this.seller_Tin = seller_Tin;
	}

	public String getSeller_address() {
		return seller_address;
	}

	public void setSeller_address(String seller_address) {
		this.seller_address = seller_address;
	}

	public String getSeller_city() {
		return seller_city;
	}

	public void setSeller_city(String seller_city) {
		this.seller_city = seller_city;
	}

	public String getSeller_state() {
		return seller_state;
	}

	public void setSeller_state(String seller_state) {
		this.seller_state = seller_state;
	}

	public String getSeller_pincode() {
		return seller_pincode;
	}

	public void setSeller_pincode(String seller_pincode) {
		this.seller_pincode = seller_pincode;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}

	public String getSeller_mobile() {
		return seller_mobile;
	}

	public void setSeller_mobile(String seller_mobile) {
		this.seller_mobile = seller_mobile;
	}

	public String getSeller_email() {
		return seller_email;
	}

	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	public String getAWB() {
		return AWB;
	}

	public void setAWB(String aWB) {
		AWB = aWB;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name="seller_mobile", length=200, nullable=true)
	private String seller_mobile;
	
	@Column(name="seller_email", length=200, nullable=true)
	private String seller_email;
	
	@Column(name="AWB", length=200, nullable=true)
	private String AWB;
	
	@Column(name="courier", length=200, nullable=true)
	private String courier;
	
	@Column(name="SellerCode", length=100, nullable=false)
	private String SellerCode;

	public Integer getPara1() {
		return para1;
	}

	public void setPara1(Integer para1) {
		this.para1 = para1;
	}

	public Integer getPara2() {
		return para2;
	}

	public void setPara2(Integer para2) {
		this.para2 = para2;
	}

	public Integer getPara3() {
		return para3;
	}

	public void setPara3(Integer para3) {
		this.para3 = para3;
	}

	public Integer getPara4() {
		return para4;
	}

	public void setPara4(Integer para4) {
		this.para4 = para4;
	}

	public Integer getPara5() {
		return para5;
	}

	public void setPara5(Integer para5) {
		this.para5 = para5;
	}

	public Integer getPara6() {
		return para6;
	}

	public void setPara6(Integer para6) {
		this.para6 = para6;
	}

	public Integer getPara7() {
		return para7;
	}

	public void setPara7(Integer para7) {
		this.para7 = para7;
	}

	public Integer getPara8() {
		return para8;
	}

	public void setPara8(Integer para8) {
		this.para8 = para8;
	}

	public String getRequeststatus() {
		return requeststatus;
	}

	public void setRequeststatus(String requeststatus) {
		this.requeststatus = requeststatus;
	}
	
	public String getSellerCode() {
		return SellerCode;
	}

	public void setSellerCode(String sellerCode) {
		SellerCode = sellerCode;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


}
