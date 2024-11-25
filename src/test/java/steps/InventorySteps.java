package steps;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pom.*;

public class InventorySteps {

    private BaseTest baseTest = new BaseTest();
    private LoginPage loginPage = new LoginPage();
    private InventoryPage inventoryPage = new InventoryPage();
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    private CheckOutPage checkOutPage = new CheckOutPage();
    private CheckOutOverviewPage checkOutOverviewPage = new CheckOutOverviewPage();
    private CheckOutCompletePage checkOutCompletePage = new CheckOutCompletePage();

    @Given("User is logged in to the inventory page")
    public void user_is_logged_in_to_the_inventory_page() throws Exception {
        inventoryPage = loginPage.inputUserName(baseTest.username_standard)
                .inputPassword(baseTest.password)
                .clickOnLoginBtnWithCorrectData();
        Assert.assertTrue(inventoryPage.isURLDirected(baseTest.inventoryUrl));
    }

    @When("User sorts the items by price from high to low")
    public void user_sorts_the_items_by_price_from_high_to_low() {
        inventoryPage.clickOnSortIcon()
                .clickOnSortingHighToLowMenu();
    }

    @Then("the products should be sorted from highest to lowest price")
    public void the_products_should_be_sorted_from_highest_to_lowest_price() {
        boolean isSorted = inventoryPage.checkProductSortingHighToLow();
        Assert.assertTrue(isSorted, "Products are not sorted by price from high to low.");
    }

    @When("User sorts the items by price from low to high")
    public void user_sorts_the_items_by_price_from_low_to_high() {
        inventoryPage.clickOnSortIcon()
                .clickOnSortingLowToHighMenu();
    }

    @When("User adds the items priced at {string} $ to the cart")
    public void user_adds_the_items_priced_at_$_to_the_cart(String price) {
        inventoryPage.addToCartByPrice(price);
    }

    @Then("the cart should contain {int} items")
    public void the_cart_should_contain_items(Integer expectedCount) throws Exception {
        shoppingCartPage = inventoryPage.clickOnShoppingCart();
        Assert.assertTrue(shoppingCartPage.checkCartItems(expectedCount), "Cart items count doesn't match.");
    }

    @When("User proceeds to checkout and enters first name: {string}, last name: {string}, postal code: {string}")
    public void user_proceeds_to_checkout_and_enters_first_name_last_name_postal_code(String firstName, String lastName, String postalCode) {
        checkOutPage = shoppingCartPage.checkOut();
        checkOutOverviewPage = checkOutPage.inputFirstName(firstName)
                .inputLastName(lastName)
                .inputZipPostalCode(postalCode)
                .clickContinueButton();
    }

    @Then("User should see the checkout summary")
    public void user_should_see_the_checkout_summary() {
        checkOutOverviewPage.printCheckOutSummary();
    }

    @Then("User should be able to finish the checkout and see the {string} message")
    public void user_should_be_able_to_finish_the_checkout_and_see_the_message(String message) {
        checkOutCompletePage = checkOutOverviewPage.clickOnFinishButton();
        Assert.assertTrue(checkOutCompletePage.isStatusCorrect(message), "Checkout completion message is incorrect.");
    }
}