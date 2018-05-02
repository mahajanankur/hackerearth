/**
 * 
 */
package com.time.joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * @author ankur.mahajan
 * @written 02-May-2018
 */
public class JodaTest {

	public static final String DEFAULT_TIME_ZONE = "Europe/Dublin";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DateTime startNormal = new DateTime(System.currentTimeMillis()).withTimeAtStartOfDay().plusHours(8);
		System.out.println("Normal : " + startNormal);
		DateTime startUTC = new DateTime(System.currentTimeMillis(), DateTimeZone.UTC).withTimeAtStartOfDay().plusHours(8);
		System.out.println("UTC : " + startUTC);
		DateTime startNormalToUTC = new DateTime(
				new DateTime(System.currentTimeMillis(), DateTimeZone.forID(DEFAULT_TIME_ZONE)).withTimeAtStartOfDay()
						.plusHours(8),
				DateTimeZone.UTC);
		System.out.println("Normal To UTC : " + startNormalToUTC);

		System.out.println("???? : " + getNewDateTimeInSpecifiedZone(startNormal, DEFAULT_TIME_ZONE));

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
