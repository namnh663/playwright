package com.namnh.suite;

import org.junit.Before;
import org.junit.Test;

import com.namnh.elements.HomeElements;
import com.namnh.extend.AbstractTest;

public class Sort extends AbstractTest {
    @Before
    public void before() {
        setCookies();
    }

    @Test
    public void sortAzByName() {
        homePage.openPage();
        homePage.sortByNameAsc();
        matchListAsc(HomeElements.item_name_list);
    }

    @Test
    public void sortZaByName() {
        homePage.openPage();
        homePage.sortByNameDesc();
        matchListDesc(HomeElements.item_name_list);
    }
}