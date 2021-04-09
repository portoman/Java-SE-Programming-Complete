package lesson03;

import java.text.NumberFormat;
import java.util.Locale;

public class Ex04_Locale {
    public static void main(String[] args) {
        
        double price = 1.73;
        double rate=0.065;
        
        Locale locale=Locale.FRANCE;
        
        NumberFormat currencyFormat=NumberFormat.getCurrencyInstance(locale);
        
        NumberFormat percentFormat=NumberFormat.getPercentInstance(locale);
        
        percentFormat.setMaximumFractionDigits(2);
        
        System.out.println(currencyFormat.format(price));
        System.out.println(percentFormat.format(rate));
        System.out.println(locale);
        
        //Changing locale
        
        locale=Locale.UK;
        currencyFormat=NumberFormat.getCurrencyInstance(locale);
        percentFormat=NumberFormat.getPercentInstance(locale);
        
        percentFormat.setMaximumFractionDigits(2);
        System.out.println(currencyFormat.format(price));
        System.out.println(percentFormat.format(rate));
        System.out.println(locale);
        
        }
}
