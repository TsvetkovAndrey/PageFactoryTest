package main.Appium.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by User on 08/11/2017.
 */
public class LoginScreenPage extends Page_Base{



    @AndroidFindBy(accessibility = "Login_TextBox_UserName")
    private MobileElement Login_TextBox_UserName;
    @AndroidFindBy(accessibility = "Login_TextBox_Password")
    private MobileElement Login_TextBox_Password;
    @AndroidFindBy(accessibility = "Login_Button_Submit")
    private MobileElement Login_Button_Submit;
    @AndroidFindBy(accessibility = "TextViewDashBoardHeaderName")
    private MobileElement Dashboard_Header_Label_StudentName;

    public LoginScreenPage(AppiumDriver driver) {
        super(driver);
    }



    public  void TestLoginPositive() throws InterruptedException {
        Login_TextBox_UserName.sendKeys("333333333");
        Login_TextBox_Password.clear();
        Login_TextBox_Password.sendKeys("123456");
        super.driver.hideKeyboard();
        Login_Button_Submit.click();
        super.driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        System.out.print(Dashboard_Header_Label_StudentName.getText());
        Assert.assertEquals("Sergey", Dashboard_Header_Label_StudentName.getText());

    }

    public void TestLoginNegative () throws InterruptedException {
        Login_Button_Submit.click();
        super.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(Login_TextBox_UserName.isDisplayed(), "Targeted element App is not present on screen");
        System.out.println("Targeted element App is present on screen.");


    }
}
