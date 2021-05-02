package day1pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateDocumentPage {
    //variable
    private WebDriver driver;
    private  WebElement element;
    Util utilPage;
    String decPageURL="https://app.levelset.com/wizard/SelectDocument/?_ga=2.185548905.1962911691.1613554148-1125281871.1613554148";
    //constrain
   public CreateDocumentPage(WebDriver driver){
        this.driver= driver;
        utilPage=new Util(driver);
    }


    //element
   /* public By product_name_1_text = By.cssSelector("div.product-title-container :nth-child(1)");
    private By product_name_2_text = By.xpath("//div[text()='Notice of Intent to Lien']");
    private By product_name_3_text = By.xpath("(//div[text()='Lien / Bond Claim'])[1]");
    private By product_name_4_text = By.xpath("(//div[@class='product-title-container card-header'])[4]");
    private By product_name_4_price = By.xpath("//div[text()='Lien Waiver']/..//span[text()='Free']");
    private By product_name_3_price = By.xpath("//div[text()='Lien / Bond Claim']/..//span[text()='$349']");
    private By product_name_2_price = By.xpath("//div[text()='Notice of Intent to Lien']/..//span[text()='Free']");
    private By product_name_1_price = By.xpath("//div[text()='20-Day Preliminary Notice']/..//span[text()='Free']");
   */
   By result=By.xpath("//div[@class='title']");

    String documentSelector="//div[text()='%s']",
    FreePriceSelector="//div[text()='%s']/..//span[text()='Free']",
            free ="//div[text()='%s']/..//span[text()='Free']";

    //action


  /*  public CreateDocumentPage navigateDocumentPage(){
        utilPage.navigateToPage(decPageURL,result);
        return this;
    }

   */
    public void selectDocument(String doc) {
             By docSelector = new By.ByXPath(String.format(documentSelector, doc));
             System.out.println(utilPage.getText(result));

    }


  public boolean checkPriceFree (String doc){
        try {
            By priceLocator = new By.ByXPath(String.format(FreePriceSelector, doc));
            utilPage.validation(priceLocator, ExpectedConditions.presenceOfElementLocated(priceLocator));
            System.out.println(utilPage.getText(priceLocator));
            return true;
        }
        catch(Exception e) {
            System.out.println("checkPriceFree not work");
            return false;
        }
    }


/*
    public CreateDocumentPage clickNameItem1(){
        driver.findElement(product_name_1_text).click();
        return this;
    }

    public CreateDocumentPage clickNameItem2(){
        driver.findElement(product_name_2_text).click();
        return this;
    }

    public CreateDocumentPage clickNameItem3(){
        driver.findElement(product_name_3_text).click();
        return this;
    }

    public CreateDocumentPage clickNameItem4(){
        driver.findElement(product_name_4_text).click();
        return this;
    }


    public void selectDocument(By b){
        utilPage.validation(b, ExpectedConditions.presenceOfElementLocated (b));
        driver.findElement(b).click();

    }

    public String getResult(){ return   driver.findElement(result).getText();}
    public String getPriceItem1(){
        return   driver.findElement(product_name_1_price).getText();
    }
    public String getPriceItem2(){
        return   driver.findElement(product_name_2_price).getText();
    }
    public String getPriceItem3(){
        return   driver.findElement(product_name_3_price).getText();
    }
    public String getPriceItem4(){
        return   driver.findElement(product_name_4_price).getText();
    }


*/

}
