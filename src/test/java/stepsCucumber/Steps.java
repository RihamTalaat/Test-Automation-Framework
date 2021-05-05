package stepsCucumber;

import day1pages.DocPage;
import day1pages.LevelSetHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import test.Day1;

public class Steps extends Day1 {
    LevelSetHomePage home;
    DocPage doc;

    @Given("The User In Home LevelSet Home Page")
    public void the_user_in_home_level_set_home_page() {
        home= new LevelSetHomePage(driver);

        home.navigateToHomePage();


    }

    @When("The User click on Create a Document Link")
    public void the_user_click_on_create_a_document_link() {
        home.clickOnCreateADocument();

    }

    @When("He click on document product name   {string}")
    public void he_click_on_document_product_name(String productName) {
        doc=new DocPage(driver);
        doc.clickOnDoc(productName);
    }
    @Then("The price of the product  is free {string}")
    public void the_price_of_the_product_is_free(String productName) {
        Assert.assertEquals( doc.checkPriceFree(productName),"Free");
    }


}
