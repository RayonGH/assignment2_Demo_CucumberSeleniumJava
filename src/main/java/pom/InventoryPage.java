package pom;

import org.openqa.selenium.By;
import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class InventoryPage extends BasePage {
    private By HEADERCONTAINER = By.cssSelector("[data-test='header-container']");
    private By HEADERLABEL = By.className("header_label");
    private By PRODUCTSHEADER = By.cssSelector("[data-test='title']");
    private By SORTCONTAINER = By.cssSelector("[data-test='product-sort-container']");
    private By INVENTORYCONTAINER = By.cssSelector("[data-test='inventory-container']");
    private By ITEMPRICE = By.cssSelector("[data-test='inventory-item-price']");
    private By ADDTOCART = By.cssSelector("[data-test='add-to-cart-button']");
    private By SHOPPINGCART = By.cssSelector("[data-test='shopping-cart-link']");

    public boolean checkHeaderLabel(String label) throws Exception{
        WebElement headerElement = waitAndReturnElementIfLocated(HEADERCONTAINER);
        WebElement headerLabel = headerElement.findElement(HEADERLABEL);
        return headerLabel.getText().equals(label);
    }

    public boolean checkProductHeader(String label) throws Exception{
        return waitAndReturnElementIfLocated(PRODUCTSHEADER).getText().equals(label);
    }

    public InventoryPage clickOnSortIcon(){
        WebElement headerElement = waitAndReturnElementIfLocated(HEADERCONTAINER);
        WebElement sortIcon = headerElement.findElement(SORTCONTAINER);
        clickOnElement(sortIcon);
        return this;
    }

    public InventoryPage clickOnSortingHighToLowMenu(){
        WebElement element = waitAndReturnElementIfLocated(SORTCONTAINER);
        Select select = new Select(element);
        select.selectByVisibleText("Price (high to low)");
        return this;
    }

    public InventoryPage clickOnSortingLowToHighMenu(){
        WebElement element = waitAndReturnElementIfLocated(SORTCONTAINER);
        Select select = new Select(element);
        select.selectByVisibleText("Price (low to high)");
        return this;
    }

    public boolean checkProductSortingHighToLow(){
        List<WebElement> priceElements = waitAndReturnElementIfLocated(INVENTORYCONTAINER).findElements(ITEMPRICE);

        List<Double> prices = new ArrayList<>();
        for (WebElement item : priceElements) {
            String priceText = item.getText().replace("$", "");
            double price = Double.parseDouble(priceText);
            prices.add(price);
        }

        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices, Collections.reverseOrder());

        return prices.equals(sortedPrices);
    }

    public InventoryPage addToCartByPrice(String price)
    {
        List<WebElement> priceElements = waitAndReturnElementIfLocated(INVENTORYCONTAINER).findElements(ITEMPRICE);;
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "").trim();
            if (priceText.equals(price)) {
                WebElement addToCartButton = priceElement.findElement(By.xpath("ancestor::div[contains(@class, 'inventory_item')]//button[contains(@class, 'btn_inventory')]"));
                clickOnElement(addToCartButton);
            }
        }
        return this;
    }

    public ShoppingCartPage clickOnShoppingCart(){
        clickOnElement(waitAndReturnElementIfLocated(SHOPPINGCART));
        return new ShoppingCartPage();
    }

}
