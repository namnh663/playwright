package com.namnh.page;

import com.microsoft.playwright.Page;
import com.namnh.core.AbstractMain;
import com.namnh.elements.LoginElements;

public class LoginPage extends AbstractMain {    
    
    public LoginPage(Page page) {
        this.page = page;
    }

    public void openPage() {
        open(LoginElements.login_url);
    }

    public void login() {
        click(LoginElements.login_btn);
    }

    public void inputToUsername(String value) {
        input(LoginElements.username_txt, value);
    }

    public void inputToPassword(String value) {
        input(LoginElements.password_txt, value);
    }

    public void verifyTitle() {
        matchTitle(LoginElements.login_title);
    }

    public void verifyErrorMessage(String expected) {
        matchText(LoginElements.error_msg, expected);
    }
}
