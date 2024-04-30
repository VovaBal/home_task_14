package startDressesPages;

import Product.Product;
import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StartDressesPages extends BasePage {
    public StartDressesPages(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@id='nb_item']")
    public WebElement sortByQuantityOnPage;

    //   @FindBy(xpath = "//div[@class='selector']//select[@id='selectProductSort']")
    @FindBy(xpath = "//select[@id='selectProductSort']")
    public WebElement productsSortByPrice;

    @FindBy(xpath = "//*[@id='center_column']/ul/li")
    List<WebElement> dresses;

    public void sortByQuantityButtonClick() {
        sortByQuantityOnPage.click();
    }

    public List<Product> getDressesList() {
        List<Product> listDresses = new ArrayList<>();
        System.out.println("Size dresses = " + dresses.size());
        for (WebElement product : dresses) {
            Product simpleProduct = new Product();
            simpleProduct.setProductName(product.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a")).getText());

            simpleProduct.setProductPriceInDouble(Double.parseDouble(product.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[1]/span"))
                    .getText().replace("₴", "").replace(",", ".")));
            listDresses.add(simpleProduct);

            System.out.println("name  === " + simpleProduct.getProductName());
            System.out.println("price === " + simpleProduct.getProductPriceInDouble());
        }
        return listDresses;
    }

    public List<Product> getProducts()  {
        List<Product> productList = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String xpathProductPrice;
        String xpathProductName;

        int i = 1;
        System.out.println("Size dresses = " + dresses.size());
        for (WebElement product : dresses) {
            xpathProductName = "//*[@id='center_column']/ul/li[" + i + "]/div/div[1]/div/a[1]";
            xpathProductPrice = "//*[@id='center_column']/ul/li[" + i + "]/div/div[2]/div[1]/span";

            String productName = product.findElement(By.xpath(xpathProductName)).getAttribute("title");
            String productPriceAsString = product.findElement(By.xpath(xpathProductPrice)).getText();


            productPriceAsString = productPriceAsString.replace(",", ".").replace(" ", "");
            Double productPrice = Double.parseDouble(productPriceAsString.replace("₴", ""));

            System.out.println("productPrice = " + productPrice);

            Product productModel = new Product();
            productModel.setProductName(productName);
            productModel.setProductPriceInString(productPriceAsString);
            productModel.setProductPriceInDouble(productPrice);
            productList.add(productModel);
            i++;

        }
        return productList;
    }

}
