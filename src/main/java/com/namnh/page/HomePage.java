package com.namnh.page;

import com.microsoft.playwright.Page;
import com.namnh.core.AbstractMain;
import com.namnh.elements.HomeElements;

public class HomePage extends AbstractMain {
    
    public HomePage(Page page) {
        this.page = page;
    }

    public void openPage() {
        open(HomeElements.home_url);
    }

    public void verifyUrl() {
        matchUrl(HomeElements.home_url);
    }

    public void clickToCart() {
        click(HomeElements.cart_ico);
    }

    public void showItemNumber() {
        visible(HomeElements.item_number);
    }

    public void sortByNameAsc() {
        selectByValue(HomeElements.sort_ico, "az");
    }

    public void sortByNameDesc() {
        selectByValue(HomeElements.sort_ico, "za");
    }

    public void sortByPriceLohi() {
        selectByIndex(HomeElements.sort_ico, 2);
    }

    public void addBackpackToCart() {
        click(HomeElements.add_sauce_labs_backpack_to_cart_btn);
    }

    public void addBikeLightToCart() {
        click(HomeElements.add_sauce_labs_bike_light_to_cart_btn);
    }
}
