package com.krglow;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		
		PlannedMeeting[] plans_1 = {
				new PlannedMeeting("09:00", "10:30"),
				new PlannedMeeting("12:00", "13:00"),
				new PlannedMeeting("16:00", "18:00"),
		};
		
		PlannedMeeting[] plans_2 = {
				new PlannedMeeting("10:00", "11:30"),
				new PlannedMeeting("12:30", "14:30"),
				new PlannedMeeting("14:30", "15:00"),
				new PlannedMeeting("16:00", "17:00"),
		};
		
		Calendar calendar1 = new Calendar("09:00", "19:55", plans_1);
		Calendar calendar2 = new Calendar("10:00", "18:30", plans_2);
	
		List<PlannedMeeting> freeTimes =PossibleMeetings.findFreeTime(calendar1);
		List<PlannedMeeting> freeTimes2 = PossibleMeetings.findFreeTime(calendar2);
		
		PossibleMeetings.availableTime(freeTimes, freeTimes2);
		
	}
	  


}
