package PageObjects;

import PageObjects.Helpers.Timeouts;
import com.epam.reportportal.annotations.Step;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AuthorizationPage {

    public AndroidDriver driver;



    @FindBy(id = "edit_phone")
    public AndroidElement mPhomeInputField;

    @FindBy(id = "ua.silpo.android.mtest:id/tv_skip")
    public AndroidElement skipAuthPageOwnCount;



    @Step("Считать текст андроид элемента")
    public String readAndroidElement(AndroidElement element) {
        WaitVisibilityOfElement(element);
        String textElement = element.getText();
        return textElement;
    }

     @Step("Клик Андроид элемента")
    public void tapAndroidElement(AndroidElement element) {
        WaitVisibilityOfElement(element);
        element.click();
    }

    @Step("Передать текста в поле Андроид элемента")
    public void sendKeysAndroidElement(AndroidElement element, String textKey) {
        WaitVisibilityOfElement(element);
        element.sendKeys();
    }





    public void WaitVisibilityOfElement(AndroidElement element) {

        driver.manage().timeouts().implicitlyWait(Timeouts.WAIT, TimeUnit.SECONDS);
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(Timeouts.TIMEOUT));
        wait.pollingEvery(Duration.ofMillis(Timeouts.POLLYNGWAIT));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));

    }


}
