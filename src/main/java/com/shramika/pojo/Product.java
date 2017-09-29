package com.yusuf.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
/**
 * @author shramika123
 *
 */
@Entity
@Table(name="producttable")
public class Product {
	@Column(name="prodname")
	private String prodname;
	@Column(name="prodprice")
	private String prodprice;
	@Column(name="prodDescription")
	private String prodDescription;
	
	@Column(name="sellerquant")
		private long sellerquant;
	
	 
	
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getProdprice() {
		return prodprice;
	}
	public void setProdprice(String prodprice) {
		this.prodprice = prodprice;
	}
	public String getProdDescription() {
		return prodDescription;
	}
	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}
	public long getSellerquant() {
		return sellerquant;
	}
	public void setSellerquant(long sellerquant) {
		this.sellerquant = sellerquant;
	}
	@Column(name="productImage")
	    private String photoName;
	    
	     public String getPhotoName() {
	        return photoName;
	    }
	    public void setPhotoName(String photoName) {
	        this.photoName = photoName;
	    }
	    private CommonsMultipartFile  photo;
	    
	
	public CommonsMultipartFile getPhoto() {
			return photo;
		}
		public void setPhoto(CommonsMultipartFile photo) {
			this.photo = photo;
		}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<CartItem> getCartItem() {
		return cartItem;
	}
	public void setCartItem(Set<CartItem> cartItem) {
		this.cartItem = cartItem;
	}
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prodID", unique = true, nullable = false)
	private long prodID;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
	private Set<CartItem> cartItem = new HashSet<CartItem>();
	
	 Product()
	{
		
	}
	 public Product(long productID)
	 {
		 this.prodID=productID;
	 }
	public Product(String productname,String productprice,String productDescription,String photoName,long sellerQuantity)
	{
		this.prodname=productname;
		this.photo=photo;
		this.prodprice=productprice;
		this.prodDescription=productDescription;
		this.cartItem = new HashSet<CartItem>();
		this.photoName=photoName;
		this.sellerquant=sellerQuantity;
	}
	public long getProdID() {
		return prodID;
	}
	public void setProdID(long prodID) {
		this.prodID = prodID;
	}
	
}
