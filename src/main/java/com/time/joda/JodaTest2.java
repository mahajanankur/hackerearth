/**
 * 
 */
package com.time.joda;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author ankur.mahajan
 * @written 02-May-2018
 */
public class JodaTest2 {

	public static final String DEFAULT_TIME_ZONE = "Europe/Dublin";

	/**
	 * @param args
	 * @throws ParseException
	 */

	public static void main(String[] args) {
		// test1();
		// test2();
		// test3();
		// utcToLocalToUTC();
		dateTimeFromDate();
	}

	private static void dateTimeFromDate() {
		// String da = "2018-03-25";
		// String da = "2018-03-25 04:12:00.0";
		String da = "2018-12-10T00:00:00.000Z";
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		// formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
		formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		DateTime startDate = formatter.parseDateTime(da).withZoneRetainFields(DateTimeZone.UTC);

		DateTime end = startDate.plusDays(1).minusSeconds(1);// .withSecondOfMinute(0);

		DateTime testWithZone = formatter.parseDateTime(da).withZone(DateTimeZone.UTC);

		System.out.println("Start in UTC : " + startDate);
		System.out.println("End in UTC : " + end);
		System.out.println("End in UTC WithZone : " + testWithZone);

	}

	private static void utcToLocalToUTC() {
		String da = "2018-03-25 04:12:00.0";
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
		DateTime dt1 = formatter.parseDateTime(da).withZoneRetainFields(DateTimeZone.UTC);
		DateTime local = new DateTime(dt1).withZone(DateTimeZone.forID("Europe/Dublin"));

		DateTime utcStart = local.withTimeAtStartOfDay();

		DateTime utcStart1 = new DateTime(utcStart).withZone(DateTimeZone.forID("Europe/Dublin"));
		if (dt1.getMillis() == local.getMillis()) {
			System.out.println("Equal");
		}

		System.out.println("String to UTC : " + dt1);
		System.out.println("UTC to LOCAL : " + local);
		System.out.println("Start Local to UTC : " + utcStart);
		System.out.println("Start Local to UTC Timezone : " + utcStart1);

	}

	private static void test3() {
		// String da = "2018-12-01T18:30:00.000Z";
		// String da = "2018-12-04 04:12:00.0";
		String da = "2018-03-25 04:12:00.0";

		// DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy
		// HH:mm:ss");
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
		// DateTimeFormatter formatter =
		// DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		// DateTime dt = formatter.parseDateTime(da).withZone(DateTimeZone.UTC);
		DateTime dt = formatter.parseDateTime(da);
		DateTime dt1 = formatter.parseDateTime(da).withZoneRetainFields(DateTimeZone.UTC);
		DateTime withZone = new DateTime(dt).withZone(DateTimeZone.forID("Europe/Dublin"));
		DateTime withZone1 = new DateTime(dt1).withZone(DateTimeZone.forID("Europe/Dublin"));

		DateTime dt3 = new DateTime(formatter.parseDateTime(da).withZoneRetainFields(DateTimeZone.UTC),
				(DateTimeZone.forID("Europe/Dublin")));

		System.out.println("First : " + dt);
		System.out.println("Second : " + withZone);
		System.out.println("Third : " + dt1);
		System.out.println("Fourth : " + withZone1);

	}

	private static void test2() {
		DateTime startNormal = new DateTime(System.currentTimeMillis()).withTimeAtStartOfDay().plusHours(8);
		DateTime withDayOfYear = startNormal.withDayOfYear(1)
				.withZoneRetainFields(DateTimeZone.forID(DEFAULT_TIME_ZONE));
		DateTime testDate = startNormal.withDayOfYear(1); //
		System.out.println("???? : " + getNewDateTimeInSpecifiedZone(testDate, DEFAULT_TIME_ZONE));
		DateTime localDt = new DateTime(testDate).withZoneRetainFields(DateTimeZone.UTC)
				.withZone(DateTimeZone.getDefault()); // System.out.println(localDt);
														// //
		System.out.println("???? : " + getNewDateTimeInSpecifiedZone(localDt, DEFAULT_TIME_ZONE));
		int hourOfDay = testDate.getHourOfDay();
		LocalDateTime localDateTime = new DateTime(2017, 02, 02, 8, 0, 0, 0, DateTimeZone.forID(DEFAULT_TIME_ZONE))
				.toLocalDateTime();
		DateTime dateTime = localDateTime.toDateTime(DateTimeZone.forID(DEFAULT_TIME_ZONE));
		DateTime dateTime2 = new DateTime(2017, 05, 15, 8, 0, 0, 0, DateTimeZone.forID(DEFAULT_TIME_ZONE));
		System.out.println(dateTime);
		System.out.println(dateTime2);
		test1();

	}

	private static String getNewDateTimeInSpecifiedZone(DateTime localDt, String defaultTimeZone) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void test1() {
		// DateTime startNormal = new
		// DateTime(System.currentTimeMillis()).withTimeAtStartOfDay().plusHours(8);
		// System.out.println(startNormal);
		// System.out.println(startNormal.getHourOfDay());
		// String date = "1970-01-01T";
		// DateTime dateTime = new DateTime(1970, 1, 1,
		// startNormal.getHourOfDay(), startNormal.getMinuteOfHour(),
		// startNormal.getSecondOfMinute(), startNormal.getMillisOfSecond(),
		// DateTimeZone.UTC);
		// System.out.println(dateTime);

		// String da = "1970-01-10 08:00:00.00";
		String da = "2018-12-01T18:30:00.000Z";
		// String da = "04/02/2011 20:27:05";
		// DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy
		// HH:mm:ss");
		// DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd
		// HH:mm:ss");
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		// DateTime dt = formatter.parseDateTime(da).withZone(DateTimeZone.UTC);
		DateTime dt = formatter.parseDateTime(da).withZone(DateTimeZone.UTC);
		System.out.println("First : " + dt);
		DateTime dateTime = new DateTime(1970, 1, 1, dt.getHourOfDay(), dt.getMinuteOfHour(), dt.getSecondOfMinute(),
				dt.getMillisOfSecond(), DateTimeZone.UTC);
		System.out.println("Sec : " + dateTime);
		// DateTime startNormal1 = new
		// DateTime(System.currentTimeMillis()).withZone(DateTimeZone.UTC);
		// System.out.println("Millis to DT: " + startNormal1);

	}

	public static DateTime getDateTimeInUTC(DateTime inputDateTime) {
		DateTime utcDate = new DateTime(inputDateTime, DateTimeZone.UTC);
		return utcDate;
	}
}
