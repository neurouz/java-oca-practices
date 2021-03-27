package AppPackage.factories;

import AppPackage.data.*;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProductManager {

    private Product product;
    private Review review;

    private Locale locale;
    private ResourceBundle resources;
    private DateTimeFormatter dateFormatter;
    private NumberFormat numberFormatter;

    public ProductManager(Locale locale) {
        this.locale = locale;
        resources = ResourceBundle.getBundle("AppPackage.data.resources", locale);
        dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).localizedBy(locale);
        numberFormatter = NumberFormat.getCurrencyInstance(locale);
    }

    public void printProductReport(){
        StringBuilder builder = new StringBuilder();
        builder.append(MessageFormat.format(resources.getString("product"), product.getName(),
                numberFormatter.format(product.getPrice()), product.getRating().getRating()));
        builder.append("\n");
        if(review != null){
            builder.append(MessageFormat.format(resources.getString("review"),
                    review.rating.getRating(), review.comment));
        }
        System.out.println(builder.toString());
    }

    public Product createProduct(String name, double price, ProductRating rating, LocalDate bestBefore){
        product = new Food(name, price, rating, bestBefore);
        return product;
    }

    public Product createProduct(String name, double price, ProductRating rating, double discount){
        product = new Drink(name, price, rating, discount);
        return product;
    }

    public Product reviewProduct(Product product, ProductRating rating, String comment){
        review = new Review(rating, comment);
        this.product = product.applyRating(product.getRating());
        return this.product;
    }
}
