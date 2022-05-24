package PageObjects;

import com.epam.reportportal.annotations.Step;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.sun.webkit.CursorManager.WAIT;
import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;
import static testConstants.LoginConstants.mPhone;
import static testConstants.LoginConstants.otp;

public class AuthorizationPage extends BasePageObject {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationPage.class);

    public AuthorizationPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }


    @AndroidFindBy(id = "ua.fora.android.mtest:id/edit_phone")
    public AndroidElement mPhomeInputField;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/edit_code")
    public AndroidElement otpCodeField;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/button_ok")
    public AndroidElement nextBtnOtpCodePg;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/tv_skip")
    public AndroidElement skipAuthPageOwnCount;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/check_private")
    public AndroidElement checkboc18Years;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/button_ok")
    public AndroidElement getCodeBtn;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/button_ok")
    public AndroidElement finishAuthOKBtn;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/action_menu")
    public AndroidElement nextBtnAfterAuth;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/text_confirmation_otp")
    public AndroidElement authIncorrectCodeBig;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/text_check_again")
    public AndroidElement authIncorrectCodeFullMsg;

    @AndroidFindBy(id = "ua.fora.android.mtest:id/snackbar_text")
    public AndroidElement authIncorrectMsgAfter3Input;


    @Step("Считать текст андроид элемента")
    public String readAndroidElement(AndroidElement element) {
        WaitVisibilityOfElement(element);
        String textElement = element.getText();
        return textElement;
    }

    @Step("Клик Андроид элемента")
    public void tapAndroidElement(AndroidElement element) {
        //WaitVisibilityOfElement(element);
        element.click();
    }

    @Step("Передать текста в поле Андроид элемента")
    public void sendKeysAndroidElement(AndroidElement element, String textKey) {
        WaitVisibilityOfElement(element);
        element.sendKeys(textKey);
    }

    @Step("Передать текста в поле Андроид элемента otp Code")
    public void sendKeysAndroidElementOtpCode(String code) {
        char[] chars = ("" + code).toCharArray();
        for (char item : chars) {
            switch (Integer.parseInt(String.valueOf(item))) {
                case 0:
                    pause(2000);
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
                    pause(1000);
                    break;
                case 1:
                    pause(2000);
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
                    pause(1000);
                    break;
                case 2:
                    pause(2000);
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
                    pause(2000);
                    break;
                case 3:
                    pause(2000);
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
                    pause(2000);
                    break;
                case 4:
                    pause(2000);
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
                    pause(2000);
                    break;
                case 5:
                    pause(2000);
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
                    pause(2000);
                    break;
                case 6:
                    pause(2000);
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));
                    pause(2000);
                    break;
                case 7:
                    pause(2000);
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
                    pause(2000);
                    break;
                case 8:
                    pause(2000);
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
                    pause(2000);
                    break;
                case 9:
                    pause(2000);
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
                    pause(2000);
                    break;
            }

        }
    }

    @Step("Очистить поле")
    public void cleanField(int numChars) {
    for(int i =0;i < numChars;i++) {
        driver.pressKey(new KeyEvent(AndroidKey.DEL));
    }
    }

    @Step("Передать текста в поле Андроид элемента otp Code")
    public void sendKeysAndroidElementOtpCodeInt() {
        int[] numArr = {0, 0, 1, 2};
        for (int item : numArr) {
            ;
            otpCodeField.click();
            otpCodeField.sendKeys(String.valueOf(item));
        }
    }


    public void WaitVisibilityOfElement(AndroidElement element) {

        driver.manage().timeouts().implicitlyWait(WAIT, TimeUnit.SECONDS);
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(TIMEOUT));
        wait.pollingEvery(Duration.ofMillis(30));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    @Step("Проверка отображаются ли кнопки Зберегти и Відправити")
    public boolean isElementPresent(AndroidElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Обновить страницу для проверки результата")
    public void Tap_DriverRefresh() {
        driver.navigate().refresh();
        pause(3000);

    }

    @Step("Авторизация перед тестом")
    public void authBeforeTestWithTestNumbAndOtp() {

        logger.info("Клик чекбокса - мені є 18 років");
        tapAndroidElement(checkboc18Years);


        logger.info("Ввод телефона проверки");
        tapAndroidElement(mPhomeInputField);
        sendKeysAndroidElement(mPhomeInputField ,mPhone);

        logger.info("Клик получить отп код");
        tapAndroidElement(getCodeBtn);

        logger.info("Ввод отп кода тест");
        sendKeysAndroidElementOtpCode(otp);

        logger.info("Клик кнопки далее");
        tapAndroidElement(nextBtnOtpCodePg);

        pause(4000);

        logger.info("Клик кнопки завершить авторизацию");
        tapAndroidElement(finishAuthOKBtn);

        pause(15000);

        logger.info("Клик кнопки Далее - вход в главное старт меню приложения");
        tapAndroidElement(nextBtnAfterAuth);
    }


}
