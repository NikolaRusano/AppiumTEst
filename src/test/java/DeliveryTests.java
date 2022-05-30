import PageObjects.DeliveryPage;
import PageObjects.MainPageMenu;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeliveryTests extends BaseTestClass{

        private static final Logger logger = LoggerFactory.getLogger(AuthorizationTests.class);

        @Test(description = "Test delivery", priority = 1)
        public void deliveryTest() {

            DeliveryPage dP = new DeliveryPage(driver);

            pause(3000);

            logger.info("Авторизация");
            dP.authBeforeTestWithTestNumbAndOtp();


            dP.bottomBarNavigationLineDelivery.click();
            dP.confirmBtn.click();

            
        }

}
