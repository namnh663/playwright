package com.namnh.core;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
import com.namnh.page.CartPage;
import com.namnh.page.HomePage;
import com.namnh.page.LoginPage;

public class AbstractMain {

    public Playwright playwright;
    public Browser browser;
    public Page page;
    public BrowserContext context;
    private List<String> list;
    public LoginPage loginPage;
    public HomePage homePage;
    public CartPage cartPage;

    public void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
        context = browser.newContext();
        page = context.newPage();
        loginPage = new LoginPage(page);
    }

    public void setCookies() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
        context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("state.json")));
        page = context.newPage();
        homePage = new HomePage(page);
    }

    public int toInt(String str) {
        return Integer.parseInt(str);
    }

    public void print(String str) {
        System.out.println(str);
    }

    public void print(Object[] obj) {
        System.out.println(obj);
    }

    public void print(boolean bool) {
        System.out.println(bool);
    }

    public void print(List<String> strList) {
        System.out.println(strList);
    }

    public List<String> trimWith(List<String> strList, String prefix) {
        list = new ArrayList<String>(strList.size());
        for(int i = 0; i < strList.size(); i++) {
            String value = strList.get(i).trim();
            if(value.startsWith(prefix)) {
                value = value.substring(1);
            }
            list.add(value);
        }
        return list;
    }

    public void saveCookiesAsJson() {
        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("state.json")));
    }

    public Locator locator(String selector) {
        return page.locator(selector);
    }

    public String getText(String selector) {
        return page.locator(selector).textContent();
    }

    public List<String> actualList(String selector) {
        return page.locator(selector).allTextContents();
    }

    public void open(String url) {
        page.navigate(url);
    }

    public void input(String selector, String value) {
        page.locator(selector).fill(value);
    }

    public boolean isCount(String selector, int expected) {
        int itemNumber = toInt(getText(selector));
        if(itemNumber == expected) {
            return true;
        }
        return false; 
    }

    public boolean isSortAsc(String selector) {
        list = new ArrayList<>(actualList(selector));
        Collections.sort(list);
        return list.equals(actualList(selector));
    }

    public boolean isSortDesc(String selector) {
        list = new ArrayList<>(actualList(selector));
        Collections.sort(list);
        Collections.reverse(list);
        return list.equals(actualList(selector));
    }

    public void click(String selector) {
        page.locator(selector).click();
    }

    public void selectByValue(String selector, String value) {
        page.locator(selector).selectOption(value);
    }

    public void selectByIndex(String selector, int index) {
        page.locator(selector).selectOption(new SelectOption().setIndex(index));
    }

    public void matchTitle(String expected) {
        assertThat(page).hasTitle(expected);
    }

    public void matchUrl(String expected) {
        assertThat(page).hasURL(expected);
    }

    public void matchText(String selector, String expected) {
        assertThat(locator(selector)).hasText(expected);
    }

    public void visible(String selector) {
        assertThat(locator(selector)).isVisible();
    }
}
