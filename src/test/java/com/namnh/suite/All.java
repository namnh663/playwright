package com.namnh.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   Login.class,
   Sort.class,
   Cart.class
})

public class All {
    
}
