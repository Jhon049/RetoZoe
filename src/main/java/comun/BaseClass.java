package comun;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {

    static WebDriver driver;
    public BaseClass(WebDriver driver){
        BaseClass.driver = driver;
        PageFactory.initElements(driver, null);
    }

    public static void implicitwait(WebDriver driverClass, int waitSecTime){
        driverClass.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitSecTime));
    }

    public static void waitForVisibility(WebElement element, int waitSecTime, WebDriver driverClass){
        new WebDriverWait(driverClass, Duration.ofSeconds(waitSecTime)).until(ExpectedConditions.visibilityOf(element));
    }

    public static void refreshpage(WebDriver driverClass) {
        driverClass.navigate().refresh();
    }

    public static void acceptalert(WebDriver driverClass) {
        driverClass.switchTo().alert().accept();
    }

    public static Boolean waitForAlertPresent(int waitSecTime, WebDriver driverClass) throws Error {
        new WebDriverWait(driverClass, Duration.ofSeconds(waitSecTime)).until(ExpectedConditions.alertIsPresent());
        return true;
    }

    public static boolean isAlertPresent(WebDriver driverClass) {
        try {
            driverClass.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public static Boolean isAnElementPresentInTheDOM(String xpathElement, WebDriver driverClass){
        Boolean isPresent;
        try{
            new WebDriverWait(driverClass, 10).until(ExpectedConditions.presenceOfElementLocated((By.xpath(xpathElement))));
            isPresent = true;
        } catch (Exception e) {
            isPresent = false;
        }
        return isPresent;
    }
    public static String getFirstSelectedOption(WebDriver driverClass, WebElement dropDownElement) {
        Select dropDownObj = new Select(dropDownElement);
        String firstOption = dropDownObj.getFirstSelectedOption().getText();
        return firstOption;
    }
    public static Boolean waitForElementClickable(WebElement element, int waitSecTime, WebDriver driverClass) throws Error {
        new WebDriverWait(driverClass, Duration.ofSeconds(waitSecTime)).until(ExpectedConditions.elementToBeClickable(element));
        return true;
    }
}
