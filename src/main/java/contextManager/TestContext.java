package contextManager;

import managers.DriverManager;
import managers.PageManager;

public class TestContext {
    private DriverManager driverManager;
    private PageManager pageManager;

    public TestContext(){
        driverManager = new DriverManager();
        pageManager = new PageManager(driverManager.getDriver());
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public PageManager getPageManager() {
        return pageManager;
    }
}
