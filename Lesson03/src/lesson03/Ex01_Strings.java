package lesson03;

public class Ex01_Strings {
    public static void main(String[] args) {
        
        String teaTxt="Tea";
        String b="Tea";
        
        System.out.println(b==teaTxt);//True
        
        String c=new String("Tea");
        
        System.out.println(c==b);//False
        
        String d= c.intern();
        
         System.out.println(d==b);//True
        
        c=teaTxt+' '+b;
        System.out.println("c = " + c);
        
        System.out.println(c.indexOf('T'));//0
        
        System.out.println(c.indexOf('T',1));//4
        
        System.out.println(c.lastIndexOf('T'));//4
        
        System.out.println(c.length());
        
        System.out.println(c.toUpperCase());
        
        
        
        
        //Substring method substract from first index till last index-1
        
        System.out.println(c.substring(4, 6));
        System.out.println(c.substring(c.lastIndexOf('T'), c.lastIndexOf('T')+2));
        
    }
}
