package day1pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
    //variable
        private WebDriver driver;

    //constrain
        public Util(WebDriver driver) {
        this.driver = driver;
    }
    //actions
        public boolean validation(By element, ExpectedCondition<WebElement> s) {
            try {
                new WebDriverWait(driver, 10).until(s);
                return true;
             }
            catch (Exception e) {
                return false;
            }
        }
        public void clickOnButton(By element, By expectedElement) {
            try{
                if (validation(element, ExpectedConditions.elementToBeClickable(element))) {
                    driver.findElement(element).click();
                }

                Assert.assertTrue(validation(expectedElement,
                        ExpectedConditions.presenceOfElementLocated(expectedElement)));
            }
            catch(Exception e) {
                Assert.fail();
            }
        }
        public void clickOnElement ( By element,boolean isClickable, By expectedElement) {
             if(isClickable){
                validation(element,ExpectedConditions.elementToBeClickable(element));
                driver.findElement(element).click();
            }
             else
                validation(element,ExpectedConditions.visibilityOfElementLocated(element));

            Assert.assertTrue(validation(expectedElement, ExpectedConditions.presenceOfElementLocated(expectedElement)));
        }
        public boolean navigateToPage(String URL, By element) {
            try {
                driver.get(URL);
                return true;
            }
            catch(Exception e){
                 Assert.assertNotNull("can't navigate to page",
                         validation(element,ExpectedConditions.presenceOfElementLocated(element)));
                 return false;
            }
        }
        public boolean elementDisplayed(By element){
         return  driver.findElement(element).isDisplayed();
   }
        public void setText( By b ,String text,boolean ifYouWantToClearText){
            WebElement element =  driver.findElement(b);
            if(ifYouWantToClearText) {
                 element.clear();
            }
            element.sendKeys(text);
            String actualValue=(element.getAttribute("value")==null)
                           ?element.getAttribute("innerHTML")
                           :element.getAttribute("value")
                ;
            Assert.assertEquals(text,actualValue);

         }
        public String getText(By b ){
            try {
                 validation(b, ExpectedConditions.presenceOfElementLocated(b));
                 System.out.println(driver.findElement(b).getText());
                 return driver.findElement(b).getText();

            }
            catch(Exception e){
                 System.out.println("Text are not found");
                 return  null;
            }
         }

}
