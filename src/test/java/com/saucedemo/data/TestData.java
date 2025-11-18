package com.saucedemo.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {
    // Valid credentials
    public static final String STANDARD_USER = "standard_user";
    public static final String LOCK_OUT_USER = "locked_out_user";
    public static final String PROBLEM_USER = "problem_user";
    public static final String PERFORMANCE_GLITCH_USER = "performance_glitch_user";
    public static final String ERROR_USER = "error_user";
    public static final String VISUAL_USER = "visual_user";
    public static final String PASSWORD = "secret_sauce";

    // Invalid credentials
    public static final String INVALID_USER = "invalid_user";
    public static final String INVALID_PASSWORD = "invalid_password";
    public static final String EMPTY_USER = "";
    public static final String EMPTY_PASSWORD = "";

    // URLs
    public static final String BASE_URL = "https://www.saucedemo.com";

    // Error messages
    public static final String ERROR_USERNAME_REQUIRED = "Epic sadface: Username is required";
    public static final String ERROR_PASSWORD_REQUIRED = "Epic sadface: Password is required";
    public static final String ERROR_LOCKED_OUT_USER = "Epic sadface: Sorry, this user has been locked out.";
    public static final String ERROR_INVALID_CREDENTIALS = "Epic sadface: Username and password do not match any user in this service";

    // Products data
    public static final List<String> EXPECTED_PRODUCT_NAMES = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");
    public static final List<String> EXPECTED_PRODUCT_PRICES = Arrays.asList("$29.99", "$9.99", "$15.99", "$49.99", "$7.99", "$15.99");
    public static final List<String> EXPECTED_PRODUCT_DESCRIPTIONS = Arrays.asList("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.", "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.");
    public static final int EXPECTED_PRODUCT_COUNT = 6;
    public static final int EXPECTED_SINGLE_CART_BADGE = 1;
    public static final String REMOVE_BUTTON_TEXT = "Remove";
}
