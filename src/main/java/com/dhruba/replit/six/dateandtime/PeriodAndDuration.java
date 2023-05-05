package six.dateandtime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodAndDuration {

	public static void main(String[] args) {
		// Amount of time -- Period(date based, used to find difference between dates)
		// and Duration(time based, used to find difference between times)

		// PERIOD
		// ------
		Period period = Period.ofDays(5);
		System.out.println(period.getDays());

		period = Period.ofMonths(3);
		System.out.println(period.getMonths());

		period = Period.ofYears(1);
		System.out.println(period.getYears());

		period = Period.of(2, 5, 12);
		System.out.println(period.getDays());
		System.out.println(period.getMonths());
		System.out.println(period.getYears());

		// get difference between 2 dates
		period = Period.between(LocalDate.parse("2020-05-18"), LocalDate.parse("2021-03-19"));
		System.out.println(period);

		// get specific value from period
		System.out.println("Difference is " + period.getYears() + " years " + period.getMonths() + " months "
				+ period.getDays() + " days");

		// DURATION
		// --------
		Duration duration = Duration.ofDays(1);
		System.out.println(duration.getSeconds());

		duration = Duration.ofHours(2);
		System.out.println(duration.getSeconds());

		duration = Duration.ofMinutes(21);
		System.out.println(duration.getSeconds());

		duration = Duration.of(1, ChronoUnit.HOURS);
		System.out.println(duration.getSeconds());

		// difference between 2 values
		duration = Duration.between(LocalTime.parse("12:15"), LocalTime.parse("13:16"));
		System.out.println(duration.getSeconds());
	}

}
