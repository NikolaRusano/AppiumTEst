import PageObjects.MainPageMenu;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;


public class MainPageTests extends BaseTestClass {
    private static final Logger logger = LoggerFactory.getLogger(AuthorizationTests.class);

    @Test(description = "Test StartMenu", priority = 2)
    public void StartMenu() {

        MainPageMenu mPgM = new MainPageMenu(driver);

        pause(3000);

        mPgM.authBeforeTestWithTestNumbAndOtp();

        logger.info("Проверка элементов нижней ленты навигации");


        List<String> listItemsToCheck = Arrays.asList("Головна", "Доставка", "Історія", "Меню");
        List<MobileElement> listelements = mPgM.bottomBarNavigationLine.findElements(By.id("ua.fora.android.mtest:id/smallLabel"));
        MobileElement mainElemBottom = (MobileElement) driver.findElement(By.id("ua.fora.android.mtest:id/largeLabel"));
        listelements.add(0, mainElemBottom);

        for (int i=0 ; i<listelements.size(); i++) {
            Assert.assertEquals(listelements.get(i).getText(),listItemsToCheck.get(i));
        }



        //Assert.assertTrue(pg.isElementPresent(mPgM.bottomBarMainBtn));

    }

}
