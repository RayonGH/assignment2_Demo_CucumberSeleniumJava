package test;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pom.*;

public class InventoryTest extends BaseTest {

    @Test
    public void checkSortingThePriceFromHighToLow() throws Exception{
        InventoryPage inventoryPage = new LoginPage()
                .inputUserName(username_standard)
                .inputPassword(password)
                .clickOnLoginBtnWithCorrectData();

        boolean isProductSorted = inventoryPage.clickOnSortIcon()
                .clickOnSortingHighToLowMenu()
                .checkProductSortingHighToLow();

        Assert.assertTrue(isProductSorted, "Product not sorted in High to Low.");
    }

    @Test
    public void checkAddToCartItemsWithPrice() throws Exception{
        InventoryPage inventoryPage = new LoginPage()
                .inputUserName(username_standard)
                .inputPassword(password)
                .clickOnLoginBtnWithCorrectData();

        ShoppingCartPage shoppingCartPage = inventoryPage.clickOnSortIcon()
                .clickOnSortingLowToHighMenu()
                .addToCartByPrice("15.99")
                .clickOnShoppingCart();

        boolean isCartItemsCount = shoppingCartPage.checkCartItems(2);
        Assert.assertTrue(isCartItemsCount);
    }

    @Test
    public void checkLogOfCheckOutSummary() throws Exception{
        String completeStatus = "Checkout: Complete!";
        InventoryPage inventoryPage = new LoginPage()
                .inputUserName(username_standard)
                .inputPassword(password)
                .clickOnLoginBtnWithCorrectData();

        CheckOutPage checkOutPage = inventoryPage.clickOnSortIcon()
                .clickOnSortingLowToHighMenu()
                .addToCartByPrice("15.99")
                .clickOnShoppingCart()
                .checkOut();

        CheckOutOverviewPage checkOutOverviewPage = checkOutPage
                .inputFirstName("firstname")
                .inputLastName("lastname")
                .inputZipPostalCode("12345")
                .clickContinueButton();

        checkOutOverviewPage.printCheckOutSummary();

        CheckOutCompletePage checkOutCompletePage = checkOutOverviewPage
                .clickOnFinishButton();

        boolean isCheckOutComplete = checkOutCompletePage.isURLDirected(checkoutCompleteUrl);
        boolean isCompleteStatus = checkOutCompletePage.isStatusCorrect(completeStatus);

        Assert.assertTrue(isCheckOutComplete && isCompleteStatus);
    }


}
