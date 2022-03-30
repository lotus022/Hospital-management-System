package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="medicines")
public class Medicines {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "medicine_name")
	private String medicineName;
	@Column(name = "booked_status")
	private String bookedStatus;
	@Column(name="cost_of_medicine")
	private double cost;
	
	public Medicines() {
		super();
	}
	public Medicines(int id, String medicineName, String bookedStatus, double cost) {
		super();
		this.id = id;
		this.medicineName = medicineName;
		this.bookedStatus=bookedStatus;
		this.cost=cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	
	public String getBookedStatus() {
		return bookedStatus;
	}
	public void setBookedStatus(String bookedStatus) {
		// TODO Auto-generated method stub
		this.bookedStatus=bookedStatus;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "Medicines [id=" + id + ", medicineName=" + medicineName + ", bookedStatus=" + bookedStatus + ", cost="
				+ cost + "]";
	}
}
