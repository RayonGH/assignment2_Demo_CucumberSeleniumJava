package base;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import util.driver.DriverConfig;
import util.driver.DriverFactory;
import util.driver.DriverManager;

public class BaseTest extends BasePage {

    private DriverConfig driverConfig = new DriverConfig();
    private DriverFactory driverFactory = new DriverFactory();

    public BaseTest(){
        super();
    }

    public String username_standard;
    public String username_lockedOut;
    public String username_problemUser;
    public String username_performanceUser;
    public String username_errorUser;
    public String username_visualUser;
    public String password;
    public String inventoryUrl;
    public String checkoutCompleteUrl;
    protected SoftAssert softAssert;

    @BeforeMethod(groups = "config")
    public void setUp() throws Exception {
        username_standard = "standard_user";
        username_lockedOut = "locked_out_user";
        username_problemUser = "problem_user";
        username_performanceUser = "performance_glitch_user";
        username_errorUser = "error_user";
        username_visualUser = "visual_user";
        password = "secret_sauce";
        driverFactory.createDriver().get(driverConfig.getBaseUrlValue());
        inventoryUrl = driverConfig.getInventoryUrlValue();
        checkoutCompleteUrl = driverConfig.checkoutCompleteUrlValue();
    }

    @AfterMethod(groups = "config")
    public void tearDown(){
        DriverManager.getDriver().quit();
        DriverManager.removeDriver();
    }
}
