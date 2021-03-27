package AppPackage.data;

import java.math.BigDecimal;

public class Drink extends Product {
    public BigDecimal discount;
    public Drink(String name, double price, ProductRating rating, double discount){
        super(name, price, rating);
        this.discount = BigDecimal.valueOf(discount);
    }

    @Override
    public Product applyRating(ProductRating rating) {
        ProductRating newRating = rating == null ? this.getRating() : rating;
        return new Drink(this.getName(), this.getPrice().doubleValue(), newRating, discount.doubleValue());
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return super.equals(o) && this.discount.equals(drink.discount);
    }

    public BigDecimal getDiscount(){
        return this.discount;
    }
}
