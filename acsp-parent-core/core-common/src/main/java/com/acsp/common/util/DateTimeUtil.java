package com.acsp.common.util;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigDecimal;
import java.util.Date;

public class DateTimeUtil {

  private static final DateTimeFormatter YYYYMMDD = DateTimeFormat.forPattern("yyyyMMdd");

  private static final DateTimeFormatter HHmmss = DateTimeFormat.forPattern("Hmmss");
  
  private static final DateTimeFormatter YYYYMMDD_HHmmss = DateTimeFormat.forPattern("yyyyMMdd Hmmss");

  private static final String PROPERTY_NAME_CONFIG_DATE_FORMAT = "yyyyMMdd";
  
  private static final DateTimeFormatter dateFormat = 
      DateTimeFormat.forPattern(PROPERTY_NAME_CONFIG_DATE_FORMAT);
  
  /**
   * 
   * @param dateTime DateTime to be converted to YYYYMMDD in Integer
   * @return YYYYMMDD in Integer of dateTime.
   */
  public static Integer getDatePart(DateTime dateTime) {

    if ( dateTime == null ) {

      return null;
    }

    try {

      return Integer.parseInt(YYYYMMDD.print(dateTime));
    } catch ( Exception ex ) {

      return null;
    }

  }



  /**
   * 
   * @param dateTime DateTime to be converted to HMMSS in Integer
   * @return HMMSS in Integer of dateTime.
   */
  public static Integer getTimePart(DateTime dateTime) {

    if ( dateTime == null ) {

      return null;
    }

    try {

      return Integer.parseInt(HHmmss.print(dateTime));

    } catch ( Exception ex ) {

      return null;
    }
  }


  /**
   * 
   * @param date Date to be converted to YYYYMMDD in Integer
   * @return YYYYMMDD in Integer of date.
   */
  public static Integer getDatePart(Date date) {

    if ( date == null ) {

      return null;
    }

    return getDatePart(new DateTime(date));

  }



  /**
   * 
   * @param date Date to be converted to HMMSS in Integer
   * @return HMMSS in Integer of date.
   */
  public static Integer getTimePart(Date date) {

    if ( date == null ) {

      return null;
    }

    return getTimePart(new DateTime(date));

  }


  /**
   * 
   * @param date java.util.Date to be converted.
   * @return Converted java.sql.Date from java.util.Date.
   */
  public static java.sql.Date toSqlDate(Date date) {

    if ( date == null ) {

      return null;
    }

    return new java.sql.Date(new DateTime(date).getMillis());

  }



  /**
   * 
   * @return YYYYMMDD representation of current date in String.
   */
  public static String getNowDateString() {

    try {

      return YYYYMMDD.print(new DateTime());
    } catch ( Exception ex ) {
      return null;
    }
  }


  /**
   * 
   * @return java.sql.Date version of current date.
   */
  public static java.sql.Date getCurrentSqlDate() {

    java.util.Date today = new java.util.Date();
    return new java.sql.Date(today.getTime());

  }


  /**
   * Transforms the DateTime(now) Object into BigDecimal Date used by the Old HPS Database
   * structure. from DateTime(now) into YYYYMMDD in BigDecimal Type.
   * 
   * @return BigDecimal
   */
  public static BigDecimal getDateAsYYYYMMDDFromDateTime() {

    DateTime now = new DateTime();
    return new BigDecimal(now.toString(dateFormat));
  }
  
  
  /**
   * Transform date in Integer type to java.util.Date type.
   * @param intDate
   * @return
   */
  public static Date intDateToUtilDate(Integer intDate) {

    if ( intDate == null ) {
      return null;
    }

    String strDate = String.valueOf(intDate);

    DateTime dateTime;
    try {
      dateTime = YYYYMMDD.parseDateTime(strDate);
    } catch ( Exception e ) {
      return null;
    }

    return dateTime.toDate();
  }

  
  /**
   * Transform date and time in Integer type to java.util.Date type. 
   * @param intDate
   * @param intTime
   * @return
   */
  public static Date intDateTimeToUtilDate(Integer intDate, Integer intTime) {

    if ( intDate == null || intTime == null ) {
      return null;
    }

    String strDate = String.valueOf(intDate);
    String strTime = String.valueOf(intTime);

    DateTime dateTime = YYYYMMDD_HHmmss.parseDateTime(strDate + " " + strTime);

    return dateTime.toDate();
  }

  
  /**
   * Return today's date with start of day time.  Time is mostly on midnight.
   * @return DateTime
   */
  public static DateTime getStartOfToday() {
	  return new DateTime().toLocalDate().toDateTimeAtStartOfDay();
  }
  
  
  /**
   * Return tomorrow's date with start of day time.  Time is mostly on midnight.
   * @return DateTime
   */
  public static DateTime getStartOfTomorrow() {
	  return getStartOfToday().plusDays(1);
  }
  
  
  /**
   * Check if input date is today regardless of time.
   * @return true if today, false otherwise.
   */
  public static boolean isToday(DateTime dateTime) {
	  return dateTime.toLocalDate().isEqual(new LocalDate());
  }
  
  
  /**
   * Check if input date is before today's start of day.
   * @return true if before today, false otherwise.
   */
  public static boolean isBeforeToday(DateTime dateTime) {
	  return dateTime.isBefore(getStartOfToday());
  }
  
  
  /**
   * Check if input date is after today's end of day.
   * @return true if after today, false otherwise.
   */
  public static boolean isAfterToday(DateTime dateTime) {
	  DateTime tomorrow = getStartOfTomorrow();
	  
	  return dateTime.isEqual(tomorrow) || dateTime.isAfter(tomorrow);
  }
  
}
