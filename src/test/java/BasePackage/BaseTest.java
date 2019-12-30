package BasePackage;


import FeatureScreenCase.FeatureUICase;
import FeatureScreenCase.SearchFeatureCase;
import FontModuleCase.*;
import ImageStickerCase.*;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Apps;
import utils.Devices;
import utils.Utils;
import java.io.File;
import java.io.IOException;


public class BaseTest {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    protected TestManager loginAndroid;
    //   Font Module
    protected AddTextCase addTextCase;
    protected EditTextCase editTextCase;
    protected TextPositionButtonsCase textPositionButtonsCase;
    protected TextRotationCase textRotationCase;
    protected TextSizeCase textSizeCase;
    protected FontColorCase fontColorCase;
    protected FontColorCodeCase fontColorCodeCase;
    protected FontLibraryCase fontlibrary;
    protected FontGetMoreButtonCase fontGetMoreButtonCase;
    protected ShadowCase shadowCase;
    protected FontStyleCase fontStyleCase;
    protected FontOpacityCase fontOpacityCase;
    protected LatterSpaceCase latterSpaceCase;
    protected UndoRedoCase undoRedoCase;
    protected UndoRotationCase undoRotationCase;
    protected UndoSizeCase undoSizeCase;
    protected UndoColorCase undoColorCase;
    protected UndoFontCase undoFontCase;
    protected UndoShadowCase undoShadowCase;
    protected UndoStyleCase undoStyleCase;
    protected UndoOpacityCase undoOpacityCase;
    protected UndoLatterSpaceCase undoLatterSpaceCase;
    protected PositionLockCase positionLockCase;
    protected RotationLockCase rotationLockCase;
    protected SizeLockCase sizeLockCase;
    protected FrameLayerCase frameLayerCase;
    protected FontParagraphCase fontParagraphCase;
    protected ParagraphEditCase paragraphEditCase;
    protected ParagraphVerticalSpaceCase paragraphVerticalSpaceCase;
    protected ParagraphStyleCase paragraphStyleCase;
    protected FontAutoSaveCase fontAutoSaveCase;
    protected FontSaveCase fontSaveCase;

    // Image Module
    protected AddImageCase addImageCase;
    protected EditImageCase editImageCase;
    protected EraseImageCase eraseImageCase;
    protected EraseMinimizeCase eraseMinimizeCase;
    protected EraseAutoFunctionCase eraseAutoFunctionCase;
    protected ImagePositionCase imagePositionCase;
    protected ImageRotationCase imageRotationCase;
    protected CropAspectCase cropAspectCase;
    protected AspectScaleCase aspectScaleCase;
    protected AspectRatioCase aspectRatioCase;
    protected AspectRotateCase aspectRotateCase;
    protected ImgCropShapeCase imgCropShapeCase;
    protected CropEditCase cropEditCase;
    protected CropBkGroundCase cropBkGroundCase;
    protected CropAdjustRotateCase cropAdjustRotateCase;
    protected CropAdjustSizeCase cropAdjustSizeCase;
    protected ImageOpacityCase imageOpacityCase;
    protected ImageSizeCase imageSizeCase;
    protected ImgPositionLockCase imgPositionLockCase;
    protected ImageRotationLockCase imageRotationLockCase;
    protected ImageSizeLockCase imageSizeLockCase;
    protected EditImageCase imageEdit;
    protected ImageColorCase imageColorCase;
    protected ImgColorCodeCase imgColorCodeCase;
    protected ImgAutoSaveCase imgAutoSaveCase;
    protected ImgSaveCase imgSaveCase;


    //Feature Screen

    protected FeatureUICase featureUICase;
    protected SearchFeatureCase searchFeatureCase;


    @BeforeSuite
    public void beforeSuite() {

        htmlReporter = new ExtentHtmlReporter(Utils.getReportDir() + "/report.html");
        htmlReporter.loadXMLConfig(String.valueOf(new File("src/test/java/extentreports/extent-config.xml")));
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("OS Name", System.getProperty("os.name"));
        extent.setSystemInfo("OS Version", System.getProperty("os.version"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Automation");
        htmlReporter.config().setReportName("Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);

    }




    @BeforeClass
    void setupDriver() throws InterruptedException {

        //1 times
        Devices device = Devices.SamsungJ7;
        loginAndroid = TestManager.testAndroid(device, Apps.ProductMarketing);


        // Font Module
        addTextCase = new AddTextCase(loginAndroid.getDriverAndroid());
        editTextCase = new EditTextCase(loginAndroid.getDriverAndroid());
        textPositionButtonsCase = new TextPositionButtonsCase(loginAndroid.getDriverAndroid());
        textRotationCase = new TextRotationCase(loginAndroid.getDriverAndroid());
        textSizeCase = new TextSizeCase(loginAndroid.getDriverAndroid());
        fontColorCase = new FontColorCase(loginAndroid.getDriverAndroid());
        fontColorCodeCase = new FontColorCodeCase(loginAndroid.getDriverAndroid());
        fontGetMoreButtonCase = new FontGetMoreButtonCase(loginAndroid.getDriverAndroid());
        fontlibrary = new FontLibraryCase((loginAndroid.getDriverAndroid()));
        shadowCase = new ShadowCase(loginAndroid.getDriverAndroid());
        fontStyleCase = new FontStyleCase(loginAndroid.getDriverAndroid());
        fontOpacityCase = new FontOpacityCase(loginAndroid.getDriverAndroid());
        latterSpaceCase = new LatterSpaceCase(loginAndroid.getDriverAndroid());
        undoRedoCase = new UndoRedoCase(loginAndroid.getDriverAndroid());
        undoRotationCase = new UndoRotationCase(loginAndroid.getDriverAndroid());
        undoSizeCase = new UndoSizeCase(loginAndroid.getDriverAndroid());
        undoColorCase = new UndoColorCase(loginAndroid.getDriverAndroid());
        undoFontCase = new UndoFontCase(loginAndroid.getDriverAndroid());
        undoShadowCase = new UndoShadowCase(loginAndroid.getDriverAndroid());
        undoStyleCase = new UndoStyleCase(loginAndroid.getDriverAndroid());
        undoOpacityCase = new UndoOpacityCase(loginAndroid.getDriverAndroid());
        undoLatterSpaceCase = new UndoLatterSpaceCase(loginAndroid.getDriverAndroid());
        positionLockCase = new PositionLockCase(loginAndroid.getDriverAndroid());
        rotationLockCase = new RotationLockCase(loginAndroid.getDriverAndroid());
        sizeLockCase = new SizeLockCase(loginAndroid.getDriverAndroid());
        frameLayerCase = new FrameLayerCase(loginAndroid.getDriverAndroid());
        fontParagraphCase = new FontParagraphCase(loginAndroid.getDriverAndroid());
        paragraphEditCase = new ParagraphEditCase(loginAndroid.getDriverAndroid());
        paragraphVerticalSpaceCase = new ParagraphVerticalSpaceCase(loginAndroid.getDriverAndroid());
        paragraphStyleCase = new ParagraphStyleCase(loginAndroid.getDriverAndroid());
        fontAutoSaveCase = new FontAutoSaveCase(loginAndroid.getDriverAndroid());
        fontSaveCase = new FontSaveCase(loginAndroid.getDriverAndroid());

        // Image Module

        addImageCase = new AddImageCase(loginAndroid.getDriverAndroid());
        editImageCase = new EditImageCase(loginAndroid.getDriverAndroid());
        eraseImageCase = new EraseImageCase(loginAndroid.getDriverAndroid());
        eraseMinimizeCase = new EraseMinimizeCase(loginAndroid.getDriverAndroid());
        eraseAutoFunctionCase = new EraseAutoFunctionCase(loginAndroid.getDriverAndroid());
        imagePositionCase = new ImagePositionCase(loginAndroid.getDriverAndroid());
        imageRotationCase = new ImageRotationCase(loginAndroid.getDriverAndroid());
        cropAspectCase = new CropAspectCase(loginAndroid.getDriverAndroid());
        aspectScaleCase = new AspectScaleCase(loginAndroid.getDriverAndroid());
        aspectRatioCase = new AspectRatioCase(loginAndroid.getDriverAndroid());
        aspectRotateCase = new AspectRotateCase(loginAndroid.getDriverAndroid());
        imgCropShapeCase = new ImgCropShapeCase(loginAndroid.getDriverAndroid());
        cropEditCase = new CropEditCase(loginAndroid.getDriverAndroid());
        cropBkGroundCase = new CropBkGroundCase(loginAndroid.getDriverAndroid());
        cropAdjustRotateCase = new CropAdjustRotateCase(loginAndroid.getDriverAndroid());
        cropAdjustSizeCase = new CropAdjustSizeCase(loginAndroid.getDriverAndroid());
        imageOpacityCase = new ImageOpacityCase(loginAndroid.getDriverAndroid());
        imageSizeCase = new ImageSizeCase(loginAndroid.getDriverAndroid());
        imgPositionLockCase = new ImgPositionLockCase(loginAndroid.getDriverAndroid());
        imageRotationLockCase = new ImageRotationLockCase(loginAndroid.getDriverAndroid());
        imageSizeLockCase = new ImageSizeLockCase(loginAndroid.getDriverAndroid());
        imageEdit = new EditImageCase(loginAndroid.getDriverAndroid());
        imageColorCase = new ImageColorCase(loginAndroid.getDriverAndroid());
        imgColorCodeCase = new ImgColorCodeCase(loginAndroid.getDriverAndroid());
        eraseMinimizeCase = new EraseMinimizeCase(loginAndroid.getDriverAndroid());
        imgAutoSaveCase = new ImgAutoSaveCase(loginAndroid.getDriverAndroid());
        imgSaveCase = new ImgSaveCase(loginAndroid.getDriverAndroid());


        // Feature Screen

        featureUICase = new FeatureUICase(loginAndroid.getDriverAndroid());
        searchFeatureCase = new SearchFeatureCase(loginAndroid.getDriverAndroid());


        extent.setSystemInfo("Device Test Name", device.getName());
        extent.setSystemInfo("Device Test Version", device.getVersion());


        Thread.sleep(1500);


    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
            String screenShotPath = MobileActions.Screenshot("Failed");

            try {
                test.addScreenCaptureFromPath(screenShotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }


//    @AfterTest
//    void endTest() {
//        loginAndroid.quitTest();
//    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
        loginAndroid.quitTest();
    }


}