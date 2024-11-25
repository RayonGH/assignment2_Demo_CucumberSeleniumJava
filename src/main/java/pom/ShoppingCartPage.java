package pom;

import org.openqa.selenium.By;
import base.BasePage;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ShoppingCartPage extends BasePage {

    private By CARTLIST = By.cssSelector("[data-test='cart-list']");
    private By CARTITEM = By.cssSelector("[data-test='inventory-item'");
    private By CHECKOUT = By.id("checkout");

    public boolean checkCartItems(int itemcount) throws Exception{
        List<WebElement> cartItems = waitAndReturnElementIfLocated(CARTLIST).findElements(CARTITEM);
        return cartItems.size()==itemcount;
    }

    public CheckOutPage checkOut(){
        clickOnElement(waitAndReturnElementIfLocated(CHECKOUT));
        return new CheckOutPage();
    }

}
