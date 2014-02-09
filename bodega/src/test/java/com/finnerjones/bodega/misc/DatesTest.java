package com.finnerjones.bodega.misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class DatesTest {

	@Test
	public void createDateFromViewWithFormatddmmyyyy() {
		GregorianCalendar gregCal = createDateFromView("30.04.2001");
		Assert.assertNotNull(gregCal);
		Assert.assertEquals(GregorianCalendar.APRIL, gregCal.get(GregorianCalendar.MONTH));
	}

	private GregorianCalendar createDateFromView(String date) {
		String[] dateSplit = date.split("\\.");
		int day = new Integer(dateSplit[0]).intValue();
		int month = new Integer(dateSplit[1]).intValue() - 1;
		int year = new Integer(dateSplit[2]).intValue();
		return new GregorianCalendar(year, month, day);
	}

	@Test
	public void createDateUsingSimpleDateFormatGivenValue() {
		Date aDate = createDateUsingSimpleDateFormat("dd.MM.yyyy", "30.04.1971");
		Assert.assertTrue(aDate.getMonth() == 3);
	}

	private Date createDateUsingSimpleDateFormat(String pattern, String date) {
		Date aDate = null;
		try {
			aDate = new SimpleDateFormat(pattern).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return aDate;
	}

}
