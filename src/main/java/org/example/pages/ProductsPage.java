package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage {


    private WebDriver driver;

    private By productsList = By.xpath("//div[@class='inventory_container']//following-sibling::div/a/child::div");

    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public int getProductsListSize(){
        return driver.findElements(productsList).size();
    }

    public String getProductsPageTitle(){
        return driver.getTitle();
    }

    public List<String> getListOfProductItemsDisplayed(){
        List<WebElement> elementsListProducts = driver.findElements(productsList);
        List<String> productNames = new ArrayList<>();
        for (WebElement element_Product: elementsListProducts){
            productNames.add(element_Product.getText().trim());
        }

        return productNames;

    }

}
