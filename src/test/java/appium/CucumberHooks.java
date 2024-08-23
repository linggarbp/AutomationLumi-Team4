package appium;

import appium.testcases.Login.LoginPositive;
import io.cucumber.java.*;

public class CucumberHooks
{
    @BeforeAll
    public static void SetUp()
    {
        LoginPositive.SetUp();
    }

    @AfterAll
    public static void TearDown()
    {
        LoginPositive.TearDown();
    }
}