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


    public AndroidDriver setCapabilitiesRandActinity() throws MalformedURLException {


       DesiredCapabilities dcap = new DesiredCapabilities();

        dcap.setCapability(MobileCapabilityType.DEVICE_NAME, "TestDevice");
        dcap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        dcap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //platformName
        dcap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0"); //platformVersion
        dcap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


        dcap.setCapability("appPackage", "ua.fora.android.mtest");
        //dcap.setCapability("appActivity", "ua.fora.android.ui.activity.WelcomeActivity");
        dcap.setCapability("appActivity", "ua.fora.android.ui.activity.SplashActivity");
        //dcap.setCapability("appActivity", "ua.fora.android.ui.activity.NexusLauncherActivity");
        dcap.setCapability("unicodeKeyboard", "true");
        dcap.setCapability("skipUnlock", "true");



        driver = new AndroidDriver(new URL("http://127.0.0.1:472/wd/hub"), dcap);
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