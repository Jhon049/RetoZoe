package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.ReschedulePageObjects.ReschedulePage;

public class PageManager {
    private WebDriver driver;
    private ReschedulePage reschedulePage;

    public PageManager(WebDriver driver){
        this.driver = driver;
    }

    public ReschedulePage getReschedulePage() {
        return (reschedulePage == null) ? reschedulePage = new ReschedulePage(driver) : reschedulePage;
    }
}
