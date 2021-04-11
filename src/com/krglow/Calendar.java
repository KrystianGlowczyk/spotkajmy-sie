package com.krglow;

public class Calendar {

	private String startWork;
	private String endWork;

	private PlannedMeeting[] meetings;

	public Calendar(String startWork, String endWork, PlannedMeeting[] meetings) {
		this.startWork = startWork;
		this.endWork = endWork;
		this.meetings = meetings;
	}

	public String getstartWork() {
		return startWork;
	}

	public void setstartWork(String startWork) {
		this.startWork = startWork;
	}

	public String getendWork() {
		return endWork;
	}

	public void setendWork(String endWork) {
		this.endWork = endWork;
	}

	public PlannedMeeting[] getMeetings() {
		return meetings;
	}

	public void setMeetings(PlannedMeeting[] meetings) {
		this.meetings = meetings;
	}

}
