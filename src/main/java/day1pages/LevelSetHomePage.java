package day1pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LevelSetHomePage {
    //variable
        WebDriver driver;
        String homeUrl = "https://www.levelset.com/";
        Util utilPage;

    //constrain
        public LevelSetHomePage(WebDriver driver) {
            this.driver = driver;
            utilPage = new Util(this.driver);
        }

    //element
        private By element = By.xpath("//a[@class='btn btn-info btn-outline mob-dropdown-btn']");
    //action

        public void navigateToHomePage() {
            utilPage.navigateToPage(homeUrl, element);
        }

        public void clickOnCreateADocument() {
            By expectedElement = new DocPage(driver).result;
            utilPage.clickOnButton(element, expectedElement);
        }
}


 /*   public CreateDocumentPage clickOnCreateADocument() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(createDocument_button));

        driver.findElement(createDocument_button).click();
  try {
        new WebDriverWait(driver, 10)
             .until(ExpectedConditions.presenceOfElementLocated(new CreateDocumentPage(driver).result));
      }
 catch (Exception e){
        Assert.fail();
       }
       return new CreateDocumentPage(driver);

    }


  */





