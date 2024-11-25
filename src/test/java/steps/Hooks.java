package steps;

import base.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    BaseTest baseTest = new BaseTest();

    @Before
    public void setUp() throws Exception {
        baseTest.setUp();
    }

    @After
    public void tearDown() {
        baseTest.tearDown();
    }
}