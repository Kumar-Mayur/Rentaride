package com.rentaride.Registerlogin.Dto;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "formRequest")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Full Name")
	private String fullname;

	@Column(name = "Phone number")
	private String phonenumber;

	@Column(name = "Address")
	private String address;

	@Column(name = "DLnumber")
	private String dLnumber;

	@Column(name = "TotalDays")
	private String totalDays;

	@Column(name = "carType")
	private String carType;

	@Column(name = "bookingId")
	private String bookingId;

	@Column(name = "status")
	private boolean status;

	public User(long id, String fullname, String phonenumber, String address, String dLnumber, String totalDays,
			String bookingId, String carType, boolean status) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.phonenumber = phonenumber;
		this.address = address;
		this.dLnumber = dLnumber;
		this.totalDays = totalDays;
		this.carType = carType;
		this.bookingId = bookingId;
		this.status = status;
	}

	public User() {
		this.bookingId = UUID.randomUUID().toString();
		this.status =false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDLnumber() {
		return dLnumber;
	}

	public void setDLnumber(String dLnumber) {
		this.dLnumber = dLnumber;
	}

	public String getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(String totalDays) {
		this.totalDays = totalDays;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	// Method to approve the booking
	public void approve() {
		this.status = true;
	}

	// Method to reject the booking

	public void reject() {
		this.status = false;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", phonenumber=" + phonenumber + ", address=" + address
				+ ", DLnumber=" + dLnumber + ", TotalDays=" + totalDays + ", carType=" + carType + ", bookingId="
				+ bookingId + ", status=" + status + "]";
	}

}
