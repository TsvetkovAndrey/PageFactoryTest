package main.Appium.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

/**
 * Created by User on 07/11/2017.
 */
public class MainScreenPage extends Page_Base{

    //@iOSFindBy(accessibility = "NavigationBar_Label_ScreenTitle")
    @AndroidFindBy(accessibility = "NavigationBar_Label_ScreenTitle")
    private MobileElement NavigationBar_Label_ScreenTitle;

    @AndroidFindBy(id = "relativeLayoutDashboardFragmentFooter")
    private MobileElement relativeLayoutDashboardFragmentFooter;

    @AndroidFindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout")
    private MobileElement permission_deny_button;

    @AndroidFindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]")
    private MobileElement permission_allow_button;

    @AndroidFindBy(id = "textViewDashBoardHeaderName")
    private MobileElement textViewDashBoardHeaderName;

    @iOSFindBy(id = "Dashboard_Header_Label_CurrentDate")
    @AndroidFindBy(id = "textViewDashBoardHeaderDate")
    private MobileElement textViewDashBoardHeaderDate;

    @AndroidFindBy(accessibility = "NavigationBar_Button_Envelope")
    private MobileElement NavigationBar_Button_Envelope;

    //the next exam elements
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_NextTest_Label_TimeLeftIndication")
    private MobileElement Dashboard_Rectangle_NextTest_Label_TimeLeftIndication;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_NextTest_Label_NextTest")
    private MobileElement Dashboard_Rectangle_NextTest_Label_NextTest;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_NextTest_Icon_TestSymbol")
    private MobileElement Dashboard_Rectangle_NextTest_Icon_TestSymbol;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_NextTest_Label_TestName")
    private MobileElement Dashboard_Rectangle_NextTest_Label_TestName;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_NextTest_Label_TestDate")
    private MobileElement Dashboard_Rectangle_NextTest_Label_TestDate;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_NextTest_Symbol_Adjustment_Top")
    private MobileElement Dashboard_Rectangle_NextTest_Symbol_Adjustment_Top;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_NextTest_Symbol_Adjustment_Middle")
    private MobileElement Dashboard_Rectangle_NextTest_Symbol_Adjustment_Middle;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_NextTest_Symbol_Adjustment_Bottom")
    private MobileElement Dashboard_Rectangle_NextTest_Symbol_Adjustment_Bottom;

    //VacationCalendar elements
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_Vacations")
    private MobileElement Dashboard_Rectangle_Vacations;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_Vacations_Label_NexrVacation")
    private MobileElement Dashboard_Rectangle_Vacations_Label_NexrVacation;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_Vacations_Label_VacationName")
    private MobileElement Dashboard_Rectangle_Vacations_Label_VacationName;

   //GradeAverage elements
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_GradeAvarage")
    private MobileElement Dashboard_Rectangle_GradeAvarage;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_GradeAvarage_Label_GeneralGradeAvarage")
    private MobileElement Dashboard_Rectangle_GradeAvarage_Label_GeneralGradeAvarage;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_GradeAvarage_Label_AvarageQuantity")
    private MobileElement Dashboard_Rectangle_GradeAvarage_Label_AvarageQuantity;

    //Adjustments elements
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_Adjustments")
    private MobileElement Dashboard_Rectangle_Adjustments;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_Adjustments_Label_Adjustments")
    private MobileElement Dashboard_Rectangle_Adjustments_Label_Adjustments;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_Adjustments_Label_AdjustmentsQuantity")
    private MobileElement Dashboard_Rectangle_Adjustments_Label_AdjustmentsQuantity;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_Adjustments_Label_AdjustmentsList")
    private MobileElement Dashboard_Rectangle_Adjustments_Label_AdjustmentsList;

   // ExamsRemained elements
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_TestLeft")
    private MobileElement Dashboard_Rectangle_TestLeft;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_TestsLeft_Label_TestsLeft")
    private MobileElement Dashboard_Rectangle_TestsLeft_Label_TestsLeft;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_TestsLeft_Label_TestsLeftQuantity")
    private MobileElement Dashboard_Rectangle_TestsLeft_Label_TestsLeftQuantity;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_TestsLeft_Label_Tests")
    private MobileElement Dashboard_Rectangle_TestsLeft_Label_Tests;
    @AndroidFindBy(accessibility = "Dashboard_Rectangle_TestsLeft_Label_TestsOutOf")
    private MobileElement Dashboard_Rectangle_TestsLeft_Label_TestsOutOf;
    //Footer
    @AndroidFindBy(accessibility = "Dashboard_Footer_Emergency_Button_EmergencyButton")
    private MobileElement Dashboard_Footer_Emergency_Button_EmergencyButton;
    @AndroidFindBy(accessibility = "Dashboard_Footer_Emergency_Label_OpenLine")
    private MobileElement Dashboard_Footer_Emergency_Label_OpenLine;
    @AndroidFindBy(accessibility = "Dashboard_Footer_Emergency_Dialog_Label_DialogMessage")
    private MobileElement Dashboard_Footer_Emergency_Dialog_Label_DialogMessage;

    public MainScreenPage(AppiumDriver driver) {
          super(driver);
    }

    public boolean isElementPresent(){
        return  textViewDashBoardHeaderDate.isDisplayed();

    }

    public void FooterUI() throws InterruptedException{

        Assert.assertTrue(Dashboard_Footer_Emergency_Button_EmergencyButton.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Footer_Emergency_Label_OpenLine.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Footer_Emergency_Dialog_Label_DialogMessage.isDisplayed(),"Targeted element App is not present on screen");

    }

    public void TheNextExamUI() throws InterruptedException{

        Assert.assertTrue(Dashboard_Rectangle_NextTest_Label_TimeLeftIndication.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_NextTest_Label_NextTest.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_NextTest_Icon_TestSymbol.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_NextTest_Label_TestName.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_NextTest_Label_TestDate.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_NextTest_Symbol_Adjustment_Top.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_NextTest_Symbol_Adjustment_Middle.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_NextTest_Symbol_Adjustment_Bottom.isDisplayed(),"Targeted element App is not present on screen");

    }

    public void VacationCalendarUI() throws InterruptedException{

        Assert.assertTrue(Dashboard_Rectangle_Vacations.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_Vacations_Label_NexrVacation.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_Vacations_Label_VacationName.isDisplayed(),"Targeted element App is not present on screen");

    }

    public void GradeAverage() throws InterruptedException{

        Assert.assertTrue(Dashboard_Rectangle_GradeAvarage.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_GradeAvarage_Label_GeneralGradeAvarage.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_GradeAvarage_Label_AvarageQuantity.isDisplayed(),"Targeted element App is not present on screen");

    }

    public void AdjustmentsUI() throws InterruptedException{

        Assert.assertTrue(Dashboard_Rectangle_Adjustments.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_Adjustments_Label_Adjustments.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_Adjustments_Label_AdjustmentsQuantity.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_Adjustments_Label_AdjustmentsList.isDisplayed(),"Targeted element App is not present on screen");

    }

    public void ExamsRemainedUI() throws InterruptedException{
        ScrollEnd();
        Assert.assertTrue(Dashboard_Rectangle_TestLeft.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_TestsLeft_Label_TestsLeft.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_TestsLeft_Label_TestsLeftQuantity.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_TestsLeft_Label_Tests.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(Dashboard_Rectangle_TestsLeft_Label_TestsOutOf.isDisplayed(),"Targeted element App is not present on screen");

    }

    public void ClickAllCube()throws InterruptedException{
        Dashboard_Rectangle_GradeAvarage_Label_AvarageQuantity.click();
        super.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        super.driver.navigate().back();
        Dashboard_Rectangle_GradeAvarage_Label_AvarageQuantity.click();
        super.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        super.driver.navigate().back();
        Dashboard_Rectangle_GradeAvarage_Label_AvarageQuantity.click();
        super.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        super.driver.navigate().back();
        Dashboard_Rectangle_Vacations_Label_VacationName.click();
        super.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        super.driver.navigate().back();
        Dashboard_Rectangle_NextTest_Label_TestName.click();
        super.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        super.driver.navigate().back();
    }
    public void DistrussBtn () throws InterruptedException {
        relativeLayoutDashboardFragmentFooter.click();
        super.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(permission_deny_button.isDisplayed(),"Targeted element App is not present on screen");
//        Assert.assertTrue(permission_allow_button.isDisplayed(),"Targeted element App is not present on screen");
        permission_deny_button.click();
        super.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }


    public void Dashboard_UI() throws InterruptedException {
        Assert.assertTrue(textViewDashBoardHeaderName.isDisplayed(),"Targeted element App is not present on screen");
        Assert.assertTrue(textViewDashBoardHeaderDate.isDisplayed(),"Targeted element App is not present on screen");
        System.out.println(textViewDashBoardHeaderDate.getText() + "  " +  textViewDashBoardHeaderName.getText());
        super.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }
    public void Dashboard_Messages() throws InterruptedException {
        Assert.assertTrue(NavigationBar_Button_Envelope.isDisplayed(),"Targeted element App is not present on screen");
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

    private void ScrollEnd() throws InterruptedException {
        Thread.sleep(3000);
        Dimension dimensions = super.driver.manage().window().getSize();
        int Startpoint = (int) (dimensions.getHeight() * 0.5);
        int scrollEnd = (int) (dimensions.getHeight() * 0.2);
        super.driver.swipe(0, Startpoint,0,scrollEnd,1000);
        Thread.sleep(3000);
    }

}


