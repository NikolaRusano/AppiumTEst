package PageObjects;

import PageObjects.Helpers.Timeouts;
import com.epam.reportportal.annotations.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class BasePageObject {

    public AndroidDriver driver;





    /*public BasePageObject(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(Timeouts.SLEEP_BEFORE_TEST);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }*/

    public void WaitVisibilityOfElement(AndroidElement element) {

        driver.manage().timeouts().implicitlyWait(Timeouts.WAIT, TimeUnit.SECONDS);
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(Timeouts.TIMEOUT));
        wait.pollingEvery(Duration.ofMillis(Timeouts.POLLYNGWAIT));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void pause(int ms) {
        try {
            sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
}
