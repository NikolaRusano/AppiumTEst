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

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Доставка\"]/android.widget.ImageView")
    public AndroidElement bottomBarNavigationLineDelivery;


    @AndroidFindBy(id = "ua.fora.android.mtest:id/tv_payment_question")
    public AndroidElement deliveryTypePar;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup")
    public AndroidElement pickupTypePar;

    @AndroidFindBy(xpath = "ua.fora.android.mtest:id/button_confirm")
    public AndroidElement confirmBtn;



}
