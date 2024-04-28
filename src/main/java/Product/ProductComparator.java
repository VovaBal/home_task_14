package Product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        int priceComparison = Double.compare(o1.getProductPriceInDouble(), o2.getProductPriceInDouble());
        if (priceComparison != 0) {
            return priceComparison;
        }
        return o1.getProductName().compareTo(o2.getProductName());
    }
}
