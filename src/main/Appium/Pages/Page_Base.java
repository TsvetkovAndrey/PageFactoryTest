package main.Appium.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static main.Appium.IOS.LoginScreeTest_IOS.driver;

/**
 * Created by User on 12/11/2017.
 */
public abstract class Page_Base {

    public AppiumDriver driver;
    public Page_Base(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);

    }


}
