package com.company;

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
}
