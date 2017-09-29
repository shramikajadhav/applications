package com.yusuf.pojo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="artisttable")
@PrimaryKeyJoinColumn(name="userId")
@DiscriminatorValue("Artist")
public class Artist extends User {
	@Column(name="ArtisType")
	private String ArtistType;
	@Column(name="ArtistAddress")
	private String ArtistAddress;
	
	public Artist()
	{
		
	}
	public Artist(String ArtistType, String ArtistAddress)
	{
		this.ArtistAddress=ArtistAddress;
		this.ArtistType=ArtistType;
	}
	public String getArtistType() {
		return ArtistType;
	}
	public void setArtistType(String artistType) {
		ArtistType = artistType;
	}
	public String getArtistAddress() {
		return ArtistAddress;
	}
	public void setArtistAddress(String artistAddress) {
		ArtistAddress = artistAddress;
	}
	

}
