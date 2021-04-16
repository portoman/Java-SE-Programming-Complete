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

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author portb
 */

//We could put the classes with default visibility as the instance are going to be created from ProductManager class, and 
//these classes are in the same package
public class Food extends Product{
   
    private LocalDate bestBefore;

    /**
     * Get the value of the date before the product should be consumed
     *
     * @return the value of bestBefore
     */
    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public Food(int id, String name, BigDecimal price, Rating rating,LocalDate bestBefore) {
        super(id, name, price, rating);
        this.bestBefore = bestBefore;
    }

    
    
    public Food(){
        super();
    }

    @Override
    public BigDecimal getDiscount() {
        return (this.bestBefore.isEqual(LocalDate.now()))?super.getDiscount():BigDecimal.ZERO;
    }

    
    
    @Override
    public String toString() {
        return super.toString()+", " + bestBefore;
    }

    @Override
    public Product applyRating(Rating newRating) {
        return new Food (getId(), getName(), getPrice(), newRating, bestBefore);
    }
    
    
}
