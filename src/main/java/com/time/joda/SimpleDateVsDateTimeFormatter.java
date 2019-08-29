/**
 * 
 */
package com.time.joda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author ankur.mahajan
 * @written 12-Jul-2019
 */
public class SimpleDateVsDateTimeFormatter {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		// simpleVsDateTime();
		// dateTimeToSimple();
		dateTimeToSimpleByDateTimePrint();
	}

	private static void dateTimeToSimple() {
		String date = "2019-07-12 23:59:59";
		DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss").withZoneUTC();
		DateTime parseDateTime = formatter.parseDateTime(date);
		System.out.println(parseDateTime);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
		String format = simpleDateFormat.format(parseDateTime.toDate());
		System.out.println(format);

	}

	private static void dateTimeToSimpleByDateTimePrint() {
		String date = "2019-07-12 23:59:59";
		DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss").withZoneUTC();
		DateTime parseDateTime = formatter.parseDateTime(date);
		System.out.println(parseDateTime);
		DateTimeFormatter outFormatter = DateTimeFormat.forPattern("YYYY-MM-dd").withZoneUTC();
		String format = outFormatter.print(parseDateTime);
		System.out.println(format);

	}

	private static void simpleVsDateTime() throws ParseException {
		String date = "2019-07-12 13:01:01";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		Date simpleDate = simpleDateFormat.parse(date);
		System.out.println(simpleDate);

		DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss").withZoneUTC();
		DateTime parseDateTime = formatter.parseDateTime(date);
		DateTime startDay = parseDateTime.withTimeAtStartOfDay();
		DateTime endDay = startDay.plusDays(1).minusSeconds(1);
		System.out.println("Start : " + startDay.toString() + " End : " + endDay);
		System.out.println("UTC : " + parseDateTime);

		System.out.println("Start String : " + formatter.print(startDay) + " End : " + endDay);

		// DateTime utcDate = new DateTime(parseDateTime, DateTimeZone.UTC);
		// System.out.println(utcDate);

	}

}
