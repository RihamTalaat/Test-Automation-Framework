package test;

import data.LoadProperties;
import day1pages.BrowserAction;
import day1pages.DocPage;
import day1pages.LevelSetHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Day1_PropertiesFile {
    private WebDriver driver;
    private LevelSetHomePage home;
    private BrowserAction browserAction;
    private DocPage doc;
    //-------------------use properties
    String product1= LoadProperties.productdata.getProperty("doc1");
    String product2= LoadProperties.productdata.getProperty("doc2");
    String product3= LoadProperties.productdata.getProperty("doc3");
    String product4= LoadProperties.productdata.getProperty("doc4");
    //---------------------------------
    //  private CreateDocumentPage documentPage;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(@Optional("chrome") String browser) {
        browserAction = new BrowserAction (driver);
        driver = browserAction.driverSetup(browser);
        home= new LevelSetHomePage(driver);
        doc=new DocPage(driver);
        // browserAction.maxBrowser();

    }

    @AfterTest
    public void afterClass() {
        //  browserAction.closeBrowser();
        // driver.quit();
    }
    @Test
    public void validateOnPrice1() {
        home.navigateToHomePage();
        home.clickOnCreateADocument();
        doc.clickOnDoc(product1);
        Assert.assertEquals( doc.checkPriceFree(product1),"Free");
    }
    @Test
    public void validateOnPrice2() {
        home.navigateToHomePage();
        home.clickOnCreateADocument();
        doc.clickOnDoc(product2);
        Assert.assertEquals( doc.checkPriceFree(product2),"Free");
    }
    ///use proprty.properties  file
    @Test
    public void validateOnPrice3() {
        home.navigateToHomePage();
        home.clickOnCreateADocument();
        doc.clickOnDoc(product3);
        Assert.assertEquals( doc.checkPriceFree(product3),"Free");
    }

    @Test
    public void validateOnPrice4() {

        home.navigateToHomePage();
        home.clickOnCreateADocument();
        doc.clickOnDoc(product4);
        Assert.assertEquals( doc.checkPriceFree(product4),"Free");

    }
}
