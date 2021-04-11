package com.krglow;

public class PlannedMeeting {

	private String startTime;
	private String endTime;

	public PlannedMeeting() {
		// TODO Auto-generated constructor stub
	}

	public PlannedMeeting(String startTime, String endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getstartTime() {
		return startTime;
	}

	public void setstartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getendTime() {
		return endTime;
	}

	public void setendTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "[\"" + startTime + "\", \"" + endTime + "\"]";
	}

}
