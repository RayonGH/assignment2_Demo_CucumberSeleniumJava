package util.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverFactory {

    public static WebDriver createDriver() throws Exception {
        DriverConfig driverConfig = new DriverConfig();
        String browserName = driverConfig.getBrowserValue();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        if(browserName.equals("chrome")){
            DriverManager.setDriver(new ChromeDriver(options));
        } else if (browserName.equals("FF")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            options.addArguments("--headless=new");
            DriverManager.setDriver(new FirefoxDriver(firefoxOptions));
        } else if (browserName.equals("headless")){
            options.addArguments("--headless=new");
            DriverManager.setDriver(new ChromeDriver(options));
        } else if (browserName.equals("remote")){
            options.addArguments("--headless=new");
            DriverManager.setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options));
        }

        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().deleteAllCookies();
        return DriverManager.getDriver();
    }

}