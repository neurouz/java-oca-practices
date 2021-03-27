package AppPackage.data;

public class Review {
    public ProductRating rating;
    public String comment;

    public Review(ProductRating rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public ProductRating getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Review: " + rating.getRating() + " | " + comment;
    }
}
