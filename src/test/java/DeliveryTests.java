import PageObjects.MainPageMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeliveryTests extends BaseTestClass{

        private static final Logger logger = LoggerFactory.getLogger(AuthorizationTests.class);

        @Test(description = "Test delivery", priority = 1)
        public void Delivery() {

            //AuthorizationPage pg = new AuthorizationPage(driver);
            MainPageMenu mPgM = new MainPageMenu(driver);

            pause(3000);

            mPgM.authBeforeTestWithTestNumbAndOtp();

            Assert.assertTrue(mPgM.isElementPresent(mPgM.bottomBarMainBtn));


        }

}
