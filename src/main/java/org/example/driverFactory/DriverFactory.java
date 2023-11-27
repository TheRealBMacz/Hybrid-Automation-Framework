package org.example.driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public WebDriver initDriver(String browser_Name){
        if(browser_Name.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            threadLocalDriver.set(new ChromeDriver());
        }else if(browser_Name.equalsIgnoreCase("firefox")){
            WebDriverManager.chromedriver().setup();
            threadLocalDriver.set(new FirefoxDriver());
        }else{
            System.out.println("Please Provide a valid browser name: "+ browser_Name);
        }

        getWebDriver().manage().deleteAllCookies();
        getWebDriver().manage().window().maximize();
        return getWebDriver();
    }

    //Returns WebDriver when called.(used synchronized keyword, as when the getWebDriver() is called
    // by multiple threads they would be synchronized.)
    public static synchronized WebDriver getWebDriver(){
        return threadLocalDriver.get();
    }
}
