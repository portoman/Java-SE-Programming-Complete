package lesson03;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ex03_BigDecimal {
    
    public static void main(String[] args) {
        
        //Using primitives
        
        double price=1.85;
        double rate=0.065;
        
        price -=price*rate;//1.7297500000000001
        
        price=Math.round(price*100)/100.0; // 1.73
        
        //Using BigDecimals
        
        BigDecimal price2=BigDecimal.valueOf(1.85);
        BigDecimal rate2=BigDecimal.valueOf(0.065);
        
        price2=price2.subtract(price2.multiply(rate2)).setScale(2,RoundingMode.HALF_UP);
        
        System.out.println("price2 = " + price2);
        
    }
}
