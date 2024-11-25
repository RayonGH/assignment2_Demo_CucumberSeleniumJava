package base;

import util.driver.DriverConfig;
import util.driver.DriverFactory;
import util.driver.DriverManager;

public class BaseTest extends BasePage {

    private DriverConfig driverConfig = new DriverConfig();
    private DriverFactory driverFactory = new DriverFactory();

    public BaseTest(){
        super();
    }

    public String username_standard = "standard_user";;
    public String username_lockedOut = "locked_out_user";
    public String username_problemUser = "problem_user";
    public String username_performanceUser = "performance_glitch_user";
    public String username_errorUser = "error_user";
    public String username_visualUser = "visual_user";
    public String password = "secret_sauce";
    public String inventoryUrl= driverConfig.getInventoryUrlValue();
    public String checkoutCompleteUrl= driverConfig.checkoutCompleteUrlValue();

    public void setUp() throws Exception {
        driverFactory.createDriver().get(driverConfig.getBaseUrlValue());
    }

    public void tearDown(){
        DriverManager.getDriver().quit();
        DriverManager.removeDriver();
    }
}
