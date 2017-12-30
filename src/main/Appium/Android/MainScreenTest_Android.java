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
 * Created by User on 07/11/2017.
 */
@Listeners(ExtentReporterNG.class)
public class MainScreenTest_Android {
    public static final String USERNAME = "David_Peles";
    public static final String ACCESS_KEY = "1185f630-d88b-425e-b0ee-0bfcf07f457f";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    private static AndroidDriver driver;
    private MainScreenPage mainScreen;
    private LoginScreenPage loginScreenPage;
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
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

//        DesiredCapabilities capabilities = new DesiredCapabilities().android();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("deviceName", "Android Emulator");
//        capabilities.setCapability("platformVersion", "6.0");
//        capabilities.setCapability("app", "sauce-storage:appproductiondebug.apk");
//        capabilities.setCapability("browserName", "");
//        capabilities.setCapability("deviceOrientation", "portrait");
//        capabilities.setCapability("appiumVersion", "1.7.1");
//        driver = new AndroidDriver(new URL(URL), capabilities);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        Button_YES = driver.findElement(By.id("button1"));
//        Button_YES.click();
        mainScreen = new MainScreenPage(driver);
        loginScreenPage = new LoginScreenPage(driver);
    }

    @Test( priority =10 )
    public void DistrussBtn() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainScreen.DistrussBtn();
    }
    @Test( priority = 9 )
    public void FooterUI() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainScreen.FooterUI();
    }
    @Test( priority = 8 )
    public void ClickAllCube() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainScreen.ClickAllCube();
    }
    @Test( priority = 7 )
    public void Dashboard_Messages() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainScreen.Dashboard_Messages();
    }
    @Test( priority = 6 )
    public void Dashboard_NameandDate_UI() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainScreen.Dashboard_UI();
    }

    @Test( priority = 5 )
    public void AdjustmentsUI() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainScreen.AdjustmentsUI();
    }
    @Test( priority = 4 )
    public void ExamsRemainedUI() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainScreen.ExamsRemainedUI();
    }
    @Test( priority = 3 )
    public void GradeAverage() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainScreen.GradeAverage();
    }
    @Test( priority = 2 )
    public void VacationCalendarUI() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainScreen.VacationCalendarUI();
    }
    @Test( priority = 1 )
    public void TheNextExamUI() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginScreenPage.TestLoginPositive();
        mainScreen.TheNextExamUI();
    }



    @AfterTest
    public void End () {
        driver.quit();
    }


}