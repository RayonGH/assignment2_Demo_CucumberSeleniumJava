package pom;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckOutOverviewPage extends BasePage {
    private By CARTLIST = By.cssSelector("[data-test='cart-list']");
    private By CARTITEM = By.cssSelector("[data-test='inventory-item']");
    private By ITEMQUANTITY = By.cssSelector("[data-test='item-quantity']");
    private By ITEMNAME = By.cssSelector("[data-test='inventory-item-name']");
    private By ITEMDESCRIPTION = By.cssSelector("[data-test='inventory-item-desc']");
    private By ITEMPRICE = By.cssSelector("[data-test='inventory-item-price']");
    private By PAYMENT = By.cssSelector("[data-test='payment-info-value']");
    private By SHIPPING = By.cssSelector("[data-test='shipping-info-value']");
    private By PRICETOTALLABEL = By.cssSelector("[data-test='subtotal-label']");
    private By TAXLABEL = By.cssSelector("[data-test='tax-label']");
    private By TOTALLABEL = By.cssSelector("[data-test='total-label']");
    private By FINISH = By.id("finish");

    public CheckOutOverviewPage printCheckOutSummary(){
        List<WebElement> cartItems = waitAndReturnElementIfLocated(CARTLIST).findElements(CARTITEM);

        System.out.println("Checkout Summary: \n");
        for (WebElement item : cartItems) {
            String itemQuantity = item.findElement(ITEMQUANTITY).getText();
            String itemName = item.findElement(ITEMNAME).getText();
            String itemDescription = item.findElement(ITEMDESCRIPTION).getText();
            String itemPrice = item.findElement(ITEMPRICE).getText();
            System.out.println("Quantity: "+ itemQuantity + " - Name: " + itemName + "\n Description: " + itemDescription + "\n Price: " + itemPrice + "\n");
        }
        System.out.println("Payment Information: "+ waitAndReturnElementIfLocated(PAYMENT).getText() + "\nShipping Information: " + waitAndReturnElementIfLocated(SHIPPING).getText() + "\nPrice Total: " + waitAndReturnElementIfLocated(PRICETOTALLABEL).getText()+ "\n" +  waitAndReturnElementIfLocated(TAXLABEL).getText() + "\n" + waitAndReturnElementIfLocated(TOTALLABEL).getText());
        return this;
    }

    public CheckOutCompletePage clickOnFinishButton(){
        clickOnElement(waitAndReturnElementIfLocated(FINISH));
        return new CheckOutCompletePage();
    }
}
