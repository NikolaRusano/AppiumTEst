import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import static java.lang.Thread.sleep;

public class BaseTestClass {
    //public static int typeAct = 0;



    public AndroidDriver driver;



    /*public AndroidDriver setCapabilities() throws MalformedURLException {


       DesiredCapabilities dcap = new DesiredCapabilities();

        dcap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4_API_30");
        dcap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        dcap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //platformName
        dcap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0"); //platformVersion
        dcap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        *//*dcap.setCapability("enableVNC", "true");
        dcap.setCapability("enableVideo", "false");*//*

        dcap.setCapability("appPackage", "ua.fora.android.mtest");
        dcap.setCapability("appActivity", "ua.fora.android.ui.activity.WelcomeActivity");
        //dcap.setCapability("appActivity", "ua.fora.android.ui.activity.MainActivity");
        dcap.setCapability("unicodeKeyboard", "true");
        dcap.setCapability("skipUnlock", "false");
        *//*dcap.setCapability("resetKeyboard", "true");
        dcap.setCapability("ensureWebviewsHavePages", "true");
        dcap.setCapability("newCommandTimeout", "120");
        dcap.setCapability("nativeWebScreenshot", "true");
        dcap.setCapability("browserstack.gpsLocation", "50.45466,-30.5238");
        dcap.setCapability("gpsEnabled", "true");
        dcap.setCapability("locale", "UA");*//*


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dcap);
        return driver;


    }*/

    public AndroidDriver setCapabilitiesRandActinity() throws MalformedURLException {


       DesiredCapabilities dcap = new DesiredCapabilities();

        dcap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4_API_30");
        dcap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        dcap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //platformName
        dcap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0"); //platformVersion
        dcap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


        dcap.setCapability("appPackage", "ua.fora.android.mtest");
        //dcap.setCapability("appActivity", "ua.fora.android.ui.activity.WelcomeActivity");
        dcap.setCapability("appActivity", "ua.fora.android.ui.activity.SplashActivity");
        dcap.setCapability("unicodeKeyboard", "true");
        dcap.setCapability("skipUnlock", "false");



        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dcap);
        return driver;


    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        /*if (typeAct == 0){*/
            setCapabilitiesRandActinity();
        /*}else if (typeAct == 1){
            setCapabilitiesRandActinity("ua.silpo.android.ui.activity.StartSliderActivity");
        }*/
    }


    public static void pause(int ms) {
        try {
            sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}