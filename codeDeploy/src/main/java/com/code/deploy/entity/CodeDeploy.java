package com.code.deploy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GOAP_LOCATION")
public class CodeDeploy {
    
	@Id
	private String ID;
	private String LOCATION_TYPE_ID;
	private String QA_IP_ADDRESS;
	private String QA_ROOT_USERNAME;
	private String QA_ROOT_PASSWORD;
	private String QA_DB_NAME;
	private String QA_DB_USERNAME;
	private String QA_DB_PASSWORD;
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getLOCATION_TYPE_ID() {
		return LOCATION_TYPE_ID;
	}
	public void setLOCATION_TYPE_ID(String lOCATION_TYPE_ID) {
		LOCATION_TYPE_ID = lOCATION_TYPE_ID;
	}
	public String getQA_IP_ADDRESS() {
		return QA_IP_ADDRESS;
	}
	public void setQA_IP_ADDRESS(String qA_IP_ADDRESS) {
		QA_IP_ADDRESS = qA_IP_ADDRESS;
	}
	public String getQA_ROOT_USERNAME() {
		return QA_ROOT_USERNAME;
	}
	public void setQA_ROOT_USERNAME(String qA_ROOT_USERNAME) {
		QA_ROOT_USERNAME = qA_ROOT_USERNAME;
	}
	public String getQA_ROOT_PASSWORD() {
		return QA_ROOT_PASSWORD;
	}
	public void setQA_ROOT_PASSWORD(String qA_ROOT_PASSWORD) {
		QA_ROOT_PASSWORD = qA_ROOT_PASSWORD;
	}
	public String getQA_DB_NAME() {
		return QA_DB_NAME;
	}
	public void setQA_DB_NAME(String qA_DB_NAME) {
		QA_DB_NAME = qA_DB_NAME;
	}
	public String getQA_DB_USERNAME() {
		return QA_DB_USERNAME;
	}
	public void setQA_DB_USERNAME(String qA_DB_USERNAME) {
		QA_DB_USERNAME = qA_DB_USERNAME;
	}
	public String getQA_DB_PASSWORD() {
		return QA_DB_PASSWORD;
	}
	public void setQA_DB_PASSWORD(String qA_DB_PASSWORD) {
		QA_DB_PASSWORD = qA_DB_PASSWORD;
	}
	
	
	@Override
	public String toString() {
		return "CodeDeploy [ID=" + ID + ", LOCATION_TYPE_ID=" + LOCATION_TYPE_ID + ", QA_IP_ADDRESS=" + QA_IP_ADDRESS
				+ ", QA_ROOT_USERNAME=" + QA_ROOT_USERNAME + ", QA_ROOT_PASSWORD=" + QA_ROOT_PASSWORD + ", QA_DB_NAME="
				+ QA_DB_NAME + ", QA_DB_USERNAME=" + QA_DB_USERNAME + ", QA_DB_PASSWORD=" + QA_DB_PASSWORD + "]";
	}







	
	
	
	
}
