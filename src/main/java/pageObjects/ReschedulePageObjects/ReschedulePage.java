package pageObjects.ReschedulePageObjects;

import com.fasterxml.jackson.databind.ser.Serializers;
import comun.BaseClass;
import managers.ReaderManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class ReschedulePage {
    private WebDriver driver;

    public ReschedulePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    SoftAssert softAssert = new SoftAssert();

    @FindBy(xpath = "//*[@id='calendar_container']/div[1]/div/div[1]/div[3]")
    private static WebElement calendario;
    @FindBy(xpath = "//*[@id='calendar_container']/div[2]/button[1]")
    private static WebElement rescheduleBttn;
    @FindBy(xpath = "//*[@id='ZUIModal-children-container']/div/div/div/div/div[3]/div/button")
    private static WebElement confirmBttn;
    @FindBy(xpath = "//*[@id='ZUIModal-children-container']/div/div/div/div/p[1]/span[2]")
    private static WebElement successMessage;

    public void goToURL(){
        driver.get(ReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }
    public void validateThatIsInReschedulePage(){
        BaseClass.waitForVisibility(driver.findElement(By.xpath("//*[contains(text(),'Edit meeting')]")), 10, driver);
        softAssert.assertTrue(BaseClass.isAnElementPresentInTheDOM("//*[contains(text(),'Edit meeting')]", driver));
    }
    public void selectNewDateMeeting(){
        java.util.List<WebElement> dias = calendario.findElements(By.tagName("div"));
        for (int i=5; i<35; i++) {
            driver.findElement(By.xpath("//*[@id='calendar_container']/div[1]/div/div[1]/div[3]/div["+i+"]/div")).click();
            //BaseClass.implicitwait(driver, 3);
            if (BaseClass.isAnElementPresentInTheDOM("//*[@id='calendar_container']/div[1]/div/div[2]/div[3]/div/div[1]/div/div[1]", driver)) break;
        }
        BaseClass.waitForVisibility(driver.findElement(By.xpath("//*[@id='calendar_container']/div[1]/div/div[2]/div[3]/div/div[1]/div/div[1]")), 10, driver);
        driver.findElement(By.xpath("//*[@id='calendar_container']/div[1]/div/div[2]/div[3]/div/div[1]/div/div[1]")).click();
    }
    public void clickOnRescheduleMeeting(){
        BaseClass.waitForVisibility(rescheduleBttn, 10, driver);
        rescheduleBttn.click();
        BaseClass.implicitwait(driver, 3);
    }
    public void confirmTheNewMeeting(){
        BaseClass.waitForVisibility(confirmBttn, 10, driver);
        confirmBttn.click();
        BaseClass.implicitwait(driver, 3);
    }
    public void validateThatTheMeetingIsSuccessfullyRescheduled(){
        BaseClass.waitForVisibility(successMessage, 10, driver);
        softAssert.assertTrue(successMessage.getText().contains("Successfully"));
        softAssert.assertAll();
        driver.quit();
    }
}
