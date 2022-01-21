package com.test.ezypay.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class DateUtil {
	 public static final String DefaultFormat = "dd/MM/yyyy";
	 public static final String DateTimeFormat = "yyyy-MM-dd";
	 private static final SimpleDateFormat sdfdt = new SimpleDateFormat(DateTimeFormat);
	 
	public static String dateToString(Date date, String format) {
		return dateToString(format, date);
	}

	public static String dateToString(String format, Date date) {
		if (format == null)
			format = "yyyy-MM-dd HH:mm:ss";
		if (date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static Date stringToDate(Object obj) {
		if (obj == null)
			return null;
		String date = obj.toString().trim();
		if (date.isEmpty())
			return null;
		try {
			return sdfdt.parse(date.trim());
		} catch (ParseException e) {
			return null;
		}
	}

	public static Set<String> process(Date StartDate, Date EndDate, long diffDays) {
		Set<String> dates = new LinkedHashSet<>();

		if (StartDate.equals(EndDate) || StartDate.compareTo(EndDate) > 0)
			return null;

		dates.add(DateUtil.dateToString(StartDate, DefaultFormat));
		Date tmp = StartDate;
		while (tmp.compareTo(EndDate) <= 0) {
			dates.add(DateUtil.dateToString(tmp, DefaultFormat));
			tmp = new Date(tmp.getTime() + diffDays * 3600 * 24 * 1000);
		}
		return dates;
	}

	public static Date getWeekOfDay(String date, String day) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dt = LocalDate.parse(date, formatter);
		Date newDate = new Date();
		while (!(dt.getDayOfWeek().toString().equals(day))) {
			dt = dt.plusDays(1);
		}
		return newDate = Date.from(dt.atStartOfDay(ZoneId.systemDefault()).toInstant());

	}

	public static Date getMonthOfDay(String date, int day) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dt = LocalDate.parse(date, formatter);
		Date newDate = new Date();
		while (!(dt.getDayOfMonth() == day)) {
			dt = dt.plusDays(1);
		}
		return newDate = Date.from(dt.atStartOfDay(ZoneId.systemDefault()).toInstant());

	}

}
