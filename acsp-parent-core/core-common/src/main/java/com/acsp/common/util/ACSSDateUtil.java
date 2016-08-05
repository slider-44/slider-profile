package com.acsp.common.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigDecimal;

/**
 * Utility Class for Date Manipulations and Conversions. The most common operation will be
 * converting DateTime object into BigDecimal with YYYYMMDD format and LocalTime object into
 * BigDecimal with HHMMSS format.
 * 
 * @author gvargas
 *
 */
public class ACSSDateUtil {

  private static final String PROPERTY_NAME_CONFIG_DATE_FORMAT = "yyyyMMdd";

  private static final String PROPERTY_NAME_CONFIG_TIME_FORMAT = "HHmmss";

  private static final String PROPERTY_NAME_CONFIG_DATETIME_FORMAT = "yyyyMMddHHmmss";

  private static final DateTimeFormatter dateFormat = DateTimeFormat.forPattern(PROPERTY_NAME_CONFIG_DATE_FORMAT);

  private static final DateTimeFormatter timeFormat = DateTimeFormat.forPattern(PROPERTY_NAME_CONFIG_TIME_FORMAT);

  private static final DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern(PROPERTY_NAME_CONFIG_DATETIME_FORMAT);

  /**
   * Transforms from BigDecimal with this format YYYYMMDDHHmmss into DateTime object.
   * 
   * @param datetime BigDecimal representation of date time.
   * @return DateTime equivalent of datetime parameter.
   */
  public static DateTime getDateAsDateTimeFromBigDecimalDateTime(BigDecimal datetime) {

    final DateTimeZone dtz = DateTimeZone.forID("GMT");
    return dateTimeFormat.parseLocalDateTime(datetime.toString()).toDateTime(dtz);
  }

  /**
   * Transforms the DateTime(now) Object into BigDecimal Date used by the Old HPS Database
   * structure. from DateTime(now) into YYYYMMDDHHmmss in BigDecimal Type.
   * 
   * @return BigDecimal
   */
  public static BigDecimal getDateAsYYYYMMDDHHmmssFromDateTime() {

    DateTime now = new DateTime();
    return new BigDecimal(now.toString(dateTimeFormat));
  }

  /**
   * Transforms the DateTime Object into BigDecimal Date used by the Old HPS Database structure.
   * from DateTime into YYYYMMDDHHmmss in BigDecimal Type.
   * 
   * @param jodaDateTime DateTime instance to convert to BigDecimal
   * @return BigDecimal (in YYYYMMDDHHmmss)
   */
  public static BigDecimal getDateAsYYYYMMDDHHmmssFromDateTime(DateTime jodaDateTime) {

    DateTime now = jodaDateTime;
    return new BigDecimal(now.toString(dateTimeFormat));
  }

  /**
   * Transforms from BigDecimal with this format YYYYMMDD into DateTime object.
   * 
   * @param date BigDecimal date representation to convert to DateTime.
   * @return DateTime conversion of BigDecimal parameter.
   */
  public static DateTime getDateAsDateTimeFromBigDecimal(BigDecimal date) {

    final DateTimeZone dtz = DateTimeZone.forID("GMT");
    return dateFormat.parseLocalDateTime(date.toString()).toDateTime(dtz);
  }

  /**
   * Transforms the DateTime Object into BigDecimal Date used by the Old HPS Database structure.
   * from DateTime into YYYYMMDD in BigDecimal Type.
   * 
   * @param jodaDateTime DateTime instance to convert to BigDecimal representation.
   * @return BigDecimal (in YYYYMMDD)
   */
  public static BigDecimal getDateAsYYYYMMDDFromDateTime(DateTime jodaDateTime) {

    DateTime now = jodaDateTime == null ? new DateTime()
                                        : jodaDateTime;
    return new BigDecimal(now.toString(dateFormat));
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
   * Transforms the LocalTime Object into BigDecimal Time used by the old HPS Database structure.
   * from LocalTime into HHMMSS in BigDecimal Type.
   * 
   * @param jodaDateTime LocalTime instance to convert to BigDecimal representation.
   * @return BigDecimal conversion of LocalTime parameter.
   */
  public static BigDecimal getTimeAsHHMMSSFromLocalTime(LocalTime jodaDateTime) {

    LocalTime now = jodaDateTime;
    return new BigDecimal(now.toString(timeFormat));
  }

  /**
   * Transforms the BigDecimal Object into LocalTime Time from BigDecimal into HHMMSS in LocalTime
   * Type.
   * 
   * @param date BigDecimal represented date to convert to LocalTime.
   * @return LocalTime conversion of the date parameter.
   */
  public static LocalTime getTimeAsLocalTimeFromBigDecimal(BigDecimal date) {

    // format the number into 6 digit padded by zeroes.
    String convertThis = String.format("%06d", date.intValue());
    return timeFormat.parseLocalTime(convertThis);
  }

  /**
   * 
   * @return BigDecimal representation of current date.
   */
  public static BigDecimal getTimeAsHHMMSSFromDateTime() {

    LocalTime now = new LocalTime();
    return new BigDecimal(now.toString(timeFormat));
  }
}
