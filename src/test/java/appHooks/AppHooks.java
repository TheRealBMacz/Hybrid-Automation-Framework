package appHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.driverFactory.DriverFactory;
import org.example.utils.ConfigReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class AppHooks {

    private DriverFactory driverFactory;
    private WebDriver webDriver;
    private ConfigReader configReader;
    Properties properties;

    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        properties = configReader.init_Properties();
    }

    @Before(order = 1)
    public void launchBrowser(){
      String browserName = properties.getProperty("browser");
      driverFactory = new DriverFactory();
        webDriver =  driverFactory.initDriver(browserName);
    }

    @After(order = 0)
    public void quitBrowser(){
        webDriver.quit();;
    }

    /**
     * This method is used as tearDown where if the scenario is failed a screenshot is taken
     * and attached to the scenario.
     */
    @After(order = 1)
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
           String scenarioName = scenario.getName().replace(" ","_" );
            byte[] sourcePath = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png", scenarioName);
        }
    }

}
