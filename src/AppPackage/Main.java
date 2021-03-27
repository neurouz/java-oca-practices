package AppPackage;

import AppPackage.data.Product;
import AppPackage.data.ProductRating;
import AppPackage.factories.ProductManager;

import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        var manager = new ProductManager(new Locale("bs", "BA"));

        Product p1 = manager.createProduct("Pizza", 3.95, ProductRating.FIVE_STAR, LocalDate.now().plusDays(2));
        Product p2 = manager.createProduct("Juice", 1.90, ProductRating.ONE_STAR, 0.2);
        Product p3 = manager.createProduct("Tea", 0.95, ProductRating.NOT_RATED, 0.1);
        Product p4 = manager.createProduct("Nutella", 9.99, ProductRating.FIVE_STAR, LocalDate.now().plusDays(4));
        Product p5 = manager.createProduct("Meat", 12.35, ProductRating.TWO_STAR, LocalDate.now().plusDays(12));

        manager.reviewProduct(p1, ProductRating.THREE_STAR, "Not bad");

        manager.printProductReport();
    }
}
