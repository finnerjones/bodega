package com.finnerjones.bodega.misc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class RegexTests {

	private static final String DATE_FORMAT_DD_DOT_MM_DOT_YYYY = "(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((19|20)\\d\\d)";

	@Test
	public void dateIsInCorrectFormat() {
		Pattern pattern = Pattern.compile(DATE_FORMAT_DD_DOT_MM_DOT_YYYY);
		Matcher matcher = pattern.matcher("30.04.1971");
		Assert.assertTrue(matcher.matches());
	}

}
