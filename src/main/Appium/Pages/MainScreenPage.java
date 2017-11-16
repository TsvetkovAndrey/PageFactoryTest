package main.Appium.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

/**
 * Created by User on 07/11/2017.
 */
public class MainScreenPage extends Page_Base{


    public static List<String> beforeScrolling = asList("עמוד ראשי", "בחינות", "ציונים","התאמות","תרגול","בחינות לדוגמא","סימולטור","הודעות","שיעורים פרטיים");
    public static List<String> afterScrolling = asList("התאמות","תרגול","בחינות לדוגמא","סימולטור","הודעות","שיעורים פרטיים","מעורבות חברתית","הגדרות","התקדמות אישית","הגדרות");

    @AndroidFindBy(accessibility = "NavigationBar_Label_ScreenTitle")
    private MobileElement NavigationBar_Label_ScreenTitle;

    @AndroidFindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]")
    private MobileElement OldExamsTab;

    @AndroidFindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]")
    private MobileElement NewExamsTab;

    @AndroidFindBy(accessibility = "NavigationBar_Button_Hamburger")
    private MobileElement NavigationBar_Button_Hamburger;

    @AndroidFindBy(accessibility = "Navigation_Menu_RecyclerView")
    private MobileElement Navigation_Menu_RecyclerView;

    @AndroidFindBy(accessibility = "Navigation_Menu_Item_Title")
    private  List<WebElement> Navigation_Menu_Item_Title;

    @AndroidFindBy(id = "relativeLayoutDashboardFragmentFooter")
    private MobileElement relativeLayoutDashboardFragmentFooter;

    @AndroidFindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout")
    private MobileElement permission_deny_button;

    @AndroidFindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]")
    private MobileElement permission_allow_button;

    @AndroidFindBy(accessibility = "textViewDashBoardHeaderName")
    private MobileElement textViewDashBoardHeaderName;

    @AndroidFindBy(accessibility = "textViewDashBoardHeaderDate")
    private MobileElement textViewDashBoardHeaderDate;

    @AndroidFindBy(accessibility = "NavigationBar_Button_Envelope")
    private MobileElement NavigationBar_Button_Envelope;


    public MainScreenPage(AppiumDriver driver) {
          super(driver);
    }

    public void FindElementsInList() throws InterruptedException {

        NavigationBar_Button_Hamburger.click();
        System.out.println("size is"+  Navigation_Menu_Item_Title.size());

        for (WebElement element : Navigation_Menu_Item_Title) {
            System.out.println(element.getText());
        }

        for (int i=0;i<Navigation_Menu_Item_Title.size();i++) {
            Assert.assertEquals( Navigation_Menu_Item_Title.get(i).getText(),beforeScrolling.get(i)) ;

        }
        Navigation_Menu_Item_Title.get(1).click();
        NavigationBar_Button_Hamburger.click();
        Thread.sleep(3000);
        Dimension dimensions = super.driver.manage().window().getSize();
        int Startpoint = (int) (dimensions.getHeight() * 0.5);
        int scrollEnd = (int) (dimensions.getHeight() * 0.2);
        super.driver.swipe(0, Startpoint,0,scrollEnd,1000);
        Thread.sleep(3000);

        for (int i=0;i<Navigation_Menu_Item_Title.size();i++) {
            Assert.assertEquals( Navigation_Menu_Item_Title.get(i).getText(),afterScrolling.get(i)) ;

        }
        Navigation_Menu_Item_Title.get(7).click();
        super.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public void FindNextTestInList() throws InterruptedException {

        NavigationBar_Button_Hamburger.click();
        Navigation_Menu_Item_Title.get(1).click();
        super.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertTrue(NavigationBar_Label_ScreenTitle.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(NewExamsTab.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(OldExamsTab.isDisplayed(),"Targeted element App is not present on screen");
        OldExamsTab.click();
        NewExamsTab.click();
        super.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }


    public void DistrussBtn () throws InterruptedException {
        relativeLayoutDashboardFragmentFooter.click();
        super.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(permission_deny_button.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(permission_allow_button.isDisplayed(),"Targeted element App is not present on screen");
        permission_deny_button.click();
        super.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        try{
            super.driver.runAppInBackground(1);
        }catch(Exception e){}

        //driver.runAppInBackground(5);

    }


    public void Dashboard_UI() throws InterruptedException {
        Assert.assertTrue(textViewDashBoardHeaderName.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(textViewDashBoardHeaderDate.isDisplayed(),"Targeted element App is not present on screen");
        System.out.println(textViewDashBoardHeaderDate.getText() + "  " +  textViewDashBoardHeaderName.getText());
        super.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }
    public void Dashboard_Messages() throws InterruptedException {
        NavigationBar_Button_Envelope.click();
        super.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertTrue(NavigationBar_Label_ScreenTitle.isDisplayed(),"Targeted element App is not present on screen");
        System.out.println(NavigationBar_Label_ScreenTitle.getText());
//            List<WebElement> recyclerViewNotificationList = driver.findElement(By.id("recyclerViewNotificationList")).findElements(By.className("android.widget.RelativeLayout"));
//            System.out.println(recyclerViewNotificationList.size());
//            for (WebElement element : recyclerViewNotificationList) {
//                System.out.println(element.getText());
//            }
        super.driver.navigate().back();
        super.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


    }
}



//    public void verifyHeader(){
//        System.out.println("HOME_SCREEN_PAGE: Verifying Header appears.");
//        WebDriverWait wait = new WebDriverWait(this.driver, 30);
//        wait.until(ExpectedConditions.visibilityOf(header));
//    }
//
//    public void selectTextButton(){
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.elementToBeSelected(textButton));
//
//        System.out.println("HOME_SCREEN_PAGE: Selecting [TEXT] button.\n");
//        this.textButton.click();
//    }