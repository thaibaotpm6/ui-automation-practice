package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ProductsPage extends BasePage {
    @FindBy(css = ".title")
    private WebElement productsHeader;

    @FindBy(className = "inventory_item")
    private List<WebElement> productItems;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;

    @FindBy(className = "inventory_item_desc")
    private List<WebElement> productDescriptions;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> productPrices;

    @FindBy(css = ".btn_inventory")
    private List<WebElement> addToCartButtons;

    @FindBy(css = "img.inventory_item_img")
    private List<WebElement> productImages;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsHeaderDisplayed() {
        return productsHeader.isDisplayed();
    }

    public int getProductCount() {
        return productItems.size();
    }

    public boolean areAllProductsDisplayed() {
        if (productItems.isEmpty()) {
            return false;
        }
        for (WebElement product : productItems) {
            if (!product.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllProductNamesDisplayed() {
        if (productNames.isEmpty()) {
            return false;
        }
        for (WebElement productName : productNames) {
            if (!productName.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllProductDescriptionsDisplayed() {
        if (productDescriptions.isEmpty()) {
            return false;
        }
        for (WebElement productDesc : productDescriptions) {
            if (!productDesc.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllProductPricesDisplayed() {
        if (productPrices.isEmpty()) {
            return false;
        }
        for (WebElement productPrice : productPrices) {
            if (!productPrice.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllProductImagesDisplayed() {
        if (productImages.isEmpty()) {
            return false;
        }
        for (WebElement productImg : productImages) {
            if (!productImg.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllAddToCartButtonsDisplayed() {
        if (addToCartButtons.isEmpty()) {
            return false;
        }
        for (WebElement addToCartButton : addToCartButtons) {
            if (!addToCartButton.isDisplayed() || !addToCartButton.isEnabled()) {
                return false;
            }
        }
        return true;
    }

    public List<String> getAllProductNames() {
        return productNames.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getAllproductDescriptions() {
        return productDescriptions.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getAllProductPrices() {
        return productPrices.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void addProductToCart(int index) {
        addToCartButtons.get(index).click();
    }

    public boolean isCartBadgeDisplayed() {
        try {
            return cartBadge.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getCartButtonText(int index) {
        return addToCartButtons.get(index).getText();
    }

    public int getCartBadgeItemCount() {
        try {
            return Integer.parseInt(cartBadge.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public void removeProductFromCart(int index) {
        addToCartButtons.get(index).click();
    }

    public void sortProducts(String sortOption) {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(sortOption);
    }

    public List<String> getProductNamesSortedAlphabetically(List<String> productNames) {
        return productNames.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());
    }

    public List<String> getProductNamesSortedReverseAlphabetically(List<String> productNames) {
        return productNames.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                .collect(Collectors.toList());
    }

    public List<String> getProductPricesSortedLowToHigh(List<String> productPrices) {
        return productPrices.stream()
                .map(price -> Double.parseDouble(price.replace("$", "")))
                .sorted()
                .map(price -> "$" + price)
                .collect(Collectors.toList());
    }

    public List<String> getProductPricesSortedHighToLow(List<String> productPrices) {
        return productPrices.stream()
                .map(price -> Double.parseDouble(price.replace("$", "")))
                .sorted(Comparator.reverseOrder())
                .map(price -> "$" + price)
                .collect(Collectors.toList());
    }
}
