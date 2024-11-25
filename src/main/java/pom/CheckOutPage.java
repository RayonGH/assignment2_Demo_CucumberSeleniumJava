package pom;

import org.openqa.selenium.By;
import base.BasePage;

public class CheckOutPage extends BasePage {

    private By FIRSTNAME = By.id("first-name");
    private By LASTNAME = By.id("last-name");
    private By ZIPPOSTALCODE = By.id("postal-code");
    private By CONTINUE = By.id("continue");

    public CheckOutPage inputFirstName(String firstName){
        clickOnElement(waitAndReturnElementIfLocated(FIRSTNAME));
        sendKeyToElement(FIRSTNAME,firstName);
        return this;
    }

    public CheckOutPage inputLastName(String lastName){
        clickOnElement(waitAndReturnElementIfLocated(LASTNAME));
        sendKeyToElement(LASTNAME,lastName);
        return this;
    }

    public CheckOutPage inputZipPostalCode(String code){
        clickOnElement(waitAndReturnElementIfLocated(ZIPPOSTALCODE));
        sendKeyToElement(ZIPPOSTALCODE,code);
        return this;
    }

    public CheckOutOverviewPage clickContinueButton(){
        clickOnElement(waitAndReturnElementIfLocated(CONTINUE));
        return new CheckOutOverviewPage();
    }



}
