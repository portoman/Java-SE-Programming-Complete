/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Numbers;

public class Numbers {

    public static void main(String[] args) {

        double a = 11, b = 3;

        System.out.println(a / b);

        float c = Math.round(a / b);

        System.out.println("c = " + c);

        c = Math.round((a / b) * 100) / 100F;//To round with 2 decimals

        System.out.println("c = " + c);

        char a1 = 'a', a2 = '\141'/*Octal*/, a3 = '\u0061'/*Hex*/;

        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("a3 = " + a3);

        int i1 = 0141/*Octal*/, i2 = 0x61/*Hex*/;
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);

        char a4 = (char) i1;
        System.out.println("a4 = " + a4);

        char someChar = 'k';

        boolean isEven = (someChar % 2 == 0);
        System.out.println("isEven = " + isEven);

        someChar = 'k';

        //Take the nect letter in the alphabet
        char nextChar = (char) (someChar + 1);

        System.out.println("nextChar = " + nextChar);

        char z = 'z';

        //Going out of the alphabet
        char some = (char) (z + 1);

        System.out.println("some = " + some);

        char upperA = 'A', lowerA = 'a';

        //Distance between characters
        int distance = lowerA - upperA;

        System.out.println("distance = " + distance);

        char somechar1 = 'h';

        //Convert to uppercase with function
        char upperChar1 = (char) (somechar1 - 32);
        System.out.println("upperChar1 = " + upperChar1);

        //Convert the letter to upper or lower case with if
        someChar = 'A';
        if (someChar >= 'a' && someChar <= 'z') {
            someChar -= 32;
        } else if (someChar >= 'a' && someChar <= 'z') {
            someChar += 32;
        }

        System.out.println("someChar = " + someChar);

        //Convert the letter to upper or lower case with ternary
        someChar = (someChar >= 'a' && someChar <= 'z') ? (someChar -= 32) : (someChar += 32);
        
        System.out.println("someChar = " + someChar);

        //switch
        
        int period=2;
        float amount=10;
        float rate=0.05F;
        
        switch(period){
            case 3:
                amount +=amount*rate;
                break;
            case 2:
                amount +=amount*rate;
                break;
            case 1:
                amount +=amount*rate;
                break;
            
        }
        System.out.println("amount = " + amount);
        
        boolean x=4>5;
        System.out.println("x = " + x);
        
        //Operator 'o' where the to conditions are executed
        int p=1, q=1, r=0;
        if(p==q | p<++q){
            r=p+q;
        }
        else{
            r=1;
        }
        System.out.println("r = " + r);
    }

}
