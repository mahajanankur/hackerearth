/**
 * 
 */
package com.time.joda;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author ankur.mahajan
 * @written 14-Jun-2018
 */
public class NewJodaTest {

	public static final String DEFAULT_TIME_ZONE = "Europe/Dublin";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String date = "2018/03/19";
		String time = "07:19";
		String concat = createJodaDateTimeFromString(date, time);
		getUtcTime(concat);
	}

	private static String createJodaDateTimeFromString(String date, String time) {
		String replacedDate = date.replace('/', '-');
		String dateTime = replacedDate + "T" + time;
		return dateTime;
	}

	private static void getUtcTime(String localStartDateTime) {
		DateFormat formatterLocalTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		formatterLocalTime.setTimeZone(TimeZone.getTimeZone(DEFAULT_TIME_ZONE)); // better
																		 // than
																		 // using
																		 // IST
		Date date;
		try {

			date = formatterLocalTime.parse(localStartDateTime);
			DateFormat formatterUTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
			formatterUTC.setTimeZone(TimeZone.getTimeZone("UTC")); // UTC
																	 // timezone

			DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZZ");
			LocalDateTime startDateTime = formatter.parseLocalDateTime(formatterUTC.format(date));
			System.out.println(startDateTime);

		}
		catch (ParseException e) {
			e.printStackTrace();
			// LOGGER.log(Level.SEVERE, "Error in employee absence data
			// getUtcTime : " + e.getMessage());
		}

	}

}
