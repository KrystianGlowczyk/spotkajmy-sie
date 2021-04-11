package com.krglow;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PossibleMeetings {

	public static List<PlannedMeeting> findFreeTime(Calendar calendar) {

		long meetingDuration = 30;

		LocalTime start = LocalTime.parse(calendar.getstartWork());
		LocalTime end = LocalTime.parse(calendar.getendWork());

		List<PlannedMeeting> freeTime = new ArrayList<PlannedMeeting>();

		PlannedMeeting[] meetingList = calendar.getMeetings();

		int length = meetingList.length;
		LocalTime endMeeting = start.plusMinutes(meetingDuration);

		for (int i = 0; i < length; i++) {

			LocalTime tmp = LocalTime.parse(meetingList[i].getmeetingStart());
			if (endMeeting.isBefore(tmp) || endMeeting.equals(tmp)) {

				while (endMeeting.isBefore(tmp) || endMeeting.equals(tmp)) {

					freeTime.add(new PlannedMeeting(start.toString(), endMeeting.toString()));
					start = endMeeting;
					endMeeting = start.plusMinutes(meetingDuration);

				}
			}
			
			if (endMeeting.isAfter(tmp) || endMeeting.equals(tmp)) {

				LocalTime tmp2 = LocalTime.parse(meetingList[i].getmeetingEnd());
				start = tmp2;
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

		List<PlannedMeeting> avaliableTime = new ArrayList<PlannedMeeting>();

		for (int i = 0; i < list_1.size(); i++) {
			for (int j = 0; j < list_2.size(); j++) {
				PlannedMeeting element_1 = list_1.get(i);
				PlannedMeeting element_2 = list_2.get(j);

				if (element_1.getmeetingStart().equals(element_2.getmeetingStart())) {
					avaliableTime.add(element_1);
				}
			}
		}
		// System.out.println(avaliableTime);
		PossibleMeetings.checkTheNeigbor(avaliableTime);
		System.out.println(avaliableTime);

		return avaliableTime;
	}

	public static List<PlannedMeeting> checkTheNeigbor(List<PlannedMeeting> list) {

		for (int i = 0; i < list.size(); i++) {

			for (int j = 1; j < list.size(); j++) {
				PlannedMeeting element_2 = list.get(j);
				PlannedMeeting element_1 = list.get(j - 1);
				LocalTime time1 = LocalTime.parse(element_1.getmeetingStart());
				LocalTime time2 = LocalTime.parse(element_2.getmeetingStart());

				if (((time1.getHour() - time2.getHour()) == 0)) {
					element_1.setmeetingEnd(element_2.getmeetingEnd());
					list.remove(element_2);
				}
			}
		}

		return list;
	}

}
