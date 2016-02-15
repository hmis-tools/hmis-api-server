package org.openhmis.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.impl.cookie.DateUtils;

public class DateParser {
	public DateParser() {
		
	}

	/**
	 * Parse an input string using the date formats accepted by the API
	 * NOTE: to add a new valid date format, add to the list of known patterns.
	 * @param dateString
	 * @return
	 */
	public static Date parseDate(String dateString) {
		
		// Create a list of valid patterns
		List<SimpleDateFormat> knownPatterns = new ArrayList<SimpleDateFormat>();
		
		// Populate the list of valid patterns here
		knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd"));

		for (SimpleDateFormat pattern : knownPatterns) {
		    try {
		        // Take a try
		        return new Date(pattern.parse(dateString).getTime());

		    } catch (ParseException pe) {
		        // Loop on
		    }
		}
		return null;
	}
}
