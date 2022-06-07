import PageObjects.MainPageMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static testConstants.LoginConstants.mPhone;
import static testConstants.LoginConstants.otp;

public class AuthorizationTests extends BaseTestClass {


    private static final Logger logger = LoggerFactory.getLogger(AuthorizationTests.class);

    @Test(description = "Test Authorization buttons", priority = 1)
    public void AuthtestFirstAuthPageTextCheckButtons() {

        MainPageMenu mPgM = new MainPageMenu(driver);

        logger.info("Проверка первого слайда кнопки");
        Assert.assertTrue(mPgM.isElementPresent(mPgM.skipAuthPageOwnCount) &&
                (!mPgM.isElementPresent(mPgM.authFirstScreensNextBtn)), "Проверка наличия кнопки пропустить и нет далее");
    }


    @Test(description = "Test Authorization field 1", priority = 2)
    public void AuthtestFirstAuthPageTextCheckField1() {

        MainPageMenu mPgM = new MainPageMenu(driver);
        logger.info("Проверка первого слайда текста сообщений окна первого поля");
        Assert.assertEquals(mPgM.authTopText.getText(), "Картка Фора club");


    }

    @Test(description = "Test Authorization field 2", priority = 3)
    public void AuthtestFirstAuthPageTextCheckField2() {
        MainPageMenu mPgM = new MainPageMenu(driver);
        logger.info("Проверка первого слайда текста сообщений окна второго поля");
        Assert.assertEquals(mPgM.authContentText.getText(),
                "Електронна картка завжди під рукою. Прощавайте, зайвий пластик та папір!");

    }

    @Test(description = "Test Authorization button", priority = 4)
    public void AuthtestFirstAuthPage2TextCheckButton() {
        MainPageMenu mPgM = new MainPageMenu(driver);

        mPgM.testHorizontalSwipe();
        logger.info("Проверка второго слайда кнопки");

        Assert.assertTrue(mPgM.isElementPresent(mPgM.skipAuthPageOwnCount) &&
                (!mPgM.isElementPresent(mPgM.authFirstScreensNextBtn)), "Проверка наличия кнопки пропустить и нет далее");


    }

    @Test(description = "Test Authorization field 1", priority = 5)
    public void AuthtestFirstAuthPage2TextCheckField1() {
        MainPageMenu mPgM = new MainPageMenu(driver);

        logger.info("Проверка второго слайда текста сообщений окна первого поля");
        mPgM.testHorizontalSwipe();
        Assert.assertEquals(mPgM.authTopText.getText(), "Бонуси та персональні пропозиції");
    }

    @Test(description = "Test Authorization field 2", priority = 6)
    public void AuthtestFirstAuthPage2TextCheckField2() {
        MainPageMenu mPgM = new MainPageMenu(driver);

        logger.info("Проверка второго слайда текста сообщений окна второго поля");
        mPgM.testHorizontalSwipe();
        Assert.assertEquals(mPgM.authContentText.getText(),
                "Усі бали, бонуси та персональні пропозиції відтепер у додатку.");
    }


    @Test(description = "Test Authorization button", priority = 7)
    public void AuthtestFirstAuthPage3TextCheckButton() {
        MainPageMenu mPgM = new MainPageMenu(driver);

        mPgM.testHorizontalSwipe();
        mPgM.testHorizontalSwipe();
        logger.info("Проверка третьего слайда кнопки");

        Assert.assertTrue(mPgM.isElementPresent(mPgM.skipAuthPageOwnCount) &&
                (!mPgM.isElementPresent(mPgM.authFirstScreensNextBtn)), "Проверка наличия кнопки пропустить и нет далее");
    }

    @Test(description = "Test Authorization field 1", priority = 8)
    public void AuthtestFirstAuthPage3TextCheckField1() {
        MainPageMenu mPgM = new MainPageMenu(driver);

        mPgM.testHorizontalSwipe();
        mPgM.testHorizontalSwipe();
        logger.info("Проверка третьего слайда текста сообщений окна первого поля");
        Assert.assertEquals(mPgM.authTopText.getText(), "Акції");
    }

    @Test(description = "Test Authorization field 2", priority = 9)
    public void AuthtestFirstAuthPage3TextCheckField2() {
        MainPageMenu mPgM = new MainPageMenu(driver);

        logger.info("Проверка третьего слайда текста сообщений окна второго поля");
        mPgM.testHorizontalSwipe();
        mPgM.testHorizontalSwipe();

        Assert.assertEquals(mPgM.authContentText.getText(), "Тут щотижня оновлюються акції Фора. Плануйте покупки та заощаджуйте.");

    }


    @Test(description = "Test Authorization button", priority = 10)
    public void AuthtestFirstAuthPage4TextCheckButton() {
        MainPageMenu mPgM = new MainPageMenu(driver);

        mPgM.testHorizontalSwipe();
        mPgM.testHorizontalSwipe();
        mPgM.testHorizontalSwipe();

        logger.info("Проверка наличия кнопки Далее");
        Assert.assertTrue(mPgM.isElementPresent(mPgM.authFirstScreensNextBtn) &&
                (!mPgM.isElementPresent(mPgM.skipAuthPageOwnCount)), "Проверка наличия кнопки пропустить и нет далее");

    }

    @Test(description = "Test Authorization field 1", priority = 11)
    public void AuthtestFirstAuthPage4TextCheckField1() {
        MainPageMenu mPgM = new MainPageMenu(driver);

        mPgM.testHorizontalSwipe();
        mPgM.testHorizontalSwipe();
        mPgM.testHorizontalSwipe();

        Assert.assertEquals(mPgM.authTopText.getText(), "Оплата платіжною карткою");

    }

    @Test(description = "Test Authorization field 2", priority = 12)
    public void AuthtestFirstAuthPage4TextCheckField2() {
        MainPageMenu mPgM = new MainPageMenu(driver);

        mPgM.testHorizontalSwipe();
        mPgM.testHorizontalSwipe();
        mPgM.testHorizontalSwipe();
        logger.info("Проверка четвертого слайда текста сообщений окна второго поля");
        Assert.assertEquals(mPgM.authContentText.getText(), "Сплачуй за покупки та отримуй додаткову винагороду");

    }


    @Test(description = "Test Authorization incorrect mobile operator code", priority = 13)
    public void AuthtestInputIncorrectPhoneOperatorCode() {

        MainPageMenu mPgM = new MainPageMenu(driver);

        logger.info("Клик кнопки пропустить");
        mPgM.tapAndroidElement(mPgM.skipAuthPageOwnCount);

        logger.info("Клик чекбокса - мені є 18 років");
        mPgM.tapAndroidElement(mPgM.checkboc18Years);

        logger.info("Ввод телефона проверки неверного оператора");
        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, "050122135");

        Assert.assertEquals(mPgM.authPhoneInputFieldError.getText(),
                "Некоректний код мобільного оператора");


    }

    @Test(description = "Test Authorization", priority = 14)
    public void Authtest2InputIncorrectPhone() {

        MainPageMenu mPgM = new MainPageMenu(driver);

        logger.info("Клик кнопки пропустить");
        mPgM.tapAndroidElement(mPgM.skipAuthPageOwnCount);

        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, "989610149");
        mPgM.tapAndroidElement(mPgM.finishAuthOKBtn);

        logger.info("Проверка пуш сообщения 1 раз повтор приски отп");
        mPgM.tapAndroidElement(mPgM.authSendCodeAgainLinkBtn);
        pause(1000);
        Assert.assertEquals(mPgM.authPushMsgError.getText(),
                "Код підтвердження надіслано");

        logger.info("Проверка пуш сообщения 2 раз повтор приски отп");
        mPgM.tapAndroidElement(mPgM.authSendCodeAgainLinkBtn);
        pause(1000);
        Assert.assertEquals(mPgM.authPushMsgError.getText(),
                "Код підтвердження надіслано");
        logger.info("Проверка пуш сообщения 3 раз повтор приски отп");
        mPgM.tapAndroidElement(mPgM.authSendCodeAgainLinkBtn);
        pause(1000);

        logger.info("Проверка что после 3 нажатий на нопку не оримали код - переходит на ввод телефона и получается пуш сообщение");
        Assert.assertTrue(mPgM.isElementPresent((mPgM.mPhomeInputField)));

        Assert.assertEquals(mPgM.authPushMsgError.getText(),
                "Ви вичерпали можливість відправки коду підтвердження. Спробуйте через 30 хвилин");
    }

    @Test(description = "Тестирование количества активации кнопки", priority = 15)
    public void AuthtestButtonActivityCheckBox() {
        MainPageMenu mPgM = new MainPageMenu(driver);

        logger.info("Клик кнопки пропустить");
        mPgM.tapAndroidElement(mPgM.skipAuthPageOwnCount);

        logger.info("Клик чекбокса - мені є 18 років");
        mPgM.tapAndroidElement(mPgM.checkboc18Years);

        logger.info("Проверка при чекнутом чекбоксе - 18 років кнопка отправить код не активна");
        Assert.assertFalse(mPgM.finishAuthOKBtn.isEnabled());
    }

    @Test(description = "Тестирование количества активации кнопки при вводе телефона без чекбокса", priority = 16)
    public void AuthTestButtonActivityWithoutChckbx() {
        MainPageMenu mPgM = new MainPageMenu(driver);

        logger.info("Клик кнопки пропустить");
        mPgM.tapAndroidElement(mPgM.skipAuthPageOwnCount);

        logger.info("Ввод телефона проверки");
        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, "989610140");

        logger.info("Проверка при анчекнутом чекбоксе - 18 років и введенном номере телефона кнопка отправить код не активна");
        Assert.assertFalse(mPgM.finishAuthOKBtn.isEnabled());
    }

    @Test(description = "Тестирование количества активации кнопки при вводе телефона без чекбокса", priority = 17)
    public void AuthtestButtonActivityNumbChars() {
        MainPageMenu mPgM = new MainPageMenu(driver);

        logger.info("Клик кнопки пропустить");
        mPgM.tapAndroidElement(mPgM.skipAuthPageOwnCount);

        logger.info("Оистка поля  ввода телефона");
        mPgM.cleanField("989610140".length());

        logger.info("Клик чекбокса - мені є 18 років");
        mPgM.tapAndroidElement(mPgM.checkboc18Years);

        logger.info("Ввод телефона проверки без 1 цифры и проверка активации кнопки");
        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, mPhone.substring(0, mPhone.length() - 1));

        Assert.assertFalse(mPgM.finishAuthOKBtn.isEnabled());

    }

    @Test(description = "Тестирование otp code кнопки при неполном поле отп", priority = 18)
    public void AuthtestButtonActivityOtpShort() {
        MainPageMenu mPgM = new MainPageMenu(driver);

        logger.info("Клик кнопки пропустить");
        mPgM.tapAndroidElement(mPgM.skipAuthPageOwnCount);

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

    }

    @Test(description = "Тестирование положительной авторизации", priority = 19)
    public void AuthTestPositive() {
    MainPageMenu mPgM = new MainPageMenu(driver);

        logger.info("Клик кнопки пропустить");
        mPgM.tapAndroidElement(mPgM.skipAuthPageOwnCount);

        logger.info("Ввод телефона проверки");
        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, mPhone);

        logger.info("Клик получить отп код");
        mPgM.tapAndroidElement(mPgM.finishAuthOKBtn);

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

    @Test(description = "Тестирование неверного кода отп и количества попыток", priority = 20)
    public void AuthtestOTPCodeErrorsInput() {
        MainPageMenu mPgM = new MainPageMenu(driver);
        String testNumber = "989615159";

        logger.info("Клик кнопки пропустить");
        mPgM.tapAndroidElement(mPgM.skipAuthPageOwnCount);

        pause(3000);

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
        pause(2000);
        logger.info("Проверка сообщения об ошибке");
        Assert.assertEquals(mPgM.authIncorrectCodeBig.getText()
                , "Неправильний код");
        Assert.assertEquals(mPgM.authIncorrectCodeFullMsg.getText()
                , "Невірний код підтвердження, у вас залишилось 3 спроб");



        logger.info("Ввод отп кода тест - 2 попытка");
        mPgM.sendKeysAndroidElementOtpCode("1723");

        pause(2000);

        logger.info("Клик кнопки далее");
        mPgM.tapAndroidElement(mPgM.nextBtnOtpCodePg);

        logger.info("Проверка сообщения об ошибке");
        Assert.assertEquals(mPgM.authIncorrectCodeBig.getText()
                , "Неправильний код");
        Assert.assertEquals(mPgM.authIncorrectCodeFullMsg.getText()
                , "Невірний код підтвердження, у вас залишилось 2 спроб");

        pause(1000);

        logger.info("Ввод отп кода тест - 3 попытка");
        mPgM.sendKeysAndroidElementOtpCode("1233");

        logger.info("Клик кнопки далее");
        mPgM.tapAndroidElement(mPgM.nextBtnOtpCodePg);
        pause(2000);
        logger.info("Проверка сообщения об ошибке");
        Assert.assertEquals(mPgM.authIncorrectCodeBig.getText()
                , "Неправильний код");
        Assert.assertEquals(mPgM.authIncorrectCodeFullMsg.getText()
                , "Невірний код підтвердження, у вас залишилось 1 спроба");

        logger.info("Ввод отп кода тест - еше 1 символ и проверка активации кнопки");
        mPgM.sendKeysAndroidElementOtpCode("1244");

        logger.info("Клик кнопки далее");
        mPgM.tapAndroidElement(mPgM.nextBtnOtpCodePg);

        pause(1000);

        Assert.assertEquals(mPgM.authIncorrectMsgAfter3Input.getText()
                , "Ви тричі невірно ввели код підтвердження. Спробуйте через 30 хвилин");
        pause(3000);
        logger.info("Ввод телефона проверки");
        mPgM.tapAndroidElement(mPgM.mPhomeInputField);
        mPgM.sendKeysAndroidElement(mPgM.mPhomeInputField, testNumber);

        logger.info("Клик получить отп код");
        mPgM.tapAndroidElement(mPgM.finishAuthOKBtn);

        Assert.assertEquals(mPgM.authIncorrectMsgAfter3Input.getText()
                , "Ви вичерпали можливість відправки коду підтвердження. Спробуйте через 30 хвилин");


    }
/*
    @Test(description = "Тестирование неверного кода отп и количества попыток", priority = 20)
    public void AuthtestOTPCodeErrorsInput2() {
        MainPageMenu mPgM = new MainPageMenu(driver);
        String testNumber = "989615140";

        pause(1000);
        logger.info("Клик кнопки пропустить");
        mPgM.tapAndroidElement(mPgM.skipAuthPageOwnCount);

        pause(3000);

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
        pause(2000);
        logger.info("Проверка сообщения об ошибке");
        Assert.assertEquals(mPgM.authIncorrectCodeBig.getText()
                , "Неправильний код");
        Assert.assertEquals(mPgM.authIncorrectCodeFullMsg.getText()
                , "Невірний код підтвердження, у вас залишилось 3 спроб");



        logger.info("Ввод отп кода тест - 1 попытка");
        mPgM.sendKeysAndroidElementOtpCode("1223");

        logger.info("Клик кнопки далее");
        mPgM.tapAndroidElement(mPgM.nextBtnOtpCodePg);
        pause(2000);
    }

    @Test(description = "Тестирование неверного кода отп и количества попыток", priority = 4)
    public void AuthtestOTPCodeBankCard() throws FileNotFoundException {
        MainPageMenu mPgM = new MainPageMenu(driver);

        FileInputStream fis = new FileInputStream("configmail.properties");
        Properties properties = new Properties();
        properties.load(fis);
    }*/


}
