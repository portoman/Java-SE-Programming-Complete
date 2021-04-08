package lesson03;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

public class Lesson03 {

    public static void main(String[] args) {

        /* Another way of handling text in Java is with java.lang.StringBuilder class.
        StringBuilder objects are mutable(the only one mutable till now), 
        allowing modifications of the character sequences they store
        It has most of the methods as the String class and more: append, insert, delete, reserve
         */
        StringBuilder a = new StringBuilder();

        a.append("tea");
        System.out.println("a = " + a);

        a.append("s");
        System.out.println("a = " + a);

        a.insert(3, 'm');
        System.out.println("a = " + a);

        a.delete(2, 4);
        System.out.println("a = " + a);

        a.reverse();
        System.out.println("a = " + a);

        int length = a.length();
        System.out.println("length = " + length);

        /*BigDecimal Class:
        It´s useful in handling decimal numbers that require exact precision
        Arithmetic operations as methods: add, substract, divide, multiply, remainder
         */
        BigDecimal price = BigDecimal.valueOf(12.99);
        BigDecimal taxRate = BigDecimal.valueOf(0.2);
        BigDecimal tax = price.multiply(taxRate);
        System.out.println("tax = " + tax);

        price = price.add(tax).setScale(2, RoundingMode.HALF_UP);

        System.out.println("price = " + price);

        /*Chaining methods*/
        String s1 = "Hello";
        String s2 = s1.concat("World").substring(3, 6);
        System.out.println("s2 = " + s2);

        /*Package: java.time
         LocalDate, LocalTime, LocalDateTime, Duration, Period and Instant
         */
        LocalDate today = LocalDate.now();
        System.out.println("today = " + today);

        LocalTime thisTime = LocalTime.now();
        System.out.println("thisTime = " + thisTime);

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("currentDateTime = " + currentDateTime);

        LocalDate someDay = LocalDate.of(2019, Month.MARCH, 1);
        System.out.println("someDay = " + someDay);

        LocalTime someTime = LocalTime.of(10, 6);
        System.out.println("someTime = " + someTime);

        LocalDateTime otherDateTime = LocalDateTime.of(2019, Month.FEBRUARY, 14, 23, 59);
        System.out.println("otherDateTime = " + otherDateTime);

        LocalDateTime someDateTime = someDay.atTime(someTime);
        System.out.println("someDateTime = " + someDateTime);

        LocalDate whatWasTheDate = someDateTime.toLocalDate();
        System.out.println("whatWasTheDate = " + whatWasTheDate);

        LocalDate today1 = LocalDate.now();

        LocalDate foolsDay = LocalDate.of(2019, Month.APRIL, 1);

        Instant timeStamp = Instant.now();
        System.out.println("timeStamp = " + timeStamp);

        int nanoSecondsFromLastSecond = timeStamp.getNano();
        System.out.println("nanoSecondsFromLastSecond = " + nanoSecondsFromLastSecond);

        Period howLong = Period.between(foolsDay, today1);
        System.out.println("howLong = " + howLong);

        Duration twoHours = Duration.ofHours(2);
        System.out.println("twoHours = " + twoHours);

        /*Package java.time
        ZonedDateTime class
         */
        ZoneId london = ZoneId.of("Europe/London");
        ZoneId la = ZoneId.of("America/Los_Angeles");
        LocalDateTime someTime2 = LocalDateTime.of(2019, Month.APRIL, 1, 07, 14);
        ZonedDateTime londonTime = ZonedDateTime.of(someTime2, london);
        ZonedDateTime laTime = londonTime.withZoneSameInstant(la);

        System.out.println("londonTime = " + londonTime);
        System.out.println("laTime = " + laTime);

        /*java.util.Locale class represents languages and countries*/
        Locale uk = new Locale("en", "GB");
        Locale uk2 = new Locale("en", "GB", "EURO");
        Locale us = new Locale("en", "US");
        Locale fr = new Locale("fr", "FR");
        
        
        BigDecimal price2=BigDecimal.valueOf(2.99);
        Double tax2=0.2;
        int quantity=12345;
        
        NumberFormat currencyFormat=NumberFormat.getCurrencyInstance(uk);
        
        

    }

}
