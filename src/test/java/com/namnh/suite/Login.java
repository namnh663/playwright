package com.namnh.suite;

import org.junit.Before;
import org.junit.Test;

import com.namnh.core.AbstractMain;
import com.namnh.data.Account;
import com.namnh.elements.LoginElements;
import com.namnh.page.HomePage;

public class Login extends AbstractMain {
    @Before
    public void before() {
        launchBrowser();
    }

    @Test
    public void successLogin() {
        loginPage.openPage();
        loginPage.verifyTitle();
        visible(LoginElements.logo);
        loginPage.inputToUsername(Account.Username.standard);
        loginPage.inputToPassword(Account.Password.for_all);
        loginPage.login();
        homePage = new HomePage(page);
        homePage.verifyUrl();
        saveCookiesAsJson();
    }

    @Test
    public void lockedAccount() {
        loginPage.openPage();
        loginPage.verifyTitle();
        visible(LoginElements.logo);
        loginPage.inputToUsername(Account.Username.locked);
        loginPage.inputToPassword(Account.Password.for_all);
        loginPage.login();
        loginPage.verifyErrorMessage(Account.Message.locked_msg);
    }

    @Test
    public void empty() {
        loginPage.openPage();
        loginPage.verifyTitle();
        visible(LoginElements.logo);
        loginPage.inputToUsername("");
        loginPage.inputToPassword("");
        loginPage.login();
        loginPage.verifyErrorMessage(Account.Message.empty_msg);
    }
}
