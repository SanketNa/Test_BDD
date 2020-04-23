package ObjectIdentifiers;

import Configuration.SetUp;
import com.cucumber.listener.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PageObjectIdentifiers extends SetUp {



    @FindBy(how= How.XPATH,using="//div[@class='_1avdGP']/button[@type='submit']")
    public WebElement LogInButton;

    @FindBy(how= How.XPATH,using="//div[@class='_39M2dM JB4AMj']/input[@type='text']")
    public WebElement userId;

    @FindBy(how= How.XPATH,using="//div[@class='_39M2dM JB4AMj']/input[@type='password']")
    public WebElement password;

    @FindBy(how= How.XPATH,using="//div[@class='O8ZS_U']/input[@type='text']")
    public WebElement SearchBox;

    @FindBy(how= How.XPATH,using="//button[@class='vh79eN' and @type='submit']")
    public WebElement SearchButton;

    @FindBy(how= How.XPATH,using="//*[@class='_3oJBMI']/..")
    public WebElement AddToCart;

    @FindBy(how= How.XPATH,using="//*[text()='Place Order']/..")
    public WebElement PlaceOrder;

    @FindBy(how= How.XPATH,using="//button[text()='Deliver Here']")
    public WebElement DeliverHere;

    @FindBy(how= How.XPATH,using="//button[text()='CONTINUE']")
    public WebElement ContinueButton;





// public WebElement specificItem = driver.findElement(By.xpath("(//div[@class='_3liAhj'])[" + randomnogeneration() + "]" ));
public String SpecificItemXpath = "(//div[@class='_3liAhj'])[ItemNo]";
public String n1= String.valueOf(randomnogeneration());


    public WebElement prepareWebElementWithDynamicXpath (String xpathValue, String OldValue, String newValue) {
        String xpath1 = xpathValue.replace(OldValue,newValue);
        System.out.println(xpath1);
        return driver.findElement(By.xpath(xpath1));
    }



    public void DynamicWait() {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='O8ZS_U']/input[@type='text']")));
}


 public int randomnogeneration() {
     Random rand = new Random();
     // Generate random integers in range 0 to 25
     int nth_item = rand.nextInt(25);
     if (nth_item==0)
     {
         nth_item = rand.nextInt(25);
         System.out.println("Random Integers: " + nth_item);
     }
      // Print random integers
     System.out.println("Random Integers: " + nth_item);
     return nth_item;

 }

 public void switchWindow() {
     ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
      }


    public void retryingFindClick(WebElement element) {
        try {
            element.click();
        }
        catch (org.openqa.selenium.StaleElementReferenceException ex)
        {
            element.click();
        }

        }


        public void ReportResult( boolean Condition, String ScreenshotName) throws IOException {

        if (Condition==true){
            Reporter.addStepLog(ScreenshotName + " verified successfully");
            addScreenshot(ScreenshotName);
        }
        else
        {
            Reporter.addStepLog(ScreenshotName + " verification failed");
            addScreenshot(ScreenshotName);
        }

    }



}


