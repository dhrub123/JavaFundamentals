package six.dateandtime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class DateTimeDemo {

	public static void main(String[] args) {
		
		//DATE OPERATIONS
		//---------------
		// get current date
		LocalDate date = LocalDate.now();
		System.out.println("Today's date is " + date);

		// specific date using LocalDate.of()
		date = LocalDate.of(2019, 8, 03);
		System.out.println(date);
		date = LocalDate.of(2019, Month.AUGUST, 03);
		System.out.println(date);

		// specific date using parse()
		date = LocalDate.parse("2015-02-12");
		System.out.println(date);
		date = LocalDate.parse("12/02/2012", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(date);

		// Adding days and months to a given date
		date = LocalDate.parse("2015-02-12").plusDays(4);
		System.out.println(date);
		date = LocalDate.parse("2015-02-12").plus(4, ChronoUnit.DAYS);
		System.out.println(date);

		// getting day of week
		DayOfWeek dayOfWeek = LocalDate.parse("2015-02-12").getDayOfWeek();
		System.out.println(dayOfWeek);

		// check if date is before or after given date
		boolean isBefore = LocalDate.parse("2015-02-12").isBefore(LocalDate.parse("2016-02-12"));
		System.out.println(isBefore);
		boolean isAfter = LocalDate.parse("2015-02-12").isAfter(LocalDate.parse("2016-02-12"));
		System.out.println(isAfter);
		
		//TIME OPERATIONS(Local Time is time without date)
		//---------------
		//get current time
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		//get specific time using LocalTime.of() 
		time = LocalTime.of(11, 25); //hr,min
		System.out.println(time);
		
		time = LocalTime.of(11, 25, 03); //hr,min,sec
		System.out.println(time);
		
		time = LocalTime.of(11, 25, 03, 324); //hr,min,sec,nanosec
		System.out.println(time);
		
		//get specific time using parse()
		time = LocalTime.parse("08:27");
		System.out.println(time);
		
		time = LocalTime.parse("08:27", DateTimeFormatter.ofPattern("HH:mm"));
		System.out.println(time);
		
		//Add seconds, minutes or hours
		time = LocalTime.parse("12:54:53").plusSeconds(4);
		System.out.println(time);
		
		time = LocalTime.parse("12:54:53").plusHours(2);
		System.out.println(time);
		
		time = LocalTime.parse("12:54:53").plusMinutes(3);
		System.out.println(time);
		
		time = LocalTime.parse("12:54:53").plus(4, ChronoUnit.MINUTES);
		System.out.println(time);
		
		//getting minute from time
		int minute = LocalTime.parse("12:54:53").getMinute();
		System.out.println(minute);
		
		//isBefore or After
		isBefore = LocalTime.parse("12:54:53").isBefore(LocalTime.parse("11:54:53"));
		System.out.println(isBefore);
		isAfter = LocalTime.parse("12:54:53").isAfter(LocalTime.parse("11:54:53"));
		System.out.println(isAfter);
		
		//DATETIME OPERATIONS
		//--------------------
		
		//get current date and time
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		
		//specific date  time using of method
		dateTime = LocalDateTime.of(2019, 05, 03, 12, 53);
		System.out.println(dateTime);
		
		dateTime = LocalDateTime.of(2019, Month.MAY, 03, 12, 53);
		System.out.println(dateTime);
		
		//specific date  time using parse method
		dateTime = LocalDateTime.parse("2020-06-20T07:54:00");
		System.out.println(dateTime);
		
		//modify given date and time
		dateTime = LocalDateTime.parse("2020-06-20T07:54:00").plusDays(4);
		System.out.println(dateTime);
		
		dateTime = LocalDateTime.parse("2020-06-20T07:54:00").minusMonths(3);
		System.out.println(dateTime);
		
		//DATETIME OPERATIONS - ZONED
		//---------------------------
		
		//get zone ids of a given zone or all zone ids
		ZoneId zoneId = ZoneId.of("America/Marigot");
		System.out.println(zoneId);
		
		Set<String> zoneIdList = ZoneId.getAvailableZoneIds();
		for(String zone : zoneIdList) {
			System.out.println(zone);
		}
		
		//creating a zoned date time
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println(zonedDateTime);
		
		zonedDateTime = ZonedDateTime.of(2020, 10, 15, 23 ,45, 59, 1234, zoneId);
		System.out.println(zonedDateTime);
		
		//fetching date time of a zoned date time
		System.out.println("Year = " + zonedDateTime.getYear() + 
						   " Month = " + zonedDateTime.getMonth() + 
						   " dayOfMonth = " + zonedDateTime.getDayOfMonth() + 
						   " dayOfWeek = " + zonedDateTime.getDayOfWeek() + 
						   " dayOfYear = " + zonedDateTime.getDayOfYear() + 
						   " hour = " + zonedDateTime.getHour() + 
						   " minute = " + zonedDateTime.getMinute() +
						   " second = " + zonedDateTime.getSecond() +
						   " nano = " + zonedDateTime.getNano());
		
		//Modifying date and time
		System.out.println(zonedDateTime.plusYears(1));
		System.out.println(zonedDateTime.plusMonths(1));
		System.out.println(zonedDateTime.plusDays(15));
		System.out.println(zonedDateTime.plusHours(12));
		System.out.println(zonedDateTime.plusMinutes(67));
		System.out.println(zonedDateTime.plusSeconds(167));
		System.out.println(zonedDateTime.plusNanos(19876));
		System.out.println(zonedDateTime.minusYears(1));
		System.out.println(zonedDateTime.minusMonths(1));
		System.out.println(zonedDateTime.minusDays(15));
		System.out.println(zonedDateTime.minusHours(12));
		System.out.println(zonedDateTime.minusMinutes(67));
		System.out.println(zonedDateTime.minusSeconds(167));
		System.out.println(zonedDateTime.minusNanos(19876));
	}

}
