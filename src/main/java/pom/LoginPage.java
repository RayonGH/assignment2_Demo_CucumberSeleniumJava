package pom;

import org.openqa.selenium.By;
import base.BasePage;

public class LoginPage extends BasePage {
    private By TXTBOX_USERNAME = By.id("user-name");
    private By TXTBOX_PASSWORD = By.id("password");
    private By BTN_LOGIN = By.id("login-button");
    private By ERRORTEXT = By.cssSelector("[data-test='error']");

    public LoginPage inputUserName(String userName) throws Exception{
        clickOnElement(waitAndReturnElementIfLocated(TXTBOX_USERNAME));
        sendKeyToElement(TXTBOX_USERNAME, userName);
        return this;
    }

    public LoginPage inputPassword(String password) throws Exception{
        clickOnElement(waitAndReturnElementIfLocated(TXTBOX_PASSWORD));
        sendKeyToElement(TXTBOX_PASSWORD, password);
        return this;
    }

    public InventoryPage clickOnLoginBtnWithCorrectData() throws Exception{
        clickOnElement(waitAndReturnElementIfLocated(BTN_LOGIN));
        return new InventoryPage();
    }

    public LoginPage clickOnLoginBtnWithIncorrectData() throws Exception{
        clickOnElement(waitAndReturnElementIfLocated(BTN_LOGIN));
        return new LoginPage();
    }

    public boolean isErrorStatus(String status){
        return waitAndReturnElementIfLocated(ERRORTEXT).getText().equals(status);
    }

}
