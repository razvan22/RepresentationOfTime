package com.company;

import java.lang.invoke.LambdaConversionException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class RepresentationOfTime {
    public static void daysSinceBorn(){
        LocalDate currentDate = LocalDate.now();
        LocalDate myDateOfBirth = LocalDate.of(1989, Month.JUNE, 15);
        long daysSinceIWasBorn = ChronoUnit.DAYS.between(myDateOfBirth, currentDate);
        System.out.println(daysSinceIWasBorn + " days have passed since I was born");
    }


    public static void newYorkToSwedenTime(){
        DateTimeFormatter usFormat = DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm a").withLocale(Locale.US);
        DateTimeFormatter swedenFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime nyCurrentTime = LocalDateTime.parse("03-05-2020 09:17 AM", usFormat);
        ZonedDateTime nyZone = ZonedDateTime.of(nyCurrentTime, ZoneId.of("America/New_York"));
        ZonedDateTime seZone = nyZone.toInstant().atZone(ZoneId.of("Europe/Stockholm"));
        System.out.println("The New-York date/hour : "+usFormat.format(nyCurrentTime)+ " in Sweden is : "+swedenFormat.format(seZone));
    }


    public  static void numberOFFridaysSince1190(){
        int numberOfFriday = 0;
        for(int year = 1990; year < LocalDate.now().getYear(); year++){
            for (int i = 1; i < 13; i++){
                LocalDate date = LocalDate.parse(String.format("%d-%02d-13", year, i));
                if (date.getDayOfWeek() == DayOfWeek.of(5)){
                    numberOfFriday++;
                }
            }
        }
        System.out.println("Number of Fridays the 13 since 1990 is = " + numberOfFriday);
    }

    public  static void daysSpentOnWc(){
        LocalDate currentDate = LocalDate.now();
        LocalDate dateOfEighty = currentDate.plusYears(80);
        long numberOfDaysUntilEighty = ChronoUnit.DAYS.between(currentDate, dateOfEighty);
        long totalMinutes = 27 * numberOfDaysUntilEighty;
        System.out.println(minutesToDays(totalMinutes)+" days we will stay on the toilet :) " );
    }

    private static long minutesToDays(long minutes){
        long h = minutes / 60;
        long d = h / 24;
        return d;
    }
    public void freeTimeInEightyYears(){

        
    }
    public static void totalHoursBetweenAgeOf18_80(){
        int workingDaysPerWeek = 5;
        int weekendDays = 2;
        int hoursPerDay = 24;
        int weekDays = 7;
        int numberOfWeeksInYear = 52;


        LocalDate myDateOfBirth = LocalDate.of(1989, Month.JUNE, 15);
        LocalDate schoolAge = myDateOfBirth.plusYears(7);
        LocalDate eighteenYears = myDateOfBirth.plusYears(18);
        LocalDate ageOfSixtyFive = myDateOfBirth.plusYears(65);
        LocalDate ageOfEighty = myDateOfBirth.plusYears(80);
        //weeks
        long numberOfActiveWeeks = ChronoUnit.WEEKS.between(schoolAge, ageOfSixtyFive);
        //days
        long numberOfDaysIn80Years = ChronoUnit.DAYS.between(myDateOfBirth, ageOfEighty);
        long semiActiveDays = ChronoUnit.DAYS.between(myDateOfBirth, schoolAge);
        long activeDays = ChronoUnit.DAYS.between(schoolAge, ageOfSixtyFive);
        long inactiveDays = ChronoUnit.DAYS.between(ageOfSixtyFive, ageOfEighty);

        long weekendDaysForActiveTime = weekendDays * numberOfActiveWeeks;
        long weekendHoursForActiveTime = hoursPerDay * weekendDaysForActiveTime;

        long numberOfActiveDays = workingDaysPerWeek * numberOfActiveWeeks;
        long totalHoursForActiveTime = hoursPerDay * numberOfActiveDays;

        long totalHoursOfLifetime = hoursPerDay * numberOfDaysIn80Years;
        long totalSleepingHoursInLife = 8 * numberOfDaysIn80Years;
        long totalWorkingHours = 8 * numberOfActiveDays;
        long totalRestHours = 1 * numberOfActiveDays;
        long timeOnWc = (long) (0.02 * (24 * activeDays));
        long totalHygienHours = (long) (0.30 * activeDays);
        long totalHousekeepingHours =  activeDays;
        long eatingTime = (long) (0.30 * activeDays);
        long timeOnPhone = 3 * (activeDays + inactiveDays);
        long totalHoursActiveTime = totalWorkingHours + totalRestHours + timeOnWc +totalHygienHours+
                totalHousekeepingHours + eatingTime + timeOnPhone;
        long totalHoursInActiveTime = 24 * activeDays;
        long freeTimeActivePeriod = totalHoursInActiveTime - (totalHoursActiveTime);

        long totalInactiveHours = 24 * inactiveDays;
        long timeOnWcInactiveTime = (long) (0.04 * (24 * inactiveDays));
        long hygienHoursInactiveTime = 1 * inactiveDays;
        long housekeepingHoursInactiveTime = 2 * inactiveDays;
        long eatingHoursInactiveTime = 1 * inactiveDays;

        long freeTimeInactivePeriod = totalInactiveHours - (timeOnWcInactiveTime + hygienHoursInactiveTime
                                + housekeepingHoursInactiveTime+ eatingHoursInactiveTime + totalSleepingHoursInLife);

        long freeTimeInLifetime = freeTimeActivePeriod + freeTimeInactivePeriod +(24 * semiActiveDays);
        System.out.println(totalHoursOfLifetime / freeTimeInLifetime+"% of my life is free time ");
        System.out.println("Between the age of 18 - 80 i have " + freeTimeInLifetime + " h of free time");
        long freeTimePercentage;

    }
}
