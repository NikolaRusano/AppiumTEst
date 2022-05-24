package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeliveryPage extends MainPageMenu{

    private static final Logger logger = LoggerFactory.getLogger(DeliveryPage.class);

    public DeliveryPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "ua.fora.android.mtest:id/bottom_navigation")
    public AndroidElement bottomBarNavigationLine;

}
