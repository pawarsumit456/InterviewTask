package com.interview.task.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Table1")
public class Table1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productID;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "productDetails")
	private String productDetails;
	
	@Column(name = "productLaunchDate")
	private Date productLaunchDate;
	
	@Column(name = "productEndDate")
	private Date productEndDate;
	
	
	public Table1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Table1(long productID, String name, String productDetails, Date productLaunchDate, Date productEndDate) {
		super();
		this.productID = productID;
		this.name = name;
		this.productDetails = productDetails;
		this.productLaunchDate = productLaunchDate;
		this.productEndDate = productEndDate;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public Date getProductLaunchDate() {
		return productLaunchDate;
	}

	public void setProductLaunchDate(Date productLaunchDate) {
		this.productLaunchDate = productLaunchDate;
	}

	public Date getProductEndDate() {
		return productEndDate;
	}

	public void setProductEndDate(Date productEndDate) {
		this.productEndDate = productEndDate;
	}

	@Override
	public String toString() {
		return "Table1 [productID=" + productID + ", name=" + name + ", productDetails=" + productDetails
				+ ", productLaunchDate=" + productLaunchDate + ", productEndDate=" + productEndDate + "]";
	}
	
	
}
