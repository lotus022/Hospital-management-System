package com.cg.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ambulance {
	@Id
	private BigInteger id;
	private String ambulanceName;
	private String ambulanceLoaction;
	private String date;
	private double cost;
	private String bookedStatus;

	public Ambulance() {
		super();
		
	}

	public Ambulance(BigInteger id, String ambulanceName, String ambulanceLoaction, String date, double cost,
			String bookedStatus) {
		super();
		this.id = id;
		this.ambulanceName = ambulanceName;
		this.ambulanceLoaction = ambulanceLoaction;
		this.date = date;
		this.cost = cost;
		this.bookedStatus = bookedStatus;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getAmbulanceName() {
		return ambulanceName;
	}

	public void setAmbulanceName(String ambulanceName) {
		this.ambulanceName = ambulanceName;
	}

	public String getAmbulanceLoaction() {
		return ambulanceLoaction;
	}

	public void setAmbulanceLoaction(String ambulanceLoaction) {
		this.ambulanceLoaction = ambulanceLoaction;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getBookedStatus() {
		return bookedStatus;
	}

	public void setBookedStatus(String bookedStatus) {
		this.bookedStatus = bookedStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ambulanceLoaction == null) ? 0 : ambulanceLoaction.hashCode());
		result = prime * result + ((ambulanceName == null) ? 0 : ambulanceName.hashCode());
		result = prime * result + ((bookedStatus == null) ? 0 : bookedStatus.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ambulance other = (Ambulance) obj;
		if (ambulanceLoaction == null) {
			if (other.ambulanceLoaction != null)
				return false;
		} else if (!ambulanceLoaction.equals(other.ambulanceLoaction))
			return false;
		if (ambulanceName == null) {
			if (other.ambulanceName != null)
				return false;
		} else if (!ambulanceName.equals(other.ambulanceName))
			return false;
		if (bookedStatus == null) {
			if (other.bookedStatus != null)
				return false;
		} else if (!bookedStatus.equals(other.bookedStatus))
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
