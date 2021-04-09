package lesson03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import lesson03.Ex05_DateTimeValues;

public class Ex06_ZoneId_ZoneDateTime {
    public static void main(String[] args) {
        LocalDate today=LocalDate.now();
        LocalTime teaTime=LocalTime.of(17,30);
        LocalDateTime tomorrowTeaTime=LocalDateTime.of(today.plusDays(1), teaTime);
        
        ZoneId london=ZoneId.of("Europe/London");
        
        ZoneId katmandu=ZoneId.of("Asia/Katmandu");
        
        ZonedDateTime londonTime = ZonedDateTime.of(tomorrowTeaTime,london);
        System.out.println("londonTime = " + londonTime);
        
        //What would be that time at Katmandu
        ZonedDateTime katmanduTime=londonTime.withZoneSameInstant(katmandu);
        System.out.println("katmanduTime = " + katmanduTime);
        
        System.out.println(katmanduTime.getOffset());
        
    }
}
