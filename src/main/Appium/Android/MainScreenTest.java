package main.Appium.Android;

import io.appium.java_client.android.AndroidDriver;
import main.Appium.Pages.MainScreenPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 07/11/2017.
 */
public class MainScreenTest {
    public static final String USERNAME = "David_Peles";
    public static final String ACCESS_KEY = "1185f630-d88b-425e-b0ee-0bfcf07f457f";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    private static AndroidDriver driver;
    private MainScreenPage mainScreen;
    public static WebElement Button_YES= null;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities().android();
        capabilities.setCapability("deviceName", "b4b611d2");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability(CapabilityType.VERSION, "7.1.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("app", "C:\\Users\\User\\Downloads\\appproductiondebug.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

//        DesiredCapabilities capabilities = new DesiredCapabilities().android();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("deviceName", "Android Emulator");
//        capabilities.setCapability("platformVersion", "5.1");
//        capabilities.setCapability("app", "sauce-storage:appproductiondebug.apk");
//        capabilities.setCapability("browserName", "");
//        capabilities.setCapability("deviceOrientation", "portrait");
//        capabilities.setCapability("appiumVersion", "1.6.4");
//        driver = new AndroidDriver(new URL(URL), capabilities);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Button_YES = driver.findElement(By.id("button1"));
        Button_YES.click();
        mainScreen = new MainScreenPage(driver);
    }


    @Test( priority = 4 )
    public void FindElementsInList() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainScreen.FindElementsInList();
    }
       @Test( priority = 3 )
    public void FindNextTestInList() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainScreen.FindNextTestInList();
    }

    @Test( priority = 2 )
    public void DistrussBtn() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainScreen.DistrussBtn();
    }
    @Test( priority = 1 )
    public void Dashboard_Messages() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainScreen.Dashboard_Messages();
    }
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