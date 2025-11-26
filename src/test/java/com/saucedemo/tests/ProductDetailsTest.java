package com.saucedemo.tests;

import com.saucedemo.data.TestData;
import com.saucedemo.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductDetailsTest extends BaseTest {

    @BeforeMethod
    public void setupProductDetailsTest() {
        productsPage = loginPage.login(TestData.STANDARD_USER, TestData.PASSWORD);
        productDetailsPage = productsPage.clickProductName(0);
    }

    @Test(testName = "TC001 - Verify product name display")
    public void testProductNameDisplay() {
        // Fetch the expected product name for the first product
        String expectedProductName = TestData.EXPECTED_PRODUCT_NAMES.get(0);

        // Get the actual product name from the product details page
        String actualProductName = productDetailsPage.getProductName();

        // Assert that the actual product name matches the expected name
        Assert.assertEquals(actualProductName, expectedProductName, "The product name displayed on the product details page does not match the expected name.");
    }

    @Test(testName = "TC002 - Verify product description display")
    public void testProductDescriptionDisplay() {
        // Fetch the expected product description for the first product
        String expectedProductDescription = TestData.EXPECTED_PRODUCT_DESCRIPTIONS.get(0);

        // Get the actual product description from the product details page
        String actualProductDescription = productDetailsPage.getProductDescription();

        // Assert that the actual product description matches the expected description
        Assert.assertEquals(actualProductDescription, expectedProductDescription, "The product description displayed on the product details page does not match the expected description.");
    }

    @Test(testName = "TC003 - Verify product image is displayed")
    public void testProductImageDisplay() {
        Assert.assertTrue(productDetailsPage.isProductImgDisplayed(), "The product image is not displayed on the product details page.");
    }

    @Test(testName = "TC004 - Verify product price display")
    public void testProductPriceDisplay() {
        // Fetch the expected product price for the first product
        String expectedProductPrice = TestData.EXPECTED_PRODUCT_PRICES.get(0);

        // Get the actual product price from the product details page
        String actualProductPrice = productDetailsPage.getProductPrice();

        // Assert that the actual product price matches the expected price
        Assert.assertEquals(actualProductPrice, expectedProductPrice, "The product price displayed on the product details page does not match the expected price.");
    }

    @Test(testName = "TC005 - Verify Add to Cart button is accessible")
    public void testAddToCartButtonAccessible() {
        // Verify that the Add to cart button is accessible on the product details page
        Assert.assertTrue(productDetailsPage.isAddToCartButtonAccessible(), "The Add to Cart button is not accessible on the product details page.");

        //
        String expectedAddToCartText = TestData.ADD_TO_CART_BUTTON_TEXT;
        String actualAddToCartText = productDetailsPage.getAddToCartButtonText();
        Assert.assertEquals(actualAddToCartText, expectedAddToCartText, "The Add to Cart button text does not match the expected value.");
    }

    @Test(testName = "TC006 - Verify Back to Products button is accessible")
    public void testBackToProductsButtonAccessible() {
        // Verify that the Back to Products button is accessible on the product details page
        Assert.assertTrue(productDetailsPage.isBackToProductsButtonAccessible(), "The Back to Products button is not accessible on the product details page.");

        String expectedBackToProductsButtonText = TestData.BACK_TO_PRODUCTS_TEXT;
        String actualBackToProductsButtonText = productDetailsPage.getBackToProductsText();
        Assert.assertEquals(actualBackToProductsButtonText, expectedBackToProductsButtonText, "The Back to Products button text does not match the expected value.");
    }

    @Test(testName = "TC007 - Verify adding a product to the cart from the product details page")
    public void testAddProductToCartFromDetails() {
        // Add the product to the cart
        productDetailsPage.addProductToCart();

        // Verify the cart badge is displayed
        Assert.assertTrue(productDetailsPage.isCartBadgeDisplayed(), "The cart badge is not displayed after adding a product.");

        // Verify the cart item count is updated to 1
        Assert.assertEquals(productDetailsPage.getCartItemCount(), 1, "The cart item count is not updated correctly after adding a product.");

        // Verify the "Remove" button text is displayed correctly
        Assert.assertEquals(productDetailsPage.getRemoveButtonText(), TestData.REMOVE_BUTTON_TEXT, "The 'Remove' button text does not match the expected value.");
    }

    @Test(testName = "TC008 - Verify removing a product from the cart from the product details page")
    public void testRemoveProductFromCartFromDetails() {
        // Add the product to the cart
        productDetailsPage.addProductToCart();

        // Verify the cart badge is displayed
        Assert.assertTrue(productDetailsPage.isCartBadgeDisplayed(), "The cart badge is not displayed after adding a product.");

        // Verify the cart item count is updated to 1
        Assert.assertEquals(productDetailsPage.getCartItemCount(), 1, "The cart item count is not updated correctly after adding a product.");

        // Verify the "Remove" button text is displayed correctly
        Assert.assertEquals(productDetailsPage.getRemoveButtonText(), TestData.REMOVE_BUTTON_TEXT, "The 'Remove' button text does not match the expected value.");

        // Remove the product from the cart
        productDetailsPage.removeProductFromCart();

        // Verify the cart badge is no longer displayed after removing the product
        Assert.assertFalse(productDetailsPage.isCartBadgeDisplayed(), "The cart badge is still displayed after removing the product.");

        // Verify the cart item count is updated to 0 after removing the product
        Assert.assertEquals(productDetailsPage.getCartItemCount(), 0, "The cart item count is not updated correctly after removing the product.");

        // Verify the "Add to Cart" button text is displayed correctly after removing the product
        Assert.assertEquals(productDetailsPage.getAddToCartButtonText(), TestData.ADD_TO_CART_BUTTON_TEXT, "The 'Add to Cart' button text does not match the expected value after removing the product.");
    }
}
