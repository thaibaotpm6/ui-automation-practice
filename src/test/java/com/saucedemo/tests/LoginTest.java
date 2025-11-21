package com.saucedemo.tests;

import com.saucedemo.data.TestData;
import com.saucedemo.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(testName = "TC001 - Verify login page elements visibility")
    public void testLoginPageElementsVisibility() {
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field is not displayed");
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field is not displayed");
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed");
        Assert.assertTrue(loginPage.isLoginButtonEnabled(), "Login button is not enabled");
    }

    @Test(testName = "TC002 - Verify login with standard user")
    public void testLoginWithStandardUser() {
        productsPage = loginPage.login(TestData.STANDARD_USER, TestData.PASSWORD);
        Assert.assertTrue(productsPage.isProductsHeaderDisplayed(), "Products header is not displayed after login");
    }

    @Test(testName = "TC003 - Verify login with problem user")
    public void testLoginWithProblemUser() {
        productsPage = loginPage.login(TestData.PROBLEM_USER, TestData.PASSWORD);
        Assert.assertTrue(productsPage.isProductsHeaderDisplayed(), "Products header is not displayed after login");
    }

    @Test(testName = "TC004 - Verify login with performance glitch user")
    public void testLoginWithPerformanceGlitchUser() {
        productsPage = loginPage.login(TestData.PERFORMANCE_GLITCH_USER, TestData.PASSWORD);
        Assert.assertTrue(productsPage.isProductsHeaderDisplayed(), "Products header is not displayed after login");
    }

    @Test(testName = "TC005 - Verify login with error user")
    public void testLoginWithErrorUser() {
        productsPage = loginPage.login(TestData.ERROR_USER, TestData.PASSWORD);
        Assert.assertTrue(productsPage.isProductsHeaderDisplayed(), "Products header is not displayed after login");
    }

    @Test(testName = "TC006 - Verify login with visual user")
    public void testLoginWithVisualUser() {
        productsPage = loginPage.login(TestData.VISUAL_USER, TestData.PASSWORD);
        Assert.assertTrue(productsPage.isProductsHeaderDisplayed(), "Products header is not displayed after login");
    }

    @Test(testName = "TC007 - Verify login with locked-out user")
    public void testLoginWithLockedOutUser() {
        loginPage.login(TestData.LOCK_OUT_USER, TestData.PASSWORD);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, TestData.ERROR_LOCKED_OUT_USER, "Error message mismatch for locked-out user");
    }

    @Test(testName = "TC008 - Verify login with invalid user")
    public void testLoginWithInvalidUsername() {
        loginPage.login(TestData.INVALID_USER, TestData.PASSWORD);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, TestData.ERROR_INVALID_CREDENTIALS, "Error message mismatch for invalid credentials");
    }

    @Test(testName = "TC009 - Verify login with invalid password")
    public void testLoginWithInvalidPassword() {
        loginPage.login(TestData.STANDARD_USER, TestData.INVALID_PASSWORD);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, TestData.ERROR_INVALID_CREDENTIALS, "Error message mismatch for invalid credentials");
    }

    @Test(testName = "TC010 - Verify login with invalid credentials")
    public void testLoginWithInvalidCredentials() {
        loginPage.login(TestData.INVALID_USER, TestData.INVALID_PASSWORD);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, TestData.ERROR_INVALID_CREDENTIALS, "Error message mismatch for invalid credentials");
    }

    @Test(testName = "TC011 - Verify login with empty username")
    public void testLoginWithEmptyUsername() {
        loginPage.login(TestData.EMPTY_USER, TestData.PASSWORD);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, TestData.ERROR_USERNAME_REQUIRED, "Error message mismatch for empty username");
    }

    @Test(testName = "TC012 - Verify login with empty password")
    public void testLoginWithEmptyPassword() {
        loginPage.login(TestData.STANDARD_USER, TestData.EMPTY_PASSWORD);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, TestData.ERROR_PASSWORD_REQUIRED, "Error message mismatch for empty password");
    }

    @Test(testName = "TC013 - Verify login with empty credentials")
    public void testLoginWithEmptyCredentials() {
        loginPage.login(TestData.EMPTY_USER, TestData.EMPTY_PASSWORD);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, TestData.ERROR_USERNAME_REQUIRED, "Error message mismatch for empty credentials");
    }
}

