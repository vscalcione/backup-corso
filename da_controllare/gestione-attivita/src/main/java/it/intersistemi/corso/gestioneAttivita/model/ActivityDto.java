package it.intersistemi.corso.gestioneAttivita.model;

import java.util.Date;

public class ActivityDto {
	private String idActivity, activityName;
	private Date startDate, endDate;
	public String getIdActivity() {
		return idActivity;
	}
	public void setIdActivity(String idActivity) {
		this.idActivity = idActivity;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
}