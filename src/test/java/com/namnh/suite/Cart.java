package com.namnh.suite;

import org.junit.Before;
import org.junit.Test;

import com.namnh.elements.CartElements;
import com.namnh.elements.HomeElements;
import com.namnh.extend.AbstractTest;
import com.namnh.page.CartPage;
import com.namnh.page.HomePage;

public class Cart extends AbstractTest {
    @Before
    public void before() {
        setCookies();
    }

    @Test
    public void addItem() {
        homePage.openPage();
        homePage.addBackpackToCart();
        homePage.addBikeLightToCart();
        homePage.showItemNumber();
        matchItemNumber(HomeElements.item_number, 2);
    }

    @Test
    public void removeItemInCart() {
        homePage.openPage();
        homePage.addBackpackToCart();
        homePage.showItemNumber();
        matchItemNumber(HomeElements.item_number, 1);
        homePage.clickToCart();
        cartPage = new CartPage(page);
        cartPage.verifyUrl();
        visible(CartElements.cart_item);
        cartPage.continueShopping();
        homePage = new HomePage(page);
        homePage.verifyUrl();
        homePage.addBikeLightToCart();
        homePage.showItemNumber();
        matchItemNumber(HomeElements.item_number, 2);
        homePage.clickToCart();
        cartPage = new CartPage(page);
        cartPage.removeBikeLight();
        visible(CartElements.item_number);
        matchItemNumber(CartElements.item_number, 1);
    }
}
