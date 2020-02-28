package com.bank.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.bank.testing.entity.AccountTest;

@RunWith(Suite.class)
@SuiteClasses({AccountTest.class})
public class AllTests {

}
