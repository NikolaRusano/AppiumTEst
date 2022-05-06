import PageObjects.AuthorizationPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static testConstants.LoginConstants.mPhone;

public class AuthorizationTests extends BaseTestClass {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationTests.class);

    @Test(description = "Test Authorization", priority = 1)
    public void Authtest1() {
        /*AuthorizationPage authTest = PageFactory.initElements(driver, AuthorizationPage.class);*/
        System.out.println("HellO");

        pause(3000);

        System.out.println("Hey Niger");

        AuthorizationPage pg = new AuthorizationPage();
        pg.tapAndroidElement(pg.skipAuthPageOwnCount);
        System.out.println("Hey Niger");


        /*authTest.tapAndroidElement(authTest.skipAuthPageOwnCount);
        System.out.println("Hey Niger");

        logger.info("Ввод телефона проверки");
        authTest.sendKeysAndroidElement(authTest.mPhomeInputField ,mPhone);*/




        /*//com.android.dialer:id/floating_action_button
        touchAction.tap(TapOptions.tapOptions()
                        .withElement(ElementOption.element(driver.findElement(By
                                .xpath("//android.widget.TextView[@content-desc=\"Phone\"]")))))
                .perform();*/




    }
}
