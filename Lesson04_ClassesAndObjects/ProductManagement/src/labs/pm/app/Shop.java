/*
 * Copyright (C) 2021 portb
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
//<editor-fold defaultstate="collapsed" desc="SUMMARY">
/*
Summary of the lessons of the course:
01-Introduction to Java
02-Primitive Types, Operators and Flow Control Statements
03-Text, Date, Time and Numeric Objects
04-Classes and Objects
05-Improved Class Design
06-Inheritance
07-Interfaces
08-Arrays and Loops
09-Collections: List, Set, Deque and Map Collections
10-Nested Classes(Static, Member, Local, Anonymous) and Lambda Expressions
11-Java Streams API (In this program we have substituted the loop expressions for Streams in the ProductManager class)
12-Handle Exceptions and Fix Bugs: Java Logging API, try/catch/finally sintax, assertions.
13-Java IO API (Input-Output)
14-Java Concurrency and Multithreading
15-Open Module Content
 */
//</editor-fold>
package labs.pm.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import labs.pm.data.Drink;
import labs.pm.data.Food;
import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

/**
 * {@code Shop} class represents an application that manages Products
 *
 * @version 4.0
 *
 *
 * @author portb
 *
 * Additional Javadoc options:
 *
 * -link
 * https://docs.oracle.com/en/java/javase/11/docs/api/-J-Dhttps.proxyHost=ges-proxy-oci-J-Dhttps.proxyPort=3128
 *
 *
 */
public class Shop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductManager pm = ProductManager.getInstance();
        
        AtomicInteger clientCount = new AtomicInteger(0);
        Callable<String> client = () -> {
            String clientId = "Client" + clientCount.incrementAndGet();
            String threadName = Thread.currentThread().getName();
            int productId = ThreadLocalRandom.current().nextInt(63) + 101;
            String languageTag = ProductManager.getSupportedLocales()
                    .stream()
                    .skip(ThreadLocalRandom.current().nextInt(4))
                    .findFirst().get();
            StringBuilder log = new StringBuilder();
            log.append(clientId + " " + threadName + "\n-\tstart of log\t-\n");
            log.append(pm.getDiscounts(languageTag)
                    .entrySet()
                    .stream()
                    .map(entry->entry.getKey()+"\t" + entry.getValue())
                    .collect(Collectors.joining("\n")));
            Product product=pm.reviewProduct(productId, Rating.FOUR_STAR, "Yet another review");
            log.append((product!=null)? "\nProduct "+productId+" reviewed\n" : "\nProduct "+productId+" not reviewed\n");
            pm.printProductReport(productId, languageTag, clientId);
            log.append(clientId+" generated report for "+productId+" product");
            log.append("\n-\tend of log\t-\n");
            return log.toString();
        };

        List<Callable<String>> clients =Stream.generate(()->client).limit(5).collect(Collectors.toList());
        ExecutorService executorService=Executors.newFixedThreadPool(3);
        try {
            List<Future<String>> results=executorService.invokeAll(clients);
            executorService.shutdown();
            results.stream().forEach(result->{
                try {
                    System.out.println(result.get());
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, "Error retrieving client log", ex);
                
                }});
        } catch (InterruptedException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, "Error invoking clients", ex);
        }
        
        
        
        //new ProductManager();
//        pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
////        pm.parseProduct("D,101,Tea,1.99,0,2019-09-19");
////        pm.parseProduct("F,103,Apple,0.99,5,2019-09-09");
////        pm.printProductReport(101, "en-GB");
////        pm.parseReview("101,2,Nice hot cup of tea");
//        pm.reviewProduct(101, Rating.FOUR_STAR, "Nice hot cup of tea");
//        pm.reviewProduct(101, Rating.TWO_STAR, "Not bad");
//        pm.reviewProduct(101, Rating.THREE_STAR, "It´s ok tea");
//        pm.reviewProduct(101, Rating.FIVE_STAR, "The greatest tea I have ever drunk");
//        pm.reviewProduct(101, Rating.ONE_STAR, "Not good");
//        pm.printProductReport(103);

        //To check the exceptions
//        pm.parseReview("101,2,Nice hot cup of tea");
//        pm.parseReview("101,4,Rather weak tea");
//        pm.parseReview("101,5,Fine tea");
//        pm.parseReview("101,2,Not very good");
//        pm.parseReview("101,2,Just add some sugar");
//        pm.createProduct(102, "Coffee", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
//        pm.reviewProduct(102, Rating.NOT_RATED, "Not so good");
//        pm.reviewProduct(102, Rating.FIVE_STAR, "Excellent coffee");
//        pm.reviewProduct(102, Rating.THREE_STAR, "It´s ok");
////        pm.printProductReport(p2);
//        pm.changeLocale("fr-FR");
//        pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.NOT_RATED, LocalDate.now().plusDays(2));
//        pm.reviewProduct(103, Rating.FIVE_STAR, "Very tasty");
//        pm.reviewProduct(103, Rating.FOUR_STAR, "Very fine");
//        pm.reviewProduct(103, Rating.ONE_STAR, "I expected more quality");
////        pm.printProductReport(103);
//
//        pm.printProducts(p -> p.getPrice().floatValue() < 2, (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal());
//
//        pm.getDiscounts().forEach((rating, discount) -> System.out.println(rating + "\t" + discount));
//        pm.printProducts((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()));
//        Product p2 = new Product(102, "Coffee", BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
        //        Product p3 = new Product(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR);
        //        Product p2 = pm.createProduct(102, "Coffee", BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
        //        Product p3 = pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        //        Product p4 = pm.createProduct(105, "Cookie", BigDecimal.valueOf(3.99), Rating.TWO_STAR, LocalDate.now());
        //        Product p5 = p3.applyRating(Rating.THREE_STAR);
        //        Product p6 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR);
        //        Product p7 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        //        Product p8 = p4.applyRating(Rating.FIVE_STAR);
        //        Product p9 = p1.applyRating(Rating.TWO_STAR);
        //        System.out.println(p6.equals(p7));//false
        //Casting p3 from Product to instance
        //       LocalDate bestBefore = null;
        //        if(p3 instanceof Food){
        //            bestBefore=((Food)p3).getBestBefore();
        //        }
        //       
        //        //Product p7=p6; 
        //System.out.println(p6.equals(p7));true
//        p1.setId(101);
//        p1.setName("Tea");
//        p1.setPrice(BigDecimal.valueOf(1.99));
//        System.out.println(p1.getId() + " " + p1.getName() + " " + p1.getPrice() + " " + p1.getDiscount() + " " + p1.getRating().getStars());
//        System.out.println(p2.getId() + " " + p2.getName() + " " + p2.getPrice() + " " + p2.getDiscount() + " " + p2.getRating().getStars());
//        System.out.println(p3.getId() + " " + p3.getName() + " " + p3.getPrice() + " " + p3.getDiscount() + " " + p3.getRating().getStars());
//        System.out.println(p4.getId() + " " + p4.getName() + " " + p4.getPrice() + " " + p4.getDiscount() + " " + p4.getRating().getStars());
//        System.out.println(p5.getId() + " " + p5.getName() + " " + p5.getPrice() + " " + p5.getDiscount() + " " + p5.getRating().getStars());
//        System.out.println("p1: " + p1);
//        System.out.println("p2: " + p2);
//        System.out.println("p3: " + p3);
//        System.out.println("p4: " + p4);
//        System.out.println("p5: " + p5);
//        System.out.println("p6: " + p6);
//        System.out.println("p7: " + p7);
//        System.out.println("p8: " + p8);
////        System.out.println("p9: " + p9);
//        pm.createProduct(164, "Kombucha", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
//        pm.reviewProduct(164, Rating.TWO_STAR, "Looks like tea but is it?");
//        pm.reviewProduct(164, Rating.FIVE_STAR, "Great product");
//        pm.reviewProduct(164, Rating.FIVE_STAR, "Fantastic");
////        pm.printProductReport(164, "en-GB");

    }

}
