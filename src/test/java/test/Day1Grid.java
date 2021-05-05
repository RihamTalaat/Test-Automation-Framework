package test;

import day1pages.DocPage;
import day1pages.LevelSetHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utility.HelperClass;

import java.net.MalformedURLException;
import java.net.URL;

public class Day1Grid {


    public class Day1_grid {
        //variables
        protected ThreadLocal<RemoteWebDriver> driver = null;

        private LevelSetHomePage home;
        private DocPage doc;

        //  private CreateDocumentPage documentPage;

        @Parameters("browser")
        @BeforeClass
        public void setDriver(@Optional("chrome") String browser) throws MalformedURLException {
            driver = new ThreadLocal<>();
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("browserName", browser);
            driver.set(new RemoteWebDriver(new URL("http://localhost:4455/wd/hub"), cap));
            home= new LevelSetHomePage(getDriver());
            doc=new DocPage(getDriver());


        }
        public WebDriver getDriver() {
            return driver.get();
        }

        @AfterSuite
        public void closetDriver() {
            getDriver().quit();
            driver.remove();
        }

        @DataProvider( name = "dataReader")
        public Object[][] dataReader(){

            return new Object[][]{
                    {"20-Day Preliminary Notice"},
                    {"Notice of Intent to Lien"},
                    // {"Lien / Bond Claim"},
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
                HelperClass.screenshotMethod(getDriver(), result.getTestName());
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

}
