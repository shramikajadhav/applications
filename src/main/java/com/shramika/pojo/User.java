package com.yusuf.pojo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(
	    name="discriminator",
	    discriminatorType=DiscriminatorType.STRING
	)
	

public class User {
	@Column(name = "firstname")
private String firstname;
	@Column(name = "lastname")
private String lastname;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "UserType")
	private String UserType;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
	private Set<Product> product = new HashSet<Product>();
	
	
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	public String getUserType() {
		return UserType;
	}
	public void setUserType(String userType) {
		UserType = userType;
	}
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="user")
	private ShoppingCart sc;

	public ShoppingCart getSc() {
		return sc;
	}
	public void setSc(ShoppingCart sc) {
		this.sc = sc;
	}
@Id
@GeneratedValue
@Column(name = "userId", unique=true, nullable = false)

private long UserId;


public User()
{
	
}



public User(long UserId)
{
	this.UserId=UserId;
}
public User(String firstname , String lastname , String username , String password , String UserType)
{
this.firstname=firstname;
this.lastname=lastname;
this.username=username;
this.password=password;
this.UserType=UserType;
}
public String getFirstname() {
	return firstname;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public long getUserId() {
	return UserId;
}
public void setUserId(long userId) {
	UserId = userId;
}
public Iterator iterator() {
	// TODO Auto-generated method stub
	return null;
}

}


