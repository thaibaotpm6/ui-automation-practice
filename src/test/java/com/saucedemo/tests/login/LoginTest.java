package com.saucedemo.tests.login;

import com.saucedemo.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.saucedemo.data.TestData;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginPageElementsVisibility() {
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed());
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed());
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
        Assert.assertTrue(loginPage.isLoginButtonEnabled());
    }

    @Test
    public void testLoginWithStandardUser() {
        productsPage = loginPage.login(TestData.STANDARD_USER, TestData.PASSWORD);
        productsPage.isProductsHeaderDisplayed();
    }

    @Test
    public void testLoginWithProblemUser() {
        productsPage = loginPage.login(TestData.PROBLEM_USER, TestData.PASSWORD);
        productsPage.isProductsHeaderDisplayed();
    }

    @Test
    public void testLoginWithPerformanceGlitchUser() {
        productsPage = loginPage.login(TestData.PERFORMANCE_GLITCH_USER, TestData.PASSWORD);
        productsPage.isProductsHeaderDisplayed();
    }

    @Test
    public void testLoginWithErrorUser() {
        productsPage = loginPage.login(TestData.ERROR_USER,TestData.PASSWORD);
        productsPage.isProductsHeaderDisplayed();
    }

    @Test
    public void testLoginWithVisualUser() {
        productsPage = loginPage.login(TestData.VISUAL_USER, TestData.PASSWORD);
        productsPage.isProductsHeaderDisplayed();
    }

    @Test
    public void testLoginWithLockedOutUser() {
        loginPage.login(TestData.LOCK_OUT_USER, TestData.PASSWORD);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, TestData.ERROR_LOCKED_OUT_USER);
    }

    @Test
    public void testLoginWithInvalidUsername() {
        loginPage.login(TestData.INVALID_USER, TestData.PASSWORD);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, TestData.ERROR_INVALID_CREDENTIALS);
    }

    @Test
    public void testLoginWithInvalidPassword() {
        loginPage.login(TestData.STANDARD_USER, TestData.INVALID_PASSWORD);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, TestData.ERROR_INVALID_CREDENTIALS);
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        loginPage.login(TestData.INVALID_USER, TestData.INVALID_PASSWORD);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, TestData.ERROR_INVALID_CREDENTIALS);
    }

    @Test
    public void testLoginWithEmptyUsername() {
        loginPage.login(TestData.EMPTY_USER, TestData.PASSWORD);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, TestData.ERROR_USERNAME_REQUIRED);
    }

    @Test
    public void testLoginWithEmptyPassword() {
        loginPage.login(TestData.STANDARD_USER, TestData.EMPTY_PASSWORD);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, TestData.ERROR_PASSWORD_REQUIRED);
    }

    @Test
    public void testLoginWithEmptyCredentials() {
        loginPage.login(TestData.EMPTY_USER, TestData.EMPTY_PASSWORD);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, TestData.ERROR_USERNAME_REQUIRED);
    }
}

