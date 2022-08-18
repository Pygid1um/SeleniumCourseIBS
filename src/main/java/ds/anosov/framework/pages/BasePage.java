package ds.anosov.framework.pages;

import ds.anosov.framework.managers.DriverManager;
import ds.anosov.framework.managers.PageManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage {

    protected DriverManager driverManager = DriverManager.getDriverManager();
    protected JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driverManager.getDriver();
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

}
