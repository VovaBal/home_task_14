package com.qatestlab.prestashop.uitests;

import Product.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import startDressesPages.StartDressesPages;

import Product.ProductComparator;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Home_task_14_tests {
    WebDriver driver;

    @BeforeTest
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://prestashop.qatestlab.com.ua/en/8-dresses#/");
    }

//    @AfterTest
//    public void close(){
//        driver.quit();
//    }

    //    @BeforeClass
//    public void Login() {
//        // setup();
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login("standard_user", "secret_sauce");
//    }
    @Test
    public void checkSortByPriceFromLowestToHighest() {
        StartDressesPages dressesPages = new StartDressesPages(driver);
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(10));

        Select select = new Select(dressesPages.sortByQuantityOnPage);
        select.selectByValue("60");

        List<Product> listDresses = dressesPages.getDressesList();

        Select selectSortingByPriceLowestFirst = new Select(dressesPages.productsSortByPrice);
        // Select selectSortingByPriceLowestFirst = new Select(waiter.until(ExpectedConditions.elementToBeClickable(By.id("selectProductSort"))));
        selectSortingByPriceLowestFirst.selectByValue("price:asc");

        List<Product> sortedListDresses = dressesPages.getDressesList();

        Collections.sort(listDresses, new ProductComparator());


        for (Product product : listDresses) {
            System.out.println("listDresses  ->" + product.getProductName() + " = " + product.getProductPriceInDouble());
        }
        System.out.println();
        for (Product product : sortedListDresses) {
            System.out.println("sortedListDresses  ->" + product.getProductName() + " = " + product.getProductPriceInDouble());
        }
        Assert.assertEquals(listDresses, sortedListDresses);
    }
}
