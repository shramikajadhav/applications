package com.yusuf.pojo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="customertable")
@PrimaryKeyJoinColumn(name="userId")
@DiscriminatorValue("Customer")
public class Customer  extends User{
	@Column(name="shippingaddress")
	private String shippingaddress;
	@Column(name="phonenumber")
	private long phonenumber;
	
	public Customer()
	{
		
	}
	public Customer(String shippingaddress,long phonenumber)
	{
		this.phonenumber=phonenumber;
		this.shippingaddress=shippingaddress;
		
	}
	
	
	public String getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(String shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	

}
