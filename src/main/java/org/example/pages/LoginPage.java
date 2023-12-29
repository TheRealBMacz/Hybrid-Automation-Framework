package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    //Locators
   private By usernameTxtBox = By.xpath("//input[@id='user-name']");
    private By passwordTxtBox = By.xpath("//input[@id='password']");
    private By loginBtn = By.cssSelector("#login-button");
    private By errorMsg = By.cssSelector("h3[data-test='error']");
    private By loginPageLogo = By.className("login_logo");

    //Constructor
    public LoginPage(WebDriver driver){
    this.driver = driver;
    }

    //Page Actions
    public void enterUserName(String userName) {
        // TODO Auto-generated method stub
        driver.findElement(usernameTxtBox).sendKeys(userName);
    }

    public void enterPassword(String password) {
       driver.findElement(passwordTxtBox).sendKeys(password);
    }

    public void clickLoginBtn() {
        // TODO Auto-generated method stub
       driver.findElement(loginBtn).click();
    }

    public ProductsPage performLogin(String userName, String password){
        System.out.println("Performing Login with username: "+userName+ " and Password: "+password);
        driver.findElement(usernameTxtBox).sendKeys(userName);
        driver.findElement(passwordTxtBox).sendKeys(password);
        driver.findElement(loginBtn).click();
        return new ProductsPage(driver);
    }

    public String getErrorMessage(){
        // TODO Auto-generated method stub
        return driver.findElement(errorMsg).getText().trim();
    }

    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean isLoginPageLogoAvailable(){
        return driver.findElement(loginPageLogo).isDisplayed();
    }
}
