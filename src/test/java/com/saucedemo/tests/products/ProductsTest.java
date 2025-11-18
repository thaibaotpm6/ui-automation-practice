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
        Assert.assertEquals(actualProductCount, TestData.EXPECTED_PRODUCT_COUNT);

        Assert.assertTrue(productsPage.areAllProductsDisplayed());

        Assert.assertTrue(productsPage.areAllProductNamesDisplayed());
        List<String> actualProductNames = productsPage.getAllProductNames();
        Assert.assertEquals(actualProductNames, TestData.EXPECTED_PRODUCT_NAMES);

        Assert.assertTrue(productsPage.areAllProductDescriptionsDisplayed());
        List<String> actualProductDescriptions = productsPage.getAllproductDescriptions();
        Assert.assertEquals(actualProductDescriptions, TestData.EXPECTED_PRODUCT_DESCRIPTIONS);

        Assert.assertTrue(productsPage.areAllProductPricesDisplayed());
        List<String> actualProductPrices = productsPage.getAllProductPrices();
        Assert.assertEquals(actualProductPrices, TestData.EXPECTED_PRODUCT_PRICES);

        Assert.assertTrue(productsPage.areAllProductImagesDisplayed());

        Assert.assertTrue(productsPage.areAllAddToCartButtonsDisplayed());
    }

    @Test(testName = "TC003 - Verify product names are displayed correctly")
    public void testProductNamesAreDisplayed() {
        List<String> actualProductNames = productsPage.getAllProductNames();
        for (int i = 0; i < actualProductNames.size(); i++) {
            Assert.assertEquals(actualProductNames.get(i), (TestData.EXPECTED_PRODUCT_NAMES).get(i));
        }
    }

    @Test(testName = "TC004 - Verify product descriptions are displayed correctly")
    public void testProductDescriptionsAreDisplayed() {
        List<String> actualProductDescriptions = productsPage.getAllproductDescriptions();
        for (int i = 0; i < actualProductDescriptions.size(); i++) {
            Assert.assertEquals(actualProductDescriptions.get(i), (TestData.EXPECTED_PRODUCT_DESCRIPTIONS).get(i));
        }
    }

    @Test(testName = "TC005 - Verify product prices are displayed correctly")
    public void testProductPricesAreDisplayed() {
        List<String> actualProductPrices = productsPage.getAllProductPrices();
        for (int i = 0; i < actualProductPrices.size(); i++) {
            Assert.assertEquals(actualProductPrices.get(i), (TestData.EXPECTED_PRODUCT_PRICES).get(i));
        }
    }

    @Test(testName = "TC006 - Add single product to cart")
    public void testAddSingleProductToCart() {
        Assert.assertTrue(productsPage.isCartBadgeDisplayed());
        int addToCartButtonCount = productsPage.getAddToCartButtonCount();
        for (int i = 0; i < addToCartButtonCount; i++) {
            Assert.assertEquals(productsPage.getCartBadgeItemCount(i), TestData.EXPECTED_SINGLE_CART_BADGE);
        }
    }
}
