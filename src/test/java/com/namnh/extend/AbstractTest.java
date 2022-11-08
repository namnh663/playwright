package com.namnh.extend;

import static org.junit.Assert.assertTrue;

import com.namnh.core.AbstractMain;

public class AbstractTest extends AbstractMain {

    public void matchListAsc(String selector) {
        assertTrue(isSortAsc(selector));
    }

    public void matchListDesc(String selector) {
        assertTrue(isSortDesc(selector));
    }

    public void matchItemNumber(String selector, int expected) {
        assertTrue(isCount(selector, expected));
    }
}
