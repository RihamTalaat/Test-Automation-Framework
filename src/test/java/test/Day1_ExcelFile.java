package test;

import data.LoadEXcl;
import day1pages.BrowserAction;
import day1pages.DocPage;
import day1pages.LevelSetHomePage;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class Day1_ExcelFile {
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


    @Test( dataProvider="Excel data")
    public void validateOnPrice( String wordforserch,String expectedresult) {

        home.navigateToHomePage();
        home.clickOnCreateADocument();
        doc.clickOnDoc(wordforserch);
        Assert.assertEquals(expectedresult ,doc.checkPriceFree(wordforserch));

    }

    @DataProvider(name="Excel data")
    public static Object[][] userData() throws IOException {
         // read from loadExcl

        LoadEXcl exelReader=new LoadEXcl();
       return exelReader.getExcelData();

        }

}
