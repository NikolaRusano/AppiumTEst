import PageObjects.DeliveryPage;
import PageObjects.MainPageMenu;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DeliveryTests extends BaseTestClass{

        private static final Logger logger = LoggerFactory.getLogger(AuthorizationTests.class);

        @Test(description = "Test delivery", priority = 1)
        public void deliveryTest() {

            DeliveryPage dP = new DeliveryPage(driver);

            pause(3000);

            logger.info("Авторизация пользователя");
            dP.authBeforeTestWithTestNumbAndOtp();


            logger.info("Авторизация пользователя");
            dP.bottomBarNavigationLineDelivery.click();

            logger.info("Проверка Дискрипшенов полей");
            Assert.assertEquals(dP.deliveryTypePar.getText().replace("\n",""),"Як Ви бажаєте отримати товари?".replace("\n",""));

            List<AndroidElement> listDeliveryTypes = driver.findElements(By.id("ua.fora.android.mtest:id/tv_title"));
            Assert.assertEquals(listDeliveryTypes.get(0).getText(),"Доставка");
            Assert.assertEquals(listDeliveryTypes.get(1).getText(),"Самовивіз");

            logger.info("Проверка что пока вид доставки не выбран - кнопка неактивна");
            Assert.assertTrue(dP.confirmBtn.isEnabled());
            listDeliveryTypes.get(0).click();


            dP.confirmBtn.click();

            
        }

}
