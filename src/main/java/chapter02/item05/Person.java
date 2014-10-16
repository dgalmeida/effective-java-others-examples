package chapter02.item05;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person
{
	private final Date birthDate;

	public Person(Date brDate){this.birthDate = brDate;}

	// DON'T DO THIS!!
	public boolean isBabyBoomer()
	{
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomStart = gmtCal.getTime();

		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 1);
		Date boomEnd = gmtCal.getTime();

		return birthDate.compareTo(boomStart) >= 0
				&& birthDate.compareTo(boomEnd) < 0;
	}

	
	// INSTEAD DO THIS:
	private static final Date BOOM_START;
	private static final Date BOOM_END;

	static
	{
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_START = gmtCal.getTime();

		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 1);
		BOOM_END = gmtCal.getTime();
	}

	public boolean isBoomer()
	{
		return birthDate.after(BOOM_START) && birthDate.before(BOOM_END);
	}
}
