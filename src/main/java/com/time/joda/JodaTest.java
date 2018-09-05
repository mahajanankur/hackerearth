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
public class JodaTest {

	public static final String DEFAULT_TIME_ZONE = "Europe/Dublin";

	/**
	 * @param args
	 * @throws ParseException
	 */
	/*
	 * public static void main(String[] args) {
	 * DateTime startNormal = new
	 * DateTime(System.currentTimeMillis()).withTimeAtStartOfDay().plusHours(8);
	 * DateTime withDayOfYear =
	 * startNormal.withDayOfYear(1).withZoneRetainFields(DateTimeZone.forID(
	 * DEFAULT_TIME_ZONE));
	 * DateTime testDate = startNormal.withDayOfYear(1);
	 * // System.out.println("???? : " +
	 * // getNewDateTimeInSpecifiedZone(testDate, DEFAULT_TIME_ZONE));
	 * // DateTime localDt = new
	 * // DateTime(testDate).withZoneRetainFields(DateTimeZone.UTC).withZone(
	 * DateTimeZone.getDefault());
	 * // System.out.println(localDt);
	 * // System.out.println("???? : " + getNewDateTimeInSpecifiedZone(localDt,
	 * // DEFAULT_TIME_ZONE));
	 * int hourOfDay = testDate.getHourOfDay();
	 * LocalDateTime localDateTime = new DateTime(2017, 02, 02, 8, 0, 0, 0,
	 * DateTimeZone.forID(DEFAULT_TIME_ZONE)).toLocalDateTime();
	 * DateTime dateTime =
	 * localDateTime.toDateTime(DateTimeZone.forID(DEFAULT_TIME_ZONE));
	 * DateTime dateTime2 = new DateTime(2017, 05, 15, 8, 0, 0, 0,
	 * DateTimeZone.forID(DEFAULT_TIME_ZONE));
	 * System.out.println(dateTime);
	 * System.out.println(dateTime2);
	 * // test1();
	 * }
	 */

	public static void main(String[] args) throws ParseException {
		String date = "2018/06/13";
		String time = "00:00";
		// 2018-06-13 23:00:00
		String concat = createJodaDateTimeFromString(date, time);
		LocalDateTime localDateTimeTest = localDateTimeTest(concat);
		DateTime dateTime = new DateTime(concat);
		// Conversion from one TIMEZONE to another. -- START
		DateTime dateTimeIST = new DateTime(concat, DateTimeZone.forID(DEFAULT_TIME_ZONE));
		System.out.println("IST : " + dateTimeIST);
		DateTime dateTimeISTUTC = new DateTime(dateTimeIST, DateTimeZone.UTC);
		System.out.println("IST TO UTC : " + dateTimeISTUTC);
		// Conversion from one TIMEZONE to another.-- END
		DateTime dateTimeInUTC = getDateTimeInUTC(dateTime);
		DateTime dateTimeInIRE = getDateTimeInIRE(dateTime);
		DateTime newDateTimeInSpecifiedZone = getNewDateTimeInSpecifiedZone(dateTime, "UTC");
		System.out.println("LOCAL : " + dateTime);
		System.out.println("UTC TIME : " + dateTimeInUTC);
		System.out.println("IST TIME : " + dateTimeInIRE);
		System.out.println("LOCAL TIME TESTTTTT: " + localDateTimeTest);

		System.out.println("NEW UTC TIME : " + newDateTimeInSpecifiedZone);

	}

	public static LocalDateTime localDateTimeTest(String inputDateTime) throws ParseException {
		DateFormat formatterLocalTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		formatterLocalTime.setTimeZone(TimeZone.getTimeZone(DEFAULT_TIME_ZONE));
		Date date = formatterLocalTime.parse(inputDateTime);
		DateFormat formatterUTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		formatterUTC.setTimeZone(TimeZone.getTimeZone("UTC")); // UTC
																 // timezone

		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZZ");
		LocalDateTime startDateTime = formatter.parseLocalDateTime(formatterUTC.format(date));
		return startDateTime;
	}

	public static DateTime getDateTimeInUTC(DateTime inputDateTime) {
		DateTime utcDate = new DateTime(inputDateTime, DateTimeZone.UTC);
		return utcDate;
	}

	public static DateTime getDateTimeInIRE(DateTime inputDateTime) {
		DateTime utcDate = new DateTime(inputDateTime, DateTimeZone.forID("Europe/Dublin"));
		return utcDate;
	}

	private static String createJodaDateTimeFromString(String date, String time) {
		String replacedDate = date.replace('/', '-');
		String dateTime = replacedDate + "T" + time;
		return dateTime;
	}

	private static void test1() {
		DateTime startNormal = new DateTime(System.currentTimeMillis()).withTimeAtStartOfDay().plusHours(8);
		System.out.println("Normal : " + startNormal);
		DateTime startUTC = new DateTime(System.currentTimeMillis(), DateTimeZone.UTC).withTimeAtStartOfDay().plusHours(8);
		System.out.println("UTC : " + startUTC);
		// TODO - TAKE THIS FOR LOCAL TO UTC CONVERSION
		DateTime startNormalToUTC = new DateTime(new DateTime(System.currentTimeMillis(), DateTimeZone.forID(DEFAULT_TIME_ZONE))
				.withTimeAtStartOfDay().plusHours(8), DateTimeZone.UTC);
		System.out.println("Normal To UTC : " + startNormalToUTC);

		System.out.println("???? : " + getNewDateTimeInSpecifiedZone(startNormal, DEFAULT_TIME_ZONE));

		System.out.println("Basic :: " + startNormal.withDayOfYear(1));

		System.out.println(startNormal.getChronology().getZone());
		DateTime startDate = new DateTime(startNormal.withDayOfYear(1), DateTimeZone.forID(DEFAULT_TIME_ZONE));

		// DateTime startDate = new DateTime(startNormal,
		// DateTimeZone.forID(startNormal.getChronology().getZone().toString()));
		DateTime withDayOfYear = startNormal.withDayOfYear(1);
		DateTime dateTimeUTC = new DateTime(withDayOfYear, DateTimeZone.UTC);
		System.out.println();
		System.out.println("TRY BETA : " + getNewDateTimeInSpecifiedZone(dateTimeUTC, DEFAULT_TIME_ZONE));
		DateTime dateTimeInIR = new DateTime(new DateTime(withDayOfYear, DateTimeZone.UTC).withTimeAtStartOfDay().plusHours(8),
				DateTimeZone.forID(DEFAULT_TIME_ZONE));

		System.out.println("Start Of The Year : " + dateTimeInIR);

	}

	public static DateTime getNewDateTimeInSpecifiedZone(DateTime inputDateTime, String siteTimeZone) {
		// DateTime(2017, 05, 15, 8, 0, 0,
		// 0,DateTimeZone.forID(ApplicationConstants.DEFAULT_SITE_TIME_ZONE));
		if (siteTimeZone.isEmpty()) {
			siteTimeZone = DEFAULT_TIME_ZONE;
		}
		DateTime timeZoneDate = new DateTime(inputDateTime.getYear(), inputDateTime.getMonthOfYear(),
				inputDateTime.getDayOfMonth(), inputDateTime.getHourOfDay(), inputDateTime.getMinuteOfHour(),
				inputDateTime.getSecondOfMinute(), inputDateTime.getMillisOfSecond(), DateTimeZone.forID(siteTimeZone));
		return timeZoneDate;
	}

}
