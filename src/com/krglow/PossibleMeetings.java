package com.krglow;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PossibleMeetings {

	public static List<PlannedMeeting> findFreeTime(Calendar calendar) {

		var meetingDuration = 30;

		var start = LocalTime.parse(calendar.getstartWork());
		var end = LocalTime.parse(calendar.getendWork());

		var freeTime = new ArrayList<PlannedMeeting>();

		PlannedMeeting[] meetingList = calendar.getMeetings();

		var length = meetingList.length;
		var endMeeting = start.plusMinutes(meetingDuration);

		for (var i = 0; i < length; i++) {

			var time1 = LocalTime.parse(meetingList[i].getstartTime());

			if (endMeeting.isBefore(time1) || endMeeting.equals(time1)) {

				while (endMeeting.isBefore(time1) || endMeeting.equals(time1)) {

					freeTime.add(new PlannedMeeting(start.toString(), endMeeting.toString()));
					start = endMeeting;
					endMeeting = start.plusMinutes(meetingDuration);

				}
			}

			if (endMeeting.isAfter(time1) || endMeeting.equals(time1)) {

				var time2 = LocalTime.parse(meetingList[i].getendTime());
				start = time2;
				endMeeting = start.plusMinutes(30);

			}
		}
		if (endMeeting.isBefore(end) || endMeeting.equals(end)) {

			while (endMeeting.isBefore(end) || endMeeting.equals(end)) {

				freeTime.add(new PlannedMeeting(start.toString(), endMeeting.toString()));
				start = endMeeting;
				endMeeting = start.plusMinutes(meetingDuration);

			}
		}

		return freeTime;

	}

	public static List<PlannedMeeting> availableTime(List<PlannedMeeting> list_1, List<PlannedMeeting> list_2) {

		var avaliableTime = new ArrayList<PlannedMeeting>();

		for (var i = 0; i < list_1.size(); i++) {
			for (var j = 0; j < list_2.size(); j++) {

				var element_1 = list_1.get(i);
				var element_2 = list_2.get(j);

				if (element_1.getstartTime().equals(element_2.getstartTime())) {
					avaliableTime.add(element_1);
				}
			}
		}
		//System.out.println(avaliableTime);
		PossibleMeetings.checkTheNeigbor(avaliableTime);
		System.out.println(avaliableTime);

		return avaliableTime;
	}

	public static List<PlannedMeeting> checkTheNeigbor(List<PlannedMeeting> list) {

		for (var i = 0; i < list.size(); i++) {

			for (var j = 1; j < list.size(); j++) {

				var element_2 = list.get(j);
				var element_1 = list.get(j - 1);
				var time1 = LocalTime.parse(element_1.getstartTime());
				var time2 = LocalTime.parse(element_2.getstartTime());

				if (time1.minusMinutes(30) == time2 || time2.minusMinutes(30) == time1) {
					element_1.setendTime(element_2.getendTime());
					list.remove(element_2);
				}
			}
		}

		return list;
	}

}
