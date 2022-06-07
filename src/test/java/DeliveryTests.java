import PageObjects.DeliveryPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DeliveryTests extends BaseTestClass {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationTests.class);

    @Test(description = "Test delivery", priority = 1)
    public void deliveryTestDescrTestField() {

        DeliveryPage dP = new DeliveryPage(driver);

        pause(3000);

        logger.info("Авторизация пользователя");
        dP.authBeforeTestWithTestNumbAndOtp();


        logger.info("Переход на вкладку Доставки");
        dP.bottomBarNavigationLineDelivery.click();

        logger.info("Проверка Дискрипшенов полей - вид доставки");
        Assert.assertEquals(dP.deliveryTypePar.getText().replace("\n", ""),
                "Як Ви бажаєте отримати товари?".replace("\n", ""));

        logger.info("Проверка Дискрипшенов полей - доставка");
        List<AndroidElement> listDeliveryTypes = driver.findElements(By.id("ua.fora.android.mtest:id/tv_title"));
        Assert.assertEquals(listDeliveryTypes.get(0).getText(), "Доставка");
        logger.info("Проверка Дискрипшенов полей - Самовивіз");
        Assert.assertEquals(listDeliveryTypes.get(1).getText(), "Самовивіз");

    }

    @Test(description = "Test delivery not active Button", priority = 2)
    public void deliveryTestButtonActivityNotActive() {

        DeliveryPage dP = new DeliveryPage(driver);

        pause(2000);

        logger.info("Авторизация пользователя");
        dP.authBeforeTestWithTestNumbAndOtp();


        logger.info("Переход на вкладку Доставки");
        dP.bottomBarNavigationLineDelivery.click();

        List<AndroidElement> listDeliveryTypes = driver.findElements(By.id("ua.fora.android.mtest:id/tv_title"));
        logger.info("Проверка что пока вид доставки не выбран - кнопка неактивна");

        Assert.assertFalse(dP.confirmBtn.isEnabled());
        logger.info(String.valueOf(dP.confirmBtn.isEnabled()));
        //MobileElement el2 = (MobileElement) driver.findElementById("ua.fora.android.mtest:id/button_confirm");
        //System.out.println(el2.isEnabled());

    }

    @Test(description = "Test delivery active Delivery", priority = 3)
    public void deliveryTestButtonActivityActiveDelivery() {
        DeliveryPage dP = new DeliveryPage(driver);

        pause(2000);

        logger.info("Авторизация пользователя");
        dP.authBeforeTestWithTestNumbAndOtp();

        logger.info("Переход на вкладку Доставки");
        dP.bottomBarNavigationLineDelivery.click();

        List<AndroidElement> listDeliveryTypes = driver.findElements(By.id("ua.fora.android.mtest:id/tv_title"));

        logger.info("Проверка что после выбора - кнопка активна");
        listDeliveryTypes.get(0).click();
        Assert.assertTrue(dP.confirmBtn.isEnabled());
        logger.info(String.valueOf(dP.confirmBtn.isEnabled()));
    }

    @Test(description = "Test delivery active Self Get", priority = 4)
    public void deliveryTestButtonActivityActiveSelfGet() {
        DeliveryPage dP = new DeliveryPage(driver);

        pause(3000);

        logger.info("Авторизация пользователя");
        dP.authBeforeTestWithTestNumbAndOtp();

        logger.info("Переход на вкладку Доставки");
        dP.bottomBarNavigationLineDelivery.click();
        List<AndroidElement> listDeliveryTypes = driver.findElements(By.id("ua.fora.android.mtest:id/tv_title"));

        logger.info("Проверка что доставки выбран - кнопка активна");
        listDeliveryTypes.get(1).click();
        MobileElement confirmBtn = (MobileElement)driver.findElement(By.id("ua.fora.android.mtest:id/button_confirm"));
        Assert.assertTrue(confirmBtn.isEnabled());
        logger.info(String.valueOf(confirmBtn.isEnabled()));

    }

    @Test(description = "Test Input delivery addres Self Get", priority = 5)
    public void deliveryAddressInputTest() {
        DeliveryPage dP = new DeliveryPage(driver);

        pause(2000);

        logger.info("Авторизация пользователя");
        dP.authBeforeTestWithTestNumbAndOtp();

        logger.info("Переход на вкладку Доставки");
        dP.bottomBarNavigationLineDelivery.click();
        List<AndroidElement> listDeliveryTypes = driver.findElements(By.id("ua.fora.android.mtest:id/tv_title"));

        logger.info("Выбор Доставки и переход на страницу адреса доставки");
        listDeliveryTypes.get(0).click();
        pause(4000);
        dP.confirmBtn.click();

        pause(3000);

        logger.info("Выбор Доставки и ");
        dP.sendKeysAndroidElement(dP.deliveryCityField, "м. Київ");
        dP.sendKeysAndroidElement(dP.deliveryAddressField, "просп. Тичини Павла, 1В");
        dP.confirmBtn.click();





    }

}
