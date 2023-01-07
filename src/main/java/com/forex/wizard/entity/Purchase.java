package com.forex.wizard.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String country;
	private String number;
	private String membership;
	private String price;
	private Date membershipPurchaseDate;
	private Date membershipExpiryDate;
	public Purchase(Long id, String firstName, String lastName, String email, String country, String number,
			String membership, String price, Date membershipPurchaseDate, Date membershipExpiryDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.country = country;
		this.number = number;
		this.membership = membership;
		this.price = price;
		this.membershipPurchaseDate = membershipPurchaseDate;
		this.membershipExpiryDate = membershipExpiryDate;
	}
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Date getMembershipPurchaseDate() {
		return membershipPurchaseDate;
	}
	public void setMembershipPurchaseDate(Date membershipPurchaseDate) {
		this.membershipPurchaseDate = membershipPurchaseDate;
	}
	public Date getMembershipExpiryDate() {
		return membershipExpiryDate;
	}
	public void setMembershipExpiryDate(Date membershipExpiryDate) {
		this.membershipExpiryDate = membershipExpiryDate;
	}
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", country=" + country + ", number=" + number + ", membership=" + membership + ", price=" + price
				+ ", membershipPurchaseDate=" + membershipPurchaseDate + ", membershipExpiryDate="
				+ membershipExpiryDate + "]";
	}
	
}