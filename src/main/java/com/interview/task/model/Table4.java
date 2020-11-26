package com.interview.task.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Table4")
public class Table4 {

	@Id
	private long mobileNumber;
	private Date expireTime;
	private Date createTime;
	private long otp;

	
	
	public long getOtp() {
		return otp;
	}

	public void setOtp(long otp) {
		this.otp = otp;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Table4 [mobileNumber=" + mobileNumber + ", expireTime=" + expireTime + ", createTime=" + createTime
				+ ", otp=" + otp + "]";
	}

	
}
