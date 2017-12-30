package main.Appium.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by User on 08/11/2017.
 */
public class LoginScreenPage extends Page_Base{




    @iOSFindBy(accessibility = "Login_TextBox_UserName")
   // @AndroidFindBy(id = "HIN_USERID")
    @AndroidFindBy(accessibility = "Login_TextBox_UserName")
    private MobileElement Login_TextBox_UserName;

    @iOSFindBy(accessibility = "Login_TextBox_Password")
   // @AndroidFindBy(id = "Ecom_Password")
    @AndroidFindBy(accessibility = "Login_TextBox_Password")
    private MobileElement Login_TextBox_Password;

    @iOSFindBy(accessibility = "Login_Button_Submit")
   // @AndroidFindBy(id = "loginButton2")
    @AndroidFindBy(accessibility = "Login_Button_Submit")
    private MobileElement Login_Button_Submit;



    public LoginScreenPage(AppiumDriver driver) {
        super(driver);
    }



    public  void TestLoginPositive() throws InterruptedException {
        Login_TextBox_UserName.sendKeys("036367001");
        Login_TextBox_Password.clear();
        Login_TextBox_Password.sendKeys("Vfr456yh");
        super.driver.hideKeyboard();
        Login_Button_Submit.click();
        super.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }


    public void TestLoginNegative () throws InterruptedException {
        Login_Button_Submit.click();
        super.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(Login_TextBox_UserName.isDisplayed(), "Targeted element App is not present on screen");
        System.out.println("Targeted element App is present on screen.");

    }


}
