package day1pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DocPage {
    //variable
               private WebDriver driver;
               Util utilPage;
    //constrain
               public DocPage(WebDriver driver){
                   this.driver= driver;
                   utilPage=new Util( this.driver);
               }

    //element
               By result=By.xpath("//div[@class='title']");
               String documentSelector="//div[text()='%s']",
                       FreePriceSelector="//div[text()='%s']/..//span[text()='Free']";
    //action
               public void clickOnDoc(String doc) {
                   By docLocator = new By.ByXPath(String.format(documentSelector, doc));
                   utilPage.clickOnElement(docLocator,true,result);
                   System.out.println("THE RESULT IS : ");
                   utilPage.getText(result);

               }
               public String checkPriceFree (String doc) {

                   By priceLocator = new By.ByXPath(String.format( FreePriceSelector, doc));
                   System.out.println("THE PRICE IS : ");
                   return utilPage.getText(priceLocator);

               }
}
