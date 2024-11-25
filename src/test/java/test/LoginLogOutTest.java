package test;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pom.LoginPage;

public class LoginLogOutTest extends BaseTest {

    @Test
    public void checkSuccessfulLogin() throws Exception{
        LoginPage loginPage = new LoginPage();
        boolean isLoggedInSuccessfully = loginPage
                .inputUserName(username_standard)
                .inputPassword(password)
                .clickOnLoginBtnWithCorrectData()
                .isURLDirected(inventoryUrl);

        Assert.assertTrue(isLoggedInSuccessfully, "Login failed.");
    }

    @Test
    public void checkLoggedOutUserStatus() throws Exception{
        String loggedOutStatus = "Epic sadface: Sorry, this user has been locked out.";

        LoginPage loginPage = new LoginPage()
                .inputUserName(username_lockedOut)
                .inputPassword(password)
                .clickOnLoginBtnWithIncorrectData();

        boolean isLoggedInSuccessfully = loginPage.isURLDirected(inventoryUrl);
        Assert.assertFalse(isLoggedInSuccessfully);

        boolean isErrorCorrect = loginPage.isErrorStatus(loggedOutStatus);
        Assert.assertTrue(isErrorCorrect);
    }
}
