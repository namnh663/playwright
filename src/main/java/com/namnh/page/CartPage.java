package com.namnh.page;

import com.microsoft.playwright.Page;
import com.namnh.core.AbstractMain;
import com.namnh.elements.CartElements;

public class CartPage extends AbstractMain{

    public CartPage(Page page) {
        this.page = page;
    }

    public void openPage() {
        open(CartElements.cart_url);
    }

    public void verifyUrl() {
        matchUrl(CartElements.cart_url);
    }

    public void continueShopping() {
        click(CartElements.continue_shopping_btn);
    }

    public void removeBikeLight() {
        click(CartElements.remove_sauce_labs_bike_light_btn);
    }
}
