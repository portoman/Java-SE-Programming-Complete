package lesson03;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Ex_08_Bundle {
    
    public static void main(String[] args) {
        
        /*The source bundle file(message.properties) is located in the lesson03
        folder and contains the following key values pairs:
        
        offer={0}, price:{1} (applied {2} discount), valid until {3} dateFormat=EE', 'd' of 'MMMM yyyy' at 'HH:mm z
        */
        Locale locale=Locale.UK;
        
        ResourceBundle msg=ResourceBundle.getBundle("lesson03.messages",locale);
        
        String offerPattern = msg.getString("offer");
        System.out.println("offerPattern = " + offerPattern);
        
        
        
        /* 
        To look where to put the bundle message..properties.
        Exercises:
        1)MessageFormat.format(offerPattern, teaTxt, priceTxt, rateTxt, timeTxt)
        2)Change to other language*/

}
}
