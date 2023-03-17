package com.example.demo.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="TRACKING")
public class Tracking {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="APINAME")
	private String apiName;
	@Column(name="STARTTIME")
	private LocalDateTime startTime;
	@Column(name="RESPONSETIME")
	private long responseTime;
	


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getApiName() {
		return apiName;
	}


	public void setApiName(String apiName) {
		this.apiName = apiName;
	}


	public LocalDateTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}


	public long getResponseTime() {
		return responseTime;
	}


	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}


	@Override
	public String toString() {
		return "Tracking [id=" + id + ", apiName=" + apiName + ", startTime=" + startTime + ", responseTime="
				+ responseTime + "]";
	}




	
	
	
	
	
	
	

}
