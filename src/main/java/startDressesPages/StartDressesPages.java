package startDressesPages;

import Product.Product;
import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "//ul//li//div[@class='right-block']//a[@class='product-name']")
    List<WebElement> dresses;

    public void sortByQuantityButtonClick() {
        sortByQuantityOnPage.click();
    }

    public List<Product> getDressesList() {
        List<Product> listDresses = new ArrayList<>();
        for (WebElement product : dresses) {
            Product simpleProduct = new Product();
            simpleProduct.setProductName(product.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a")).getText());

            simpleProduct.setProductPriceInDouble(Double.parseDouble(product.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[1]/span"))
                    .getText().replace("₴", "").replace(",", ".")));
            listDresses.add(simpleProduct);
            System.out.println("size  === " + dresses.size());
            System.out.println("name  === " + simpleProduct.getProductName());
            System.out.println("price === " + simpleProduct.getProductPriceInDouble());
        }
        return listDresses;
    }

}
