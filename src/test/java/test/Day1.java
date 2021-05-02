package test;


import day1pages.BrowserAction;
import day1pages.DocPage;
import day1pages.LevelSetHomePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utility.HelperClass;

public class Day1 {
    //variables

    public static WebDriver driver;
    private LevelSetHomePage home;
    private BrowserAction browserAction;
    private DocPage doc;

  //  private CreateDocumentPage documentPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(@Optional("chrome_headless") String browser) {
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
    @DataProvider( name = "dataReader")
    public Object[][] dataReader(){

        return new Object[][]{
                {"20-Day Preliminary Notice"},
                {"Notice of Intent to Lien"},
                {"Lien / Bond Claim"},
                {"Lien Waiver"}
        };
    }
    @Test(dataProvider = "dataReader")
    public void validateOnPrice1(String document) {
        home.navigateToHomePage();
        home.clickOnCreateADocument();
        doc.clickOnDoc(document);
        Assert.assertEquals( doc.checkPriceFree(document),"Free");
    }
    @AfterMethod
    public  void screenshotOnFail(ITestResult result){
        if (result.getStatus()==ITestResult.FAILURE){
            System.out.println("Fail ...taking screenshot");
            HelperClass.screenshotMethod(driver, result.getTestName());
        }
    /*
    @Test
    public void validateOnPrice2() {
        home.navigateToHomePage();
        home.clickOnCreateADocument();
        doc.clickOnDoc("Notice of Intent to Lien");
        Assert.assertEquals( doc.checkPriceFree("Notice of Intent to Lien"),"Free");
    }
    @Test
    public void validateOnPrice3() {
        home.navigateToHomePage();
        home.clickOnCreateADocument();
        doc.clickOnDoc("Lien / Bond Claim");
        Assert.assertEquals( doc.checkPriceFree("Lien / Bond Claim"),"Free");
    }

    @Test
    public void validateOnPrice4() {

        home.navigateToHomePage();
        home.clickOnCreateADocument();
        doc.clickOnDoc("Lien Waiver");
        Assert.assertEquals( "Free",doc.checkPriceFree("Lien Waiver"));

    }


     */


  /*    @Test
    public void title1() {

      Assert.assertEquals( documentPage.navigateDocumentPage()
              .clickNameItem1()
              .getResult(),"20-Day Preliminary Notice");

    }
    @Test
    public void title2() {

        Assert.assertEquals( documentPage.navigateDocumentPage()
                .clickNameItem2().getResult(),"Notice of Intent to Lien");

    }
    @Test
    public void title3() {

        Assert.assertEquals( documentPage.navigateDocumentPage()
                .clickNameItem3().getResult(),"Lien / Bond Claim");

    }
    @Test
    public void title4() {

        Assert.assertEquals( documentPage.navigateDocumentPage()
                .clickNameItem4().getResult(),"Lien Waiver");

    }
  @Test
    public void price1() {

        Assert.assertEquals( homepage.clickOnCreateADocument()
                .getPriceItem1(),"Free");

    }
    @Test
    public void price2() {

        Assert.assertEquals(documentPage.navigateDocumentPage()
                .getPriceItem2(),"Free");


    }
    @Test
    public void price3() {

        Assert.assertEquals( documentPage.navigateDocumentPage()
               .getPriceItem3(),"Free");

    }
    @Test
    public void price4() {

        Assert.assertEquals( documentPage.navigateDocumentPage()
               .getPriceItem4(),"Free");

    }

   */
}
}
