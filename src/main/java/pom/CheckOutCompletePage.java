package pom;

import base.BasePage;
import org.openqa.selenium.By;

public class CheckOutCompletePage extends BasePage {
    private By COMPLETESTATUS = By.cssSelector("[data-test='title']");

    public boolean isStatusCorrect(String status){
        return waitAndReturnElementIfLocated(COMPLETESTATUS).getText().equals(status);
    }
}
