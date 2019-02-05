package com.longhorn.tests.smoke_tests;

import com.longhorn.utilities.ApplicationConstants;
import com.longhorn.utilities.ConfigurationReader;
import com.longhorn.utilities.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NegativeLoginTest extends TestBase {
    @Test
    public  void negativelogintest() throws InterruptedException {
        extentLogger = report.createTest("Negative login test");
        pages.choseRightOne().rightButton.click();
        Thread.sleep(3000);
        pages.login().login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("wrongpassword"));
        extentLogger.info("Verifying");
        Thread.sleep(3000);

        assertEquals(pages.purchases().wrongCredentials.getText(), ApplicationConstants.WRONG_CREDENTIALS);
        extentLogger.pass("Failed: wrong password");

    }

    @Test
    public void negativelogintest1() throws InterruptedException {
        extentLogger = report.createTest("Negative login test");
        pages.choseRightOne().rightButton.click();
        Thread.sleep(3000);
        pages.login().login(ConfigurationReader.getProperty("wrongusername"), ConfigurationReader.getProperty("password"));
        extentLogger.info("Verifying");
        Thread.sleep(3000);
        assertEquals(pages.purchases().wrongCredentials.getText(), ApplicationConstants.WRONG_CREDENTIALS);
        extentLogger.pass("Failed: wrong username");
    }
}
