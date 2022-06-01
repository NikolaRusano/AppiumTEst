import PageObjects.MainPageMenu;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.http.HttpMethod;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static testConstants.LoginConstants.mPhone;
import static testConstants.LoginConstants.otp;

public class AuthorizationTests extends BaseTestClass {


    private static final Logger logger = LoggerFactory.getLogger(AuthorizationTests.class);

    @Test(description = "Test Authorization", priority = 1)
    public void Authtest1() {

        MainPageMenu mPgM = new MainPageMenu(driver);
        //AppiumDriver ad = new AppiumDriver((Capabilities) driver);

        logger.info("Проверка первого слайда кнопки и текста сообщений окна");
        Assert.assertTrue(mPgM.isElementPresent(mPgM.skipAuthPageOwnCount),"Проверка наличия кнопки пропустить");
        Assert.assertEquals(mPgM.authTopText.getText(),"Картка Фора club");
        Assert.assertEquals(mPgM.authContentText.getText(),"Електронна картка завжди під рукою. Прощавайте, зайвий пластик та папір!");

        mPgM.testHorizontalSwipe();logger.info("Проверка первого слайда кнопки и текста сообщений окна");

        Assert.assertTrue(mPgM.isElementPresent(mPgM.skipAuthPageOwnCount),"Проверка наличия кнопки пропустить");
        Assert.assertEquals(mPgM.authTopText.getText(),"Бонуси та персональні пропозиції");
        Assert.assertEquals(mPgM.authContentText.getText(),"Усі бали, бонуси та персональні пропозиції відтепер у додатку.");

        mPgM.testHorizontalSwipe();

        Assert.assertTrue(mPgM.isElementPresent(mPgM.skipAuthPageOwnCount),"Проверка наличия кнопки пропустить");
        Assert.assertEquals(mPgM.authTopText.getText(),"Акції");
        Assert.assertEquals(mPgM.authContentText.getText(),"Тут щотижня оновлюються акції Фора. Плануйте покупки та заощаджуйте.");

        mPgM.testHorizontalSwipe();

        Assert.assertFalse(mPgM.isElementPresent(mPgM.skipAuthPageOwnCount),"Проверка наличия кнопки пропустить");
        Assert.assertEquals(mPgM.authTopText.getText(),"Оплата платіжною карткою");
        Assert.assertEquals(mPgM.authContentText.getText(),"Сплачуй за покупки та отримуй додаткову винагороду");
        Assert.assertTrue(mPgM.isElementPresent(mPgM.authFirstScreensNextBtn),"Проверка наличия кнопки Далее");



    }




    @Test(description = "Test Authorization", priority = 1)
    public void AuthtestFirstDisplay() {

        MainPageMenu mPgM = new MainPageMenu(driver);


        ;




       // mPgM.authBeforeTestWithTestNumbAndOtp();

        //Assert.assertTrue(mPgM.isElementPresent(mPgM.bottomBarMainBtn));

    }

    @Test(description = "Тестирование количества введеных символов", priority = 2)
    public void Authtest2() {
        MainPageMenu mPgM = new MainPageMenu(driver);

        logger.info("Клик чекбокса - мені є 18 років");
        mPgM.tapAndroidElement(mPgM.checkboc18Years);

        logger.info("Проверка при чекнутом чекбоксе - 18 років кнопка отправить код не активна");
        Assert.assertFalse(mPgM.getCodeBtn.isEnabled());

        logger.info("Клик анчек чекбокса - мені є 18 років");
        mPgM.tapAndroidElement(mPgM.checkboc18Years);

        logger.info("Ввод телефона проверки");
        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, "989610140");

        logger.info("Проверка при анчекнутом чекбоксе - 18 років и введенном номере телефона кнопка отправить код не активна");
        Assert.assertFalse(mPgM.getCodeBtn.isEnabled());

        logger.info("Оистка поля  ввода телефона");
        mPgM.cleanField("989610140".length());

        logger.info("Клик чекбокса - мені є 18 років");
        mPgM.tapAndroidElement(mPgM.checkboc18Years);

        logger.info("Ввод телефона проверки без 1 цифры и проверка активации кнопки");
        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, mPhone.substring(0, mPhone.length() - 1));

        Assert.assertFalse(mPgM.getCodeBtn.isEnabled());

        logger.info("Очистка поля  ввода телефона");
        mPgM.cleanField("989610140".length());

        logger.info("Ввод телефона проверки");
        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, mPhone);

        logger.info("Клик получить отп код");
        mPgM.tapAndroidElement(mPgM.getCodeBtn);

        logger.info("Ввод отп кода тест - менше на 1 символ и проверка активации кнопки");
        mPgM.sendKeysAndroidElementOtpCode("000");

        Assert.assertFalse(mPgM.nextBtnOtpCodePg.isEnabled());

        logger.info("Ввод отп кода тест - еше 1 символ и проверка активации кнопки");
        mPgM.sendKeysAndroidElementOtpCode("0");

        Assert.assertTrue(mPgM.nextBtnOtpCodePg.isEnabled());

        logger.info("Ввод отп кода тест");
        mPgM.sendKeysAndroidElementOtpCode(otp);

        logger.info("Клик кнопки далее");
        mPgM.tapAndroidElement(mPgM.nextBtnOtpCodePg);

        pause(4000);

        logger.info("Клик кнопки завершить авторизацию");
        mPgM.tapAndroidElement(mPgM.finishAuthOKBtn);

        pause(15000);

        logger.info("Клик кнопки Далее - вход в главное старт меню приложения");
        mPgM.tapAndroidElement(mPgM.nextBtnAfterAuth);

        Assert.assertTrue(mPgM.isElementPresent(mPgM.bottomBarMainBtn));

    }

    @Test(description = "Тестирование неверного кода отп и количества попыток", priority = 1)
    public void Authtest3() {
        MainPageMenu mPgM = new MainPageMenu(driver);
        String testNumber = "989615140";

        logger.info("Клик чекбокса - мені є 18 років");
        mPgM.tapAndroidElement(mPgM.checkboc18Years);

        logger.info("Ввод телефона проверки");
        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, testNumber);

        logger.info("Клик получить отп код");
        mPgM.tapAndroidElement(mPgM.getCodeBtn);

        logger.info("Ввод отп кода тест - 1 попытка");
        mPgM.sendKeysAndroidElementOtpCode("1123");

        logger.info("Клик кнопки далее");
        mPgM.tapAndroidElement(mPgM.nextBtnOtpCodePg);

        logger.info("Проверка сообщения об ошибке");
        Assert.assertEquals(mPgM.authIncorrectCodeBig.getText()
                ,"Неправильний код");
        Assert.assertEquals(mPgM.authIncorrectCodeFullMsg.getText()
                ,"Невірний код підтвердження, у вас залишилось 3 спроб");

        pause(4000);

        logger.info("Ввод отп кода тест - 2 попытка");
        mPgM.sendKeysAndroidElementOtpCode("1223");

        logger.info("Клик кнопки далее");
        mPgM.tapAndroidElement(mPgM.nextBtnOtpCodePg);

        logger.info("Проверка сообщения об ошибке");
        Assert.assertEquals(mPgM.authIncorrectCodeBig.getText()
                ,"Неправильний код");
        Assert.assertEquals(mPgM.authIncorrectCodeFullMsg.getText()
                ,"Невірний код підтвердження, у вас залишилось 2 спроб");

        pause(4000);

        logger.info("Ввод отп кода тест - 3 попытка");
        mPgM.sendKeysAndroidElementOtpCode("1233");

        logger.info("Клик кнопки далее");
        mPgM.tapAndroidElement(mPgM.nextBtnOtpCodePg);

        logger.info("Проверка сообщения об ошибке");
        Assert.assertEquals(mPgM.authIncorrectCodeBig.getText()
                ,"Неправильний код");
        Assert.assertEquals(mPgM.authIncorrectCodeFullMsg.getText()
                ,"Невірний код підтвердження, у вас залишилось 1 спроба");

        pause(4000);

        logger.info("Ввод отп кода тест - еше 1 символ и проверка активации кнопки");
        mPgM.sendKeysAndroidElementOtpCode("1244");

        logger.info("Клик кнопки далее");
        mPgM.tapAndroidElement(mPgM.nextBtnOtpCodePg);
        

        pause(2000);

        Assert.assertEquals(mPgM.authIncorrectMsgAfter3Input.getText()
                ,"Ви тричі невірно ввели код підтвердження. Спробуйте через 30 хвилин");

        logger.info("Ввод телефона проверки");
        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, testNumber);

        logger.info("Клик получить отп код");
        mPgM.tapAndroidElement(mPgM.getCodeBtn);

        Assert.assertEquals(mPgM.authIncorrectMsgAfter3Input.getText()
                ,"Ви вичерпали можливість відправки коду підтвердження. Спробуйте через 30 хвилин");


    }

    @Test(description = "Test StartMenu", priority = 2)
    public void StartMenu() {

        MainPageMenu mPgM = new MainPageMenu(driver);

        pause(3000);

        mPgM.authBeforeTestWithTestNumbAndOtp();

        logger.info("Проверка элементов нижней ленты навигации");
        /*Assert.assertEquals(mPgM.bottomBarMainBtn.getText(),"Головна");
        Assert.assertEquals(mPgM.bottomBarDeliveryBtn.getText(),"Доставка");
        Assert.assertEquals(mPgM.bottomBarForaClubBtn.getText(),"Фора club");
        Assert.assertEquals(mPgM.bottomBarHistoryBtn.getText(),"Історія");
        Assert.assertEquals(mPgM.bottomBarMenuBtn.getText(),"Меню");*/

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
