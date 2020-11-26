package com.interview.task.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Table3")
public class Table3 {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long optinId;
	
	private long mobileNumber;
	
	private long policyNumber;
	
	private Date optinDate;

	public long getOptinId() {
		return optinId;
	}

	public void setOptinId(long optinId) {
		this.optinId = optinId;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}

	public Date getOptinDate() {
		return optinDate;
	}

	public void setOptinDate(Date optinDate) {
		this.optinDate = optinDate;
	}

	@Override
	public String toString() {
		return "Table3 [optinId=" + optinId + ", mobileNumber=" + mobileNumber + ", policyNumber=" + policyNumber
				+ ", optinDate=" + optinDate + "]";
	}
	
	
	
	
	}
	
	
	
	

