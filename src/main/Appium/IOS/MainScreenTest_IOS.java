package main.Appium.IOS;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import main.Appium.Pages.LoginScreenPage;
import main.Appium.Pages.MainScreenPage;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 12/11/2017.
 */
public class MainScreenTest_IOS {
    public static final String USERNAME = "David_Peles";
    public static final String ACCESS_KEY = "1185f630-d88b-425e-b0ee-0bfcf07f457f";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    public static IOSDriver driver;
    private LoginScreenPage loginScreenPage;
    private MainScreenPage mainScreen;


    @BeforeTest
    public void setUp() throws MalformedURLException, InterruptedException {
//        DesiredCapabilities capabilities = new DesiredCapabilities().android();
//        capabilities.setCapability("deviceName", "b4b611d2");
//        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
//        capabilities.setCapability(CapabilityType.VERSION, "7.1.1");
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("autoAcceptAlerts", true);
//        capabilities.setCapability("app", "C:\\Users\\User\\Downloads\\appproductiondebug.apk");
//        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        DesiredCapabilities caps = DesiredCapabilities.iphone();
        caps.setCapability("appiumVersion", "1.6.4");
        caps.setCapability("deviceName","iPhone 7 Simulator");
        caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("platformVersion","10.2");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("browserName", "");
        caps.setCapability("app","sauce-storage:MOEStudents1.zip");
        driver = new IOSDriver(new URL(URL), caps);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainScreen = new MainScreenPage(driver);
        loginScreenPage = new LoginScreenPage(driver);
        loginScreenPage.TestLoginPositive();

    }


//    @Test( priority = 4 )
//    public void FindElementsInList() throws Exception {
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        mainScreen.FindElementsInList();
//    }
//    @Test( priority = 3 )
//    public void FindNextTestInList() throws Exception {
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        mainScreen.FindNextTestInList();
//    }
//
//    @Test( priority = 2 )
//    public void DistrussBtn() throws Exception {
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        mainScreen.DistrussBtn();
//    }
//    @Test( priority = 1 )
//    public void Dashboard_Messages() throws Exception {
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        mainScreen.Dashboard_Messages();
//    }
    @Test( priority = 0 )
    public void Dashboard_UI() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainScreen.Dashboard_UI();
    }

    @AfterTest
    public void End () {
        driver.quit();
    }

}
