package main.Appium.Android;

import io.appium.java_client.android.AndroidDriver;
import main.Appium.Pages.ExtentReporterNG;
import main.Appium.Pages.LoginScreenPage;
import main.Appium.Pages.MainScreenPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 08/11/2017.
 */
@Listeners(ExtentReporterNG.class)
public class LoginScreenTest_Android {

    private static AndroidDriver driver;
    private LoginScreenPage loginScreenPage;
    private MainScreenPage mainScreenPage;
    public static WebElement Button_YES= null;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities().android();
        capabilities.setCapability("deviceName", "b4b611d2");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability(CapabilityType.VERSION, "7.1.1");
        capabilities.setCapability("platformName", "Android");
        // capabilities.setCapability("autoAcceptAlerts", true);
       capabilities.setCapability("app", "C:\\Users\\User\\Desktop\\MOE\\app-Develop-debug_original.apk");
       // capabilities.setCapability("app", "C:\\Users\\User\\Desktop\\MOE_app\\appProductiondebug.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        Button_YES = driver.findElement(By.id("button1"));
//        Button_YES.click();
        loginScreenPage = new LoginScreenPage(driver);
        mainScreenPage = new MainScreenPage(driver);
    }

    @Test( priority = 1 )
    public void TestLoginPositive() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginScreenPage.TestLoginPositive();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(mainScreenPage.isElementPresent(),"Targeted element App is not present on screen") ;
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
