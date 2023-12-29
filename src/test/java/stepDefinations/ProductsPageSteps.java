package stepDefinations;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.driverFactory.DriverFactory;
import org.example.pages.LoginPage;
import org.example.pages.ProductsPage;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ProductsPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getWebDriver());
    private ProductsPage productsPage;

    private static String pageTitle;


    @Given("user is already logged into the application using the valid credentials")
    public void userIsAlreadyLoggedIntoTheApplicationUsingTheValidCredentials(DataTable credentialTable) {

        List<Map<String, String>> credentials_List = credentialTable.asMaps();
        String userName = credentials_List.getFirst().get("username"); //used credentials_List.getFirst() instead of credentials_List.get(0)
        String password = credentials_List.getFirst().get("password"); //used credentials_List.getFirst() instead of credentials_List.get(0)
        DriverFactory.getWebDriver().get("https://www.saucedemo.com/v1/");
        productsPage = loginPage.performLogin(userName,password);


    }
    @Given("user is on the Products page")
    public void user_is_on_the_products_page() {
        pageTitle = productsPage.getProductsPageTitle();
        System.out.println("Products Page Title: "+pageTitle);
    }

    @Then("the user gets the products on the products section")
    public void theUserGetsTheProductsOnTheProductsSection(DataTable productsTable) {
        List<String> expectedProductsList = productsTable.asList();
        System.out.println("Expected Products List: "+expectedProductsList);

        List<String> actualProductsList = productsPage.getListOfProductItemsDisplayed();
        System.out.println("Actual Products List: "+actualProductsList);

        Assert.assertTrue(expectedProductsList.containsAll(actualProductsList));
    }


    @And("the count of the products displayed should be equal to {int}")
    public void theCountOfTheProductsDisplayedShouldBeEqualTo(int productsSize) {
        Assert.assertEquals(productsPage.getProductsListSize(), productsSize);
    }
}
