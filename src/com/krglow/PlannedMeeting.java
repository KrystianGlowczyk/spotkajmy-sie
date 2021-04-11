package com.krglow;

public class PlannedMeeting {
	
	private String meetingStart;
	private String meetingEnd;
	
	public PlannedMeeting() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public PlannedMeeting(String meetingStart, String meetingEnd) {
		super();
		this.meetingStart = meetingStart;
		this.meetingEnd = meetingEnd;
	}

	public String getmeetingStart() {
		return meetingStart;
	}
	public void setmeetingStart(String meetingStart) {
		this.meetingStart = meetingStart;
	}
	public String getmeetingEnd() {
		return meetingEnd;
	}
	public void setmeetingEnd(String meetingEnd) {
		this.meetingEnd = meetingEnd;
	}



	@Override
	public String toString() {
		return "[" + meetingStart + ", " + meetingEnd + "]";
	}
	
	


}
