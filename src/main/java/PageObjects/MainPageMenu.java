package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPageMenu extends AuthorizationPage {

    private static final Logger logger = LoggerFactory.getLogger(MainPageMenu.class);

    public MainPageMenu(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "ua.fora.android.mtest:id/bottom_navigation")
    public AndroidElement bottomBarNavigationLine;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/action_main")
    public AndroidElement bottomBarMainBtn;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/action_ecomm")
    public AndroidElement bottomBarDeliveryBtn;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/action_vr")
    public AndroidElement bottomBarForaClubBtn;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/action_calendar")
    public AndroidElement bottomBarHistoryBtn;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/action_menu")
    public AndroidElement bottomBarMenuBtn;


    @AndroidFindBy(id = "ua.fora.android.mtest:id/cvPharmacy")
    public AndroidElement menuTilePharmacy;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/cvCurfew")
    public AndroidElement menuTileCurfew;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/cvWater")
    public AndroidElement menuTileWaterMachine;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/cvStores")
    public AndroidElement menuTileOpenedStores;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/cvArmy")
    public AndroidElement menuTileArmyHelp;


    @AndroidFindBy(id = "ua.fora.android.mtest:id/bonus_linear_layout")
    public AndroidElement menuTopBonusAmount;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/points_linear_layout")
    public AndroidElement menuTopPointsAmount;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/linear_layout")
    public AndroidElement menuTopBarcode;



}
