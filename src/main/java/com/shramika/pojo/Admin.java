package com.yusuf.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="admintable")
@PrimaryKeyJoinColumn(name="userId")
@DiscriminatorValue("Admin")
public class Admin extends User{

	private Date listeddate;
	public Admin()
	{
		
	}
	public Admin( Date listeddate)
	{
		this.listeddate=listeddate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "LISTED_DATE", nullable = false, length = 10)
	public Date getListeddate() {
		return listeddate;
	}
	public void setListeddate(Date listeddate) {
		this.listeddate = listeddate;
	}

	
	
	

}
