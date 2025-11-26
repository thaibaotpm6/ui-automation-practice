package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {
    @FindBy(id = "back-to-products")
    private WebElement backToProducts;

    @FindBy(className = "inventory_details_name")
    private WebElement productName;

    @FindBy(className = "inventory_details_desc")
    private WebElement productDesc;

    @FindBy(css = "img.inventory_details_img")
    WebElement productImg;

    @FindBy(className = "inventory_details_price")
    private WebElement productPrice;

    @FindBy(className = "btn_inventory")
    private WebElement addToCartButton;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    @FindBy(css = "#remove")
    WebElement removeButton;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBackToProductsButtonAccessible() {
        return backToProducts.isDisplayed() && backToProducts.isEnabled();
    }

    public boolean isProductNameDisplayed() {
        return productName.isDisplayed();
    }

    public boolean isProductDescDisplayed() {
        return productDesc.isDisplayed();
    }

    public boolean isProductImgDisplayed() {
        return productImg.isDisplayed();
    }

    public boolean isProductPriceDisplayed() {
        return productPrice.isDisplayed();
    }

    public boolean isAddToCartButtonAccessible() {
        return addToCartButton.isDisplayed() && addToCartButton.isEnabled();
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductDescription() {
        return productDesc.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public ProductsPage clickBackToProductsButton() {
        backToProducts.click();
        return new ProductsPage(driver);
    }

    public boolean isUIComplete() {
        if (!isProductNameDisplayed()) System.out.println("Product Name missing");
        if (!isProductDescDisplayed()) System.out.println("Product Description missing");
        if (!isProductPriceDisplayed()) System.out.println("Product Price missing");
        if (!isProductImgDisplayed()) System.out.println("Product Image missing");
        if (!isAddToCartButtonAccessible()) System.out.println("Add to Cart Button missing");
        if (!isBackToProductsButtonAccessible()) System.out.println("Back Button missing");
        return isProductNameDisplayed()
                && isProductDescDisplayed()
                && isProductPriceDisplayed()
                && isProductImgDisplayed()
                && isAddToCartButtonAccessible()
                && isBackToProductsButtonAccessible();
    }

    public void addProductToCart() {
        addToCartButton.click();
    }

    public String getAddToCartButtonText() {
        return addToCartButton.getText();
    }

    public String getBackToProductsText() {
        return backToProducts.getText();
    }

    public int getCartItemCount() {
        try {
            return Integer.parseInt(cartBadge.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public String getRemoveButtonText() {
        return removeButton.getText();
    }

    public boolean isCartBadgeDisplayed() {
        try {
            return cartBadge.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void removeProductFromCart() {
        removeButton.click();
    }
}
