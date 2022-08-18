package ds.anosov.framework.pages;

import ds.anosov.framework.managers.DriverManager;
import ds.anosov.framework.managers.PageManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage {

    protected DriverManager driverManager = DriverManager.getDriverManager();
    protected JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driverManager.getDriver();
    protected PageManager pageManager = PageManager.getPageManager();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(1));


    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    protected WebElement waitUtilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void fillInputField(WebElement field, String value) {
        waitUtilElementToBeClickable(field).click();
        field.clear();
        field.sendKeys(value);
    }

    protected void selectCheckbox(WebElement checkbox, String checkboxName) {
        WebElement checkboxButton = checkbox.findElement(By.xpath("./input"));
        if (!checkbox.isSelected()) {
            waitUtilElementToBeClickable(checkboxButton).click();
        }
        assertTrue(checkboxButton.isSelected(), "Чекбокс '" + checkboxName + "' не выбран");
    }

    protected void fillDateField(WebElement element, String value) {
        waitUtilElementToBeClickable(element).click();
        element.clear();
        element.sendKeys(value);
        element.sendKeys(Keys.ESCAPE);
    }

    protected WebElement scrollToElementJs(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    @Attachment(value = "Скриншот ошибки", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
