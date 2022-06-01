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


    @Test(description = "Test Authorization", priority = 2)
    public void Authtest2InputIncorrectPhone() {

        MainPageMenu mPgM = new MainPageMenu(driver);

        logger.info("Клик кнопки пропустить");
        mPgM.tapAndroidElement(mPgM.skipAuthPageOwnCount);

        logger.info("Клик чекбокса - мені є 18 років");
        mPgM.tapAndroidElement(mPgM.checkboc18Years);

        logger.info("Ввод телефона проверки");
        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, "050122135");

        Assert.assertEquals(mPgM.authPhoneInputFieldError.getText(),
                "Некоректний код мобільного оператора");

        logger.info("Ввод телефона проверки");
        mPgM.cleanField("050122135".length());
        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, "989610149");
        mPgM.tapAndroidElement(mPgM.finishAuthOKBtn);

        logger.info("Проверка пуш сообщения");
        mPgM.tapAndroidElement(mPgM.authSendCodeAgainLinkBtn);
        pause(1000);
        Assert.assertEquals(mPgM.authPushMsgError.getText(),
                "Код підтвердження надіслано");

        mPgM.tapAndroidElement(mPgM.authSendCodeAgainLinkBtn);
        pause(1000);
        Assert.assertEquals(mPgM.authPushMsgError.getText(),
                "Код підтвердження надіслано");

        mPgM.tapAndroidElement(mPgM.authSendCodeAgainLinkBtn);
        pause(1000);

        logger.info("Проверка что после 3 нажатий на нопку не оримали код - переходит на ввод телефона и получается пуш сообщение");
        Assert.assertTrue(mPgM.isElementPresent((mPgM.mPhomeInputField)));
        Assert.assertEquals(mPgM.authPushMsgError.getText(),
                "Ви вичерпали можливість відправки коду підтвердження. Спробуйте через 30 хвилин");
    }

    @Test(description = "Тестирование количества введеных символов", priority = 3)
    public void Authtest3ButtonActivityNumbChars() {
        MainPageMenu mPgM = new MainPageMenu(driver);

        logger.info("Клик кнопки пропустить");
        mPgM.tapAndroidElement(mPgM.skipAuthPageOwnCount);

        logger.info("Клик чекбокса - мені є 18 років");
        mPgM.tapAndroidElement(mPgM.checkboc18Years);

        logger.info("Проверка при чекнутом чекбоксе - 18 років кнопка отправить код не активна");
        Assert.assertFalse(mPgM.finishAuthOKBtn.isEnabled());

        logger.info("Клик анчек чекбокса - мені є 18 років");
        mPgM.tapAndroidElement(mPgM.checkboc18Years);

        logger.info("Ввод телефона проверки");
        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, "989610140");

        logger.info("Проверка при анчекнутом чекбоксе - 18 років и введенном номере телефона кнопка отправить код не активна");
        Assert.assertFalse(mPgM.finishAuthOKBtn.isEnabled());

        logger.info("Оистка поля  ввода телефона");
        mPgM.cleanField("989610140".length());

        logger.info("Клик чекбокса - мені є 18 років");
        mPgM.tapAndroidElement(mPgM.checkboc18Years);

        logger.info("Ввод телефона проверки без 1 цифры и проверка активации кнопки");
        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, mPhone.substring(0, mPhone.length() - 1));

        Assert.assertFalse(mPgM.finishAuthOKBtn.isEnabled());

        logger.info("Очистка поля  ввода телефона");
        mPgM.cleanField("989610140".length());

        logger.info("Ввод телефона проверки");
        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, mPhone);

        logger.info("Клик получить отп код");
        mPgM.tapAndroidElement(mPgM.finishAuthOKBtn);

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

    @Test(description = "Тестирование неверного кода отп и количества попыток", priority = 4)
    public void AuthtestOTPCodeErrorsInput() {
        MainPageMenu mPgM = new MainPageMenu(driver);
        String testNumber = "989615140";

        logger.info("Клик кнопки пропустить");
        mPgM.tapAndroidElement(mPgM.skipAuthPageOwnCount);

        logger.info("Клик чекбокса - мені є 18 років");
        mPgM.tapAndroidElement(mPgM.checkboc18Years);

        logger.info("Ввод телефона проверки");
        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, testNumber);

        logger.info("Клик получить отп код");
        mPgM.tapAndroidElement(mPgM.finishAuthOKBtn);

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
        mPgM.tapAndroidElement(mPgM.finishAuthOKBtn);

        Assert.assertEquals(mPgM.authIncorrectMsgAfter3Input.getText()
                ,"Ви вичерпали можливість відправки коду підтвердження. Спробуйте через 30 хвилин");


    }




}
