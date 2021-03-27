package AppPackage.interfaces;

import AppPackage.data.ProductRating;

@FunctionalInterface
public interface Rateable<T> {
    /**
     * Public static final variables are allowed in interfaces, and they are
     * public, static and final by default.
     */
    public static final ProductRating DEFAULT_PRODUCT_RATING = ProductRating.NOT_RATED;

    /**
     * public default methods are methods which have their body and they are inherited in class
     * which implements the interface
     * If one class implements multiple interfaces with same method name and return type,
     * that class must override that method, in which can be a concrete implementation for that class,
     * or we can call existing method from interface by specifying from which interface method should
     * be called.
     * To achieve this, we can use InterfaceName.super.methodName();
     *
     * For this example, if one class implements multiple interfaces with getRating() method, and we
     * want to call explicitly method from Rateable interface, the overridden method should look like this:
     * @<code>
     * @ Override
     * public ProductRating getRating(){
     *     return Rateable.super.getRating();
     * }
     * </code>
     * @return
     */
    public default ProductRating getRating() {
        return DEFAULT_PRODUCT_RATING;
    }

    /**
     * This is the abstract method which must be overridden in every class that is implementing Rateable.
     * Since this is the only one abstract class, that makes this interface as FunctionalInterface.
     * @param rating
     * @return
     */
    T applyRating(ProductRating rating);

    /**
     * public default method, same as getRating() method
     * The only difference is that this method calls an abstract method applyRating(ProductRating)
     * which will be implemented in concrete classes. So this method can be invoked only in runtime.
     * @param rating
     * @return
     */
    public default T applyRating(int rating){
        return applyRating(Rateable.convert(rating));
    }

    /**
     * Interfaces allows public static methods as well. Since they are static, they are not
     * object-related, so they are not inheritable.
     * @param number
     * @return
     */
    public static ProductRating convert(int number){
        return (number >= 0 && number <= 5) ? ProductRating.values()[number] : null;
    }

    public static int convert(ProductRating rating) {
        return ProductRating.values()[rating.ordinal()].ordinal();
    }
}

