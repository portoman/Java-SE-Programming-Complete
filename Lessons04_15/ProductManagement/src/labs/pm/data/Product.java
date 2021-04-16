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
package labs.pm.data;

import java.io.Serializable;
import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.time.LocalDate;
import java.util.Objects;

/**
 * {@code Product} class represents properties and behaviours of product objects
 * in the Product Management System.
 * <br>
 * Each product has an id, name and price
 * <br>
 * Each product can have a discount, calculated based on a
 * {@Link DISCOUNT_RATE discount rate}
 *
 * @version 4.0
 * @author portb
 */
public abstract class Product implements Rateable<Product>,Serializable {

    private LocalDate bestBefore = LocalDate.now();
//<editor-fold defaultstate="collapsed" desc="Atributs">
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private int id;
    private String name;
    private BigDecimal price;
    private Rating rating;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Methods">
//<editor-fold defaultstate="collapsed" desc="Getter/Setter">
    public int getId() {
        return id;
    }

    //Adding final in the setter methods, to avoid mistakes putting new varibles inside it
    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    @Override
    public Rating getRating() {
        return rating;
    }

//</editor-fold>
    public BigDecimal getDiscount() {

        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);

    }

//    <editor-fold defaultstate="collapsed" desc="Constructor">
    public Product() {
        this(0, "no name", BigDecimal.ZERO);
    }

    ;
    
    public Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Product(int id, String name, BigDecimal price) {

        this(id, name, price, Rating.NOT_RATED);
    }
//      This method comes from the Rateable interface, created afterwards,  so it can be hidden
//    public abstract Product applyRating(Rating newRating);
//    {
//        return new Product(this.id, this.name, this.price, newRating);
//
//    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + price + ", " + getDiscount() + ", " + rating.getStars();

//</editor-fold>
//</editor-fold>
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
//        if (obj != null&& getClass() == obj.getClass()){
        if (obj instanceof Product) {

            final Product other = (Product) obj;
            return this.id == other.id;// && Objects.equals(this.name, other.name);

        }

        return false;
    }
}
