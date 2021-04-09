package lesson03;

public class Ex02_StringBuilder {
    
    public static void main(String[] args) {
        
        String c="Tea Tea";
        
        StringBuilder txt=new StringBuilder(c);
        
        System.out.println(txt.length());
        
        System.out.println(txt.capacity());
        
        //Default capacity 23, what it can be expanded as necessary
        
        System.out.println(txt.replace(0,3,"What is the price of"));
        
         System.out.println(txt.length());
        
        System.out.println(txt.capacity());
        
    }
}
