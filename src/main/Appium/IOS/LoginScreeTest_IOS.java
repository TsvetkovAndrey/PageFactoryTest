package main.Appium.IOS;

import io.appium.java_client.ios.IOSDriver;
import main.Appium.Pages.LoginScreenPage;
import main.Appium.Pages.MainScreenPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 12/11/2017.
 */
public class LoginScreeTest_IOS {

    public static final String USERNAME = "David_Peles";
    public static final String ACCESS_KEY = "1185f630-d88b-425e-b0ee-0bfcf07f457f";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    public static IOSDriver driver;
    private LoginScreenPage loginScreenPage;


    @BeforeClass
    public  void setup() throws MalformedURLException {

            DesiredCapabilities caps = DesiredCapabilities.iphone();
            caps.setCapability("appiumVersion", "1.6.4");
            caps.setCapability("deviceName","iPhone 7 Simulator");
            caps.setCapability("deviceOrientation", "portrait");
            caps.setCapability("platformVersion","10.2");
            caps.setCapability("platformName", "iOS");
            caps.setCapability("browserName", "");
            caps.setCapability("app","sauce-storage:MOEStudents1.zip");
            driver = new IOSDriver(new URL(URL), caps);
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            loginScreenPage = new LoginScreenPage(driver);
    }

    @Test( priority = 1 )
    public void TestLoginPositive() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginScreenPage.TestLoginPositive();

    }
    @Test( priority = 0 )
    public void TestLoginNegative() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginScreenPage.TestLoginNegative();
    }

    @AfterTest
    public void End () {
        driver.quit();
    }
}
