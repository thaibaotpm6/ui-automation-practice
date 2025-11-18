package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUsernameFieldDisplayed() {
        return usernameField.isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return passwordField.isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

    public boolean isLoginButtonEnabled() {
        return loginButton.isEnabled();
    }

    public void setUsernameField(String username) {
        set(usernameField, username);
    }

    public void setPasswordField(String password) {
        set(passwordField, password);
    }

    public ProductsPage clickLoginButton() {
        loginButton.click();
        return new ProductsPage(driver);
    }

    public ProductsPage login(String username, String password) {
        setUsernameField(username);
        setPasswordField(password);
        return clickLoginButton();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}
