package test;

import com.opencsv.CSVReader;
import day1pages.BrowserAction;
import day1pages.DocPage;
import day1pages.LevelSetHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;

public class Day1_csvFile {
    private WebDriver driver;

    private LevelSetHomePage home;
    private BrowserAction browserAction;
    private DocPage doc;
     // get open csv dependency in pom file
    CSVReader csvReader;


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
    public void validateOnPrice() throws IOException {
       //put path of csv file
        String csvFilePath ="E:\\project\\framework\\dataFiles\\csvfile.csv";

        csvReader =new CSVReader(new FileReader(csvFilePath));
        String[] arrayCsvCell;

        // for loop on csv file
        while ( (arrayCsvCell = csvReader.readNext())!=null)
        {
            String  wordforserch = arrayCsvCell[0];        //put your column name
            String  expectedresult = arrayCsvCell[1];      //put your column name

            //put your test scenario  here
            home.navigateToHomePage();
            home.clickOnCreateADocument();
            doc.clickOnDoc(wordforserch);
            Assert.assertEquals(expectedresult ,doc.checkPriceFree(wordforserch));
        }

    }



}
