package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.driver.DriverManager;
import java.time.Duration;
import java.util.List;

public class BasePage {

    public static WebDriver getDriver() { return DriverManager.getDriver(); }

    public String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }

    public boolean isURLDirected(String url)
    {
        return  getCurrentUrl().equals(url);
    }

    public void clickOnElement(WebElement element){
        try {
            FluentWait wait = new FluentWait(getDriver());
            wait.withTimeout(Duration.ofSeconds(30));
            wait.pollingEvery(Duration.ofMillis(300));
            wait.ignoring(java.util.NoSuchElementException.class);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            FluentWait wait = new FluentWait(getDriver());
            wait.withTimeout(Duration.ofSeconds(30));
            wait.pollingEvery(Duration.ofMillis(300));
            wait.ignoring(java.util.NoSuchElementException.class);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }

    }

    public void sendKeyToElement(By locator, String text){
        FluentWait wait = new FluentWait(getDriver());
        wait.withTimeout(Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofMillis(300));
        wait.ignoring(java.util.NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        getDriver().findElement(locator).sendKeys(text);
    }

    public WebElement waitAndReturnElementIfLocated(By locator) {
       try {
            return (WebElement) new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new TimeoutException("Expected Element was not located:" + locator.toString());
        }
    }
}
