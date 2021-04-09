package lesson03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Ex07_DateTimeFormatter {
    public static void main(String[] args) {
        
        Locale locale=Locale.UK;
        
        //Declare a pattern
        String datePattern="EE', 'd' of 'MMMM yyyy' at 'HH:mm z";
        
        DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern(datePattern, locale);
        
        LocalDate today=LocalDate.now();
        LocalTime teaTime=LocalTime.of(17,30);
        ZoneId london=ZoneId.of("Europe/London");
        LocalDateTime tomorrowTeaTime=LocalDateTime.of(today.plusDays(1), teaTime);
        ZoneId katmandu=ZoneId.of("Asia/Katmandu");
        ZonedDateTime londonTime = ZonedDateTime.of(tomorrowTeaTime,london);
        ZonedDateTime katmanduTime=londonTime.withZoneSameInstant(katmandu);
        System.out.println("katmanduTime = " + katmanduTime);
        
        
        String timeTxt=dateFormat.format(katmanduTime);
        System.out.println("timeTxt = " + timeTxt);
    }
    
    
}
