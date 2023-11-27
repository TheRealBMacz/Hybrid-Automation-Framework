package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/appFeatures"},
        glue = {"stepDefinations","appHooks"},
        plugin = {"pretty"}


)
public class TestRunner {
}
