package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Featured {
    public Featured(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/searchIP")
    public WebElement FeatureSearch;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/labelPopularTags")
    public WebElement PopularTag;

}
