package lesson03;

import java.time.*;

public class Ex05_DateTimeValues {
    public static void main(String[] args) {
        LocalDate today=LocalDate.now();
        System.out.println("today = " + today);
        
        System.out.println(today.plusYears(1).getDayOfWeek());
        
        LocalTime teaTime=LocalTime.of(17,30);
        System.out.println("teaTime = " + teaTime);
        
        Duration timeGap=Duration.between(LocalTime.now(), teaTime);
        System.out.println("timeGap = " + timeGap);
        
        System.out.println(timeGap.toMinutes());
        System.out.println(timeGap.toHours());
        System.out.println(timeGap.toMinutesPart());
        
        LocalDateTime tomorrowTeaTime=LocalDateTime.of(today.plusDays(1), teaTime);
        
        System.out.println("tomorrowTeaTime = " + tomorrowTeaTime);
    }
    
}
