import PageObjects.AuthorizationPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class BaseTestClass {
    public AndroidDriver driver;


    public AndroidDriver setCapabilities() throws MalformedURLException {


       DesiredCapabilities dcap = new DesiredCapabilities();

        dcap.setCapability(MobileCapabilityType.DEVICE_NAME, "TestDevice");
        dcap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        dcap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //platformName
        dcap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0"); //platformVersion

        pause(2000);

        dcap.setCapability("appPackage", "ua.silpo.android.mtest"); //platformName
        dcap.setCapability("appActivity", "ua.silpo2.android.ui.activity.MainActivity"); //platformName

        driver = new AndroidDriver(new URL("http://127.0.0.1:472/wd/hub"), dcap);

        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        setCapabilities();
    }

    public static void pause(int ms) {
        try {
            sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}