package test;

import data.JasonReader;
import day1pages.BrowserAction;
import day1pages.DocPage;
import day1pages.LevelSetHomePage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class Day1_JasonFile {
    private WebDriver driver;
    private LevelSetHomePage home;
    private BrowserAction browserAction;
    private DocPage doc;

    //  private CreateDocumentPage documentPage;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(@Optional("chrome")String browser) {
        browserAction = new BrowserAction (driver);
        driver = browserAction.driverSetup(browser);
        home= new LevelSetHomePage(driver);
        doc=new DocPage(driver);
        browserAction.maxBrowser();

    }

    @AfterTest
    public void afterClass() {
        //  browserAction.closeBrowser();
        // driver.quit();
    }


    @Test
    public void validateOnPrice() throws IOException, ParseException {

        //create object
        JasonReader jreader=new JasonReader();
        jreader.jasonReader();
        home.navigateToHomePage();
        home.clickOnCreateADocument();
        doc.clickOnDoc(jreader.productName);
        org.testng.Assert.assertEquals( doc.checkPriceFree(jreader.productName),"Free");


    }



}
