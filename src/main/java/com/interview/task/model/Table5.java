package com.interview.task.model;

import javax.persistence.*;

@Entity
@Table(name = "Table5")
public class Table5 {

	@Id
	private String auditLog;

	public Table5(String auditLog) {
		super();
		this.auditLog = auditLog;
	}

	public String getAuditLog() {
		return auditLog;
	}

	public void setAuditLog(String auditLog) {
		this.auditLog = auditLog;
	}

	@Override
	public String toString() {
		return "Table5 [auditLog=" + auditLog + "]";
	}

}
