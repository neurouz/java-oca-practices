package AppPackage.data;

public enum ProductRating {
    NOT_RATED (ProductRating.getStarsAsString(0)),
    ONE_STAR  (ProductRating.getStarsAsString(1)),
    TWO_STAR  (ProductRating.getStarsAsString(2)),
    THREE_STAR(ProductRating.getStarsAsString(3)),
    FOUR_STAR (ProductRating.getStarsAsString(4)),
    FIVE_STAR (ProductRating.getStarsAsString(5)),
    TEN_STAR (ProductRating.getStarsAsString(10));

    public static String getStarsAsString(int numberOfStars) {
        StringBuilder builder = new StringBuilder();
        int difference = 5 - numberOfStars;
        while(numberOfStars > 0){
            builder.append("\u2605");
            numberOfStars--;
        }
        while(difference > 0){
            builder.append("\u2606");
            difference--;
        }
        return builder.toString();
    }

    private String rating;

    public String getRating() {
        return rating;
    }

    ProductRating(String rating){
        this.rating = rating;
    }
}
