package com.saucedemo.tests.products;

import com.saucedemo.data.TestData;
import com.saucedemo.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsTest extends BaseTest {

    @BeforeMethod
    public void login() {
        productsPage = loginPage.login(TestData.STANDARD_USER, TestData.PASSWORD);
    }

    @Test(testName = "TC001 - Verify products page loads successfully after login")
    public void testProductsPageLoadsSuccessfully() {
        productsPage.isProductsHeaderDisplayed();
    }

    @Test(testName = "TC002 - Verify all 6 products are displayed")
    public void testAllProductsAreDisplayed() {
        int actualProductCount = productsPage.getProductCount();
        Assert.assertEquals(actualProductCount, TestData.EXPECTED_PRODUCT_COUNT, "Mismatch in the number of products displayed");

        Assert.assertTrue(productsPage.areAllProductsDisplayed(), "Not all products are displayed");

        Assert.assertTrue(productsPage.areAllProductNamesDisplayed(), "Not all product names are displayed");
        List<String> actualProductNames = productsPage.getAllProductNames();
        Assert.assertEquals(actualProductNames, TestData.EXPECTED_PRODUCT_NAMES, "Mismatch in product names");

        Assert.assertTrue(productsPage.areAllProductDescriptionsDisplayed(), "Not all product descriptions are displayed");
        List<String> actualProductDescriptions = productsPage.getAllproductDescriptions();
        Assert.assertEquals(actualProductDescriptions, TestData.EXPECTED_PRODUCT_DESCRIPTIONS, "Mismatch in product descriptions");

        Assert.assertTrue(productsPage.areAllProductPricesDisplayed(), "Not all product prices are displayed");
        List<String> actualProductPrices = productsPage.getAllProductPrices();
        Assert.assertEquals(actualProductPrices, TestData.EXPECTED_PRODUCT_PRICES, "Mismatch in product prices");

        Assert.assertTrue(productsPage.areAllProductImagesDisplayed(), "Not all product images are displayed");

        Assert.assertTrue(productsPage.areAllAddToCartButtonsDisplayed(), "Not all 'Add to Cart' buttons are displayed");
    }

    @Test(testName = "TC003 - Verify product names are displayed correctly")
    public void testProductNamesAreDisplayed() {
        List<String> actualProductNames = productsPage.getAllProductNames();
        for (int i = 0; i < actualProductNames.size(); i++) {
            Assert.assertEquals(actualProductNames.get(i), (TestData.EXPECTED_PRODUCT_NAMES).get(i), "Mismatch in product name at index " + i);
        }
    }

    @Test(testName = "TC004 - Verify product descriptions are displayed correctly")
    public void testProductDescriptionsAreDisplayed() {
        List<String> actualProductDescriptions = productsPage.getAllproductDescriptions();
        for (int i = 0; i < actualProductDescriptions.size(); i++) {
            Assert.assertEquals(actualProductDescriptions.get(i), (TestData.EXPECTED_PRODUCT_DESCRIPTIONS).get(i), "Mismatch in product description at index " + i);
        }
    }

    @Test(testName = "TC005 - Verify product prices are displayed correctly")
    public void testProductPricesAreDisplayed() {
        List<String> actualProductPrices = productsPage.getAllProductPrices();
        for (int i = 0; i < actualProductPrices.size(); i++) {
            Assert.assertEquals(actualProductPrices.get(i), (TestData.EXPECTED_PRODUCT_PRICES).get(i), "Mismatch in product price at index " + i);
        }
    }

    @Test(testName = "TC006 - Verify adding a single product to cart and verify cart badge")
    public void testAddSingleProductToCartAndVerifyCartBadge() {
        productsPage.addProductToCart(0); // Add the first product to the cart
        Assert.assertTrue(productsPage.isCartBadgeDisplayed(), "Cart badge is not displayed after adding the product");
        Assert.assertEquals(productsPage.getCartButtonText(0), TestData.REMOVE_BUTTON_TEXT, "Remove button text mismatch for the product");
        Assert.assertEquals(productsPage.getCartBadgeItemCount(), 1, "Cart badge count mismatch after adding the product");
    }

    @Test(testName = "TC007 - Verify adding all products to cart updates the cart badge correctly")
    public void testAddAllProductsToCartAndVerifyCartBadge() {
        int productCount = productsPage.getProductCount();
        for (int i = 0; i < productCount; i++) {
            productsPage.addProductToCart(i); // Add the product to the cart and verify the cart badge and button text
            Assert.assertTrue(productsPage.isCartBadgeDisplayed(), "Cart badge is not displayed after adding product " + i);
            Assert.assertEquals(productsPage.getCartBadgeItemCount(), i + 1, "Cart badge count mismatch after adding product " + i);
            Assert.assertEquals(productsPage.getCartButtonText(i), TestData.REMOVE_BUTTON_TEXT, "Remove button text mismatch for product " + i);
        }
    }

    @Test(testName = "TC008 - Verify Add to Cart button toggles to Remove and back to Add for single product")
    public void testAddToCartButtonToggleBehavior() {
        productsPage.addProductToCart(0); // Add the first product to the cart
        Assert.assertTrue(productsPage.isCartBadgeDisplayed(), "Cart badge is not displayed after adding the product");
        Assert.assertEquals(productsPage.getCartBadgeItemCount(), 1, "Cart badge count mismatch after adding the product");
        Assert.assertEquals(productsPage.getCartButtonText(0), TestData.REMOVE_BUTTON_TEXT, "Remove button text mismatch for the product");

        productsPage.removeProductFromCart(0); // Remove the first product from the cart
        Assert.assertFalse(productsPage.isCartBadgeDisplayed(), "Cart badge is still displayed after removing the product");
        Assert.assertEquals(productsPage.getCartButtonText(0), TestData.ADD_TO_CART_BUTTON_TEXT, "Add to Cart button text mismatch after removing the product");
    }

    @Test(testName = "TC009 - Verify Add to Cart button toggles to Remove and back to Add for multiple products")
    public void testAddToCartButtonToggleMultipleProducts() {
        int productCount = productsPage.getProductCount();

        for (int i = 0; i < productCount; i++) {
            productsPage.addProductToCart(i); // Add the product to the cart and verify the cart badge and button text
            Assert.assertTrue(productsPage.isCartBadgeDisplayed(), "Cart badge is not displayed after adding product " + i);
            Assert.assertEquals(productsPage.getCartBadgeItemCount(), i + 1, "Cart badge count mismatch after adding product " + i);
            Assert.assertEquals(productsPage.getCartButtonText(i), TestData.REMOVE_BUTTON_TEXT, "Remove button text mismatch for product " + i);
        }

        for (int i = 0; i < productCount; i++) {
            productsPage.removeProductFromCart(i); // Remove the product from the cart and verify the cart badge and button text
            int expectedCount = productCount - (i + 1);
            if (expectedCount == 0) {
                Assert.assertFalse(productsPage.isCartBadgeDisplayed(), "Cart badge is still displayed after removing all products " + i);
            } else {
                Assert.assertTrue(productsPage.isCartBadgeDisplayed(), "Cart badge is not displayed after adding product " + i);
            }
            Assert.assertEquals(productsPage.getCartBadgeItemCount(), expectedCount, "Cart badge count mismatch after adding product " + i);
            Assert.assertEquals(productsPage.getCartButtonText(i), TestData.ADD_TO_CART_BUTTON_TEXT, "Remove button text mismatch for product " + i);
        }
    }

    @Test(testName = "TC010 - Verify sorting of products by Name (A to Z)")
    public void testSortProductsByNameAToZ() {
        productsPage.sortProducts(TestData.SORT_BY_NAME_ASC);
        List<String> actualSortedNames = productsPage.getAllProductNames();
        List<String> expectedSortedNames = productsPage.getProductNamesSortedAlphabetically(TestData.EXPECTED_PRODUCT_NAMES);
        Assert.assertEquals(actualSortedNames, expectedSortedNames, "Product names are not sorted alphabetically (A to Z)");
    }

    @Test(testName = "TC011 - Verify sorting of products by Name (Z to A)")
    public void testSortProductsByNameZToA() {
        productsPage.sortProducts(TestData.SORT_BY_NAME_DESC);
        List<String> actualSortedNames = productsPage.getAllProductNames();
        List<String> expectedSortedNames = productsPage.getProductNamesSortedReverseAlphabetically(TestData.EXPECTED_PRODUCT_NAMES);
        Assert.assertEquals(actualSortedNames, expectedSortedNames, "Product names are not sorted alphabetically (Z to A)");    }

    @Test(testName = "TC012 - Verify sorting of products by Price (low to high)")
    public void testSortProductsByPriceLowToHigh() {
        productsPage.sortProducts(TestData.SORT_BY_PRICE_ASC);
        List<String> actualSortedPrices = productsPage.getAllProductPrices();
        List<String> expectedSortedPrices = productsPage.getProductPricesSortedLowToHigh(TestData.EXPECTED_PRODUCT_PRICES);
        Assert.assertEquals(actualSortedPrices, expectedSortedPrices, "Product prices are not sorted correctly (low to high)");
    }

    @Test(testName = "TC013 - Verify sorting of products by Price (high to low)")
    public void testSortProductsByPriceHighToLow() {
        productsPage.sortProducts(TestData.SORT_BY_PRICE_DESC);
        List<String> actualSortedPrices = productsPage.getAllProductPrices();
        List<String> expectedSortedPrices = productsPage.getProductPricesSortedHighToLow(TestData.EXPECTED_PRODUCT_PRICES);
        Assert.assertEquals(actualSortedPrices, expectedSortedPrices, "Product prices are not sorted correctly (high to low)");    }
}
