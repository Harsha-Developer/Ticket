package com.agilecrm.util;

import java.text.SimpleDateFormat;

import com.google.protobuf.TextFormat.ParseException;

public class Date {
	

		public static String toDate(String dateString) throws ParseException {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return(sdf.format(new java.util.Date(System.currentTimeMillis())));
				
		}

		public static String toDateTime(String dateString) throws ParseException {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return(sdf.format(new java.util.Date(System.currentTimeMillis())));
		}
}
