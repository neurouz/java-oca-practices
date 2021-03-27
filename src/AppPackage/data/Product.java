package AppPackage.data;

import AppPackage.interfaces.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

// Product class should be immutable
public abstract class Product implements Rateable<Product> {
    private static int id_counter = 1;
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private static Locale LOCALE = new Locale("en", "us");

    private int id;
    private String name;
    private BigDecimal price;

    public ProductRating getRating() {
        Rateable.super.getRating();
        return rating;
    }

    private ProductRating rating;

    public Product(String name, double price, ProductRating rating){
        this.id = Product.id_counter++;
        this.price = BigDecimal.valueOf(price);
        this.name = name;
        this.rating = rating;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String calculatePrice(){
        BigDecimal newPrice = price.subtract(price.multiply(Product.DISCOUNT_RATE)).setScale(2, RoundingMode.HALF_DOWN);
        return NumberFormat.getCurrencyInstance(Product.LOCALE).format(newPrice);
    }

    @Override
    public String toString() {
        return this.id + ". " + this.name + " " + this.calculatePrice() + " "
                + "Rating: " + this.rating.getRating();
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;
        Product product = (Product) o;

        return  this.getRating().equals(product.getRating()) &&
                this.getPrice().equals(product.getPrice()) &&
                this.getName().equals(product.getName());
    }
}
