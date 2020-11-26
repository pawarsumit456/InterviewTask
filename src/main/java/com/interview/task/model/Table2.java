package com.interview.task.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Table2")
public class Table2 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long policyNuber;

	private long customerID;

	private String customerName;

	private String insuredName;

	private Date dob;

	private String email;

	private String mobileNumber;

	private String premiumMode;

	private String policyStatus;

	private String panNumber;

	private Date policyIssuanceDate;

	private String contactNumberLastUpdated;

	private String emailLastUpdated;

	private String accountNumber;

	private String whatsapp_opt_in_status;

	private String product_name;

	private long productID;

	private boolean reinvestApplication;

	private String outstandingPayout;

	private long unclaimedAmount;

	private boolean NEFTRegistered;

	private String lastPremiumPaid;

	public Table2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Table2(long policyNuber, long customerID, String customerName, String insuredName, Date dob, String email,
			String mobileNumber, String premiumMode, String policyStatus, String panNumber, Date policyIssuanceDate,
			String contactNumberLastUpdated, String emailLastUpdated, String accountNumber,
			String whatsapp_opt_in_status, String product_name, long productID, boolean reinvestApplication,
			String outstandingPayout, long unclaimedAmount, boolean nEFTRegistered, String lastPremiumPaid) {
		super();
		this.policyNuber = policyNuber;
		this.customerID = customerID;
		this.customerName = customerName;
		this.insuredName = insuredName;
		this.dob = dob;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.premiumMode = premiumMode;
		this.policyStatus = policyStatus;
		this.panNumber = panNumber;
		this.policyIssuanceDate = policyIssuanceDate;
		this.contactNumberLastUpdated = contactNumberLastUpdated;
		this.emailLastUpdated = emailLastUpdated;
		this.accountNumber = accountNumber;
		this.whatsapp_opt_in_status = whatsapp_opt_in_status;
		this.product_name = product_name;
		this.productID = productID;
		this.reinvestApplication = reinvestApplication;
		this.outstandingPayout = outstandingPayout;
		this.unclaimedAmount = unclaimedAmount;
		NEFTRegistered = nEFTRegistered;
		this.lastPremiumPaid = lastPremiumPaid;
	}

	public long getPolicyNuber() {
		return policyNuber;
	}

	public void setPolicyNuber(long policyNuber) {
		this.policyNuber = policyNuber;
	}

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPremiumMode() {
		return premiumMode;
	}

	public void setPremiumMode(String premiumMode) {
		this.premiumMode = premiumMode;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Date getPolicyIssuanceDate() {
		return policyIssuanceDate;
	}

	public void setPolicyIssuanceDate(Date policyIssuanceDate) {
		this.policyIssuanceDate = policyIssuanceDate;
	}

	public String getContactNumberLastUpdated() {
		return contactNumberLastUpdated;
	}

	public void setContactNumberLastUpdated(String contactNumberLastUpdated) {
		this.contactNumberLastUpdated = contactNumberLastUpdated;
	}

	public String getEmailLastUpdated() {
		return emailLastUpdated;
	}

	public void setEmailLastUpdated(String emailLastUpdated) {
		this.emailLastUpdated = emailLastUpdated;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getWhatsapp_opt_in_status() {
		return whatsapp_opt_in_status;
	}

	public void setWhatsapp_opt_in_status(String whatsapp_opt_in_status) {
		this.whatsapp_opt_in_status = whatsapp_opt_in_status;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public boolean isReinvestApplication() {
		return reinvestApplication;
	}

	public void setReinvestApplication(boolean reinvestApplication) {
		this.reinvestApplication = reinvestApplication;
	}

	public String getOutstandingPayout() {
		return outstandingPayout;
	}

	public void setOutstandingPayout(String outstandingPayout) {
		this.outstandingPayout = outstandingPayout;
	}

	public long getUnclaimedAmount() {
		return unclaimedAmount;
	}

	public void setUnclaimedAmount(long unclaimedAmount) {
		this.unclaimedAmount = unclaimedAmount;
	}

	public boolean isNEFTRegistered() {
		return NEFTRegistered;
	}

	public void setNEFTRegistered(boolean nEFTRegistered) {
		NEFTRegistered = nEFTRegistered;
	}

	public String getLastPremiumPaid() {
		return lastPremiumPaid;
	}

	public void setLastPremiumPaid(String lastPremiumPaid) {
		this.lastPremiumPaid = lastPremiumPaid;
	}

	@Override
	public String toString() {
		return "Table2 [policyNuber=" + policyNuber + ", customerID=" + customerID + ", customerName=" + customerName
				+ ", insuredName=" + insuredName + ", dob=" + dob + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", premiumMode=" + premiumMode + ", policyStatus=" + policyStatus + ", panNumber="
				+ panNumber + ", policyIssuanceDate=" + policyIssuanceDate + ", contactNumberLastUpdated="
				+ contactNumberLastUpdated + ", emailLastUpdated=" + emailLastUpdated + ", accountNumber="
				+ accountNumber + ", whatsapp_opt_in_status=" + whatsapp_opt_in_status + ", product_name="
				+ product_name + ", productID=" + productID + ", reinvestApplication=" + reinvestApplication
				+ ", outstandingPayout=" + outstandingPayout + ", unclaimedAmount=" + unclaimedAmount
				+ ", NEFTRegistered=" + NEFTRegistered + ", lastPremiumPaid=" + lastPremiumPaid + "]";
	}
	
	

}
