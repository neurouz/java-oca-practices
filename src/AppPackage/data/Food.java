package AppPackage.data;

import java.time.LocalDate;
import java.util.Objects;

public class Food extends Product {
    private LocalDate bestBefore;
    public Food(String name, double price, ProductRating rating, LocalDate bestBefore){
        super(name, price, rating);
        this.bestBefore = bestBefore;
    }

    @Override
    public Product applyRating(ProductRating rating) {
        // If rating is null, keep the current rating
        ProductRating newRating = rating == null ? this.getRating() : rating;
        return new Food(this.getName(), this.getPrice().doubleValue(), newRating, this.bestBefore);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;
        Food food = (Food) o;

        return super.equals(o) && this.bestBefore.equals(food.bestBefore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bestBefore);
    }
}
