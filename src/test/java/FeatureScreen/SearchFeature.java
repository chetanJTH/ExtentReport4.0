package FeatureScreen;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.Featured;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;
import java.util.List;

public class SearchFeature extends BaseProduct {
    public SearchFeature(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void FeatureScreenTest () throws InterruptedException {
        test = extent.createTest("Search Feature Test");
        test.assignCategory("Usability");
        WebDriverWait wait = new WebDriverWait(driver, 25);


        AllButtons A = new AllButtons(driver);
        Featured F = new Featured(driver);

        A.FEATURED.click();
        Log.addLog("FEATURED Button Is Clickable");
        test.log(Status.INFO, "FEATURED Button Is Clicked");

        SearchBarClick();

        wait.until(ExpectedConditions.elementToBeClickable(F.PopularTag));

        String screenShotPath = MobileActions.Screenshot("Search");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.findElementByXPath("//android.widget.TextView[@text='Gift Voucher']").click();
        Log.addLog("Tag Silected");
        test.log(Status.INFO, "Tag Silected");

        Thread.sleep(1000);
        String screenShotPath1 = MobileActions.Screenshot("Search");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        selectTemplate(10);


        wait.until(ExpectedConditions.elementToBeClickable(A.Editbutton));







    }

    public void SearchBarClick(){
        Featured F = new Featured(driver);

        if (F.FeatureSearch != null) {
            if ((F.FeatureSearch).isDisplayed()) {
                Log.addLog("SearchBar Is Visible");
                F.FeatureSearch.click();
                Log.addLog("SearchBar Is Clickable");
                test.log(Status.INFO, "SearchBar Clicked");
            } else {
                Log.addLog("SearchBar Is Not Visible");
            }
        }
    }

    int currentIndex = 0;

    private void selectTemplate(int _index) {

        int index = _index;
        String id = "com.nra.productmarketingmaker:id/listAllImgByCat";
        List<MobileElement> listItems = driver.findElementsById(id);

        AndroidElement firstElement = (AndroidElement) listItems.get(0);
        AndroidElement lastElement = (AndroidElement) listItems.get(listItems.size() - 1);


        Point fromPoint = lastElement.getCenter();
        Point endPoint = firstElement.getCenter();
        while (index > listItems.size()) {
            Log.addLog("swipe");

            actions.swipeOnScreen(fromPoint, endPoint);
            index -= listItems.size();
        }
        AndroidElement selectedItem = (AndroidElement) listItems.get(index);
        selectedItem.click();

        Log.addLog("total: " + listItems.size());
    }

}
