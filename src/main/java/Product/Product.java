package Product;

import java.util.Objects;

public class Product {
    private String productName;
    private double productPriceInDouble;
    private String productPriceInString;

    public Product(String productName, double productPriceInDouble, String productPriceInString) {
        this.productName = productName;
        this.productPriceInDouble = productPriceInDouble;
        this.productPriceInString = productPriceInString;
    }

    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPriceInDouble() {
        return productPriceInDouble;
    }

    public void setProductPriceInDouble(double productPriceInDouble) {
        this.productPriceInDouble = productPriceInDouble;
    }

    public String getProductPriceInString() {
        return productPriceInString;
    }

    public void setProductPriceInString(String productPriceInString) {
        this.productPriceInString = productPriceInString;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPriceInDouble=" + productPriceInDouble +
                ", productPriceInString='" + productPriceInString + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(productPriceInDouble, product.productPriceInDouble) == 0 && Objects.equals(productName, product.productName) && Objects.equals(productPriceInString, product.productPriceInString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productPriceInDouble, productPriceInString);
    }
}
