package ds.anosov.framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class CreateBusinessTripsPage extends BasePage {

    @FindBy(xpath = "//h1[@class='user-name']")
    private WebElement createBusinessTripsTitle;

    @FindBy(xpath = "//select[contains(@id, 'crm_business_trip_businessUnit')]")
    private WebElement fieldSubdivision;

    @FindBy(xpath = "//div[contains(@id, 'uniform-crm_business_trip_businessUnit')]//option[@value='7']")
    private WebElement subdivision;

    @FindBy(xpath = "//a[@id='company-selector-show']")
    private WebElement organizationsButton;

    @FindBy(xpath = "//a[@class='select2-choice select2-default']")
    private WebElement listOfOrganizationsButton;

    @FindBy(xpath = "//ul[@class='select2-results']/li")
    private List<WebElement> listOrganizations;

    @FindBy(xpath = "//ul[@class='select2-results']/li[contains(@class, 'select2-highlighted')]")
    private WebElement dropDownMenuOrganization;

    @FindBy(xpath = "//div[@class='oro-clearfix']")
    private List<WebElement> listCheckbox;

    @FindBy(xpath = "//input[@data-name='field__departure-city']")
    private WebElement departureCityField;

    @FindBy(xpath = "//div[@class='controls']/input[@data-name='field__arrival-city']")
    private WebElement arrivalCityField;

    @FindBy(xpath = "//*[text()='Планируемая дата выезда']/../following-sibling::div/input")
    private WebElement plannedDepartureDate;

    @FindBy(xpath = "//*[text()='Планируемая дата возвращения']/../following-sibling::div/input")
    private WebElement plannedReturnDate;

    @FindBy(xpath = "//div[@class='btn-group']/button[@class='btn btn-success action-button']")
    private WebElement saveAndCloseButton;

    @FindBy(xpath = "//span[@class='validation-failed']")
    private WebElement errorMessageAlert;

    @Step("Проверка заголовка на странице создания командировок")
    public CreateBusinessTripsPage checkCreateBusinessTripsTitle() {
        wait.until(visibilityOf(createBusinessTripsTitle));
        Assertions.assertEquals("Создать командировку", createBusinessTripsTitle.getText(),
                "Заголовок не соответствует ожидаемому!");
        return pageManager.getCreateBusinessTripsPage();
    }

    @Step("Выбор подразделения")
    public CreateBusinessTripsPage clickSubdivision() {
        fieldSubdivision.click();
        subdivision.click();
        String expectedSubdivision = "Отдел внутренней разработки";
        Assertions.assertEquals(expectedSubdivision, subdivision.getText(),
                "Выбранное подразделение не соответствует ожидаемому!");
        return pageManager.getCreateBusinessTripsPage();
    }

    @Step("Открытие списка организаций")
    public CreateBusinessTripsPage clickOrganizationsButtons() {
        organizationsButton.click();
        listOfOrganizationsButton.click();
        return pageManager.getCreateBusinessTripsPage();
    }

    @Step("Выбор организации из списка")
    public CreateBusinessTripsPage selectOrganization(String nameOfOrganization) {
        wait.until(visibilityOf(dropDownMenuOrganization));
        for (WebElement itemMenu : listOrganizations) {
            if (itemMenu.getText().contains(nameOfOrganization)) {
                itemMenu.click();
                return pageManager.getCreateBusinessTripsPage();
            }
        }
        Assertions.fail("Меню " + nameOfOrganization + " не найдено на странице!");
        return pageManager.getCreateBusinessTripsPage();
    }

    @Step("Выбор чекбокса 'Задачи'")
    public CreateBusinessTripsPage setCheckBox(String nameOfCheckBox) {
        for (WebElement checkBox : listCheckbox) {
            if (checkBox.getText().contains(nameOfCheckBox)) {
                selectCheckbox(checkBox, nameOfCheckBox);
                return pageManager.getCreateBusinessTripsPage();
            }
        }
        Assertions.fail("Чекбокс " + nameOfCheckBox + " не найден!");
        return pageManager.getCreateBusinessTripsPage();
    }

    @Step("Заполнение полей 'Города' и 'Даты'")
    public CreateBusinessTripsPage fillField(String nameField, String value) {
        WebElement element = null;
        switch (nameField) {
            case "Город выбытия":
                fillInputField(departureCityField, value);
                element = departureCityField;
                break;
            case "Город прибытия":
                fillInputField(arrivalCityField, value);
                element = arrivalCityField;
                break;
            case "Планируемая дата выезда":
                fillDateField(plannedDepartureDate, value);
                element = plannedDepartureDate;
                break;
            case "Планируемая дата возвращения":
                fillDateField(plannedReturnDate, value);
                element = plannedReturnDate;
                break;
            default:
                Assertions.fail("Поле с наименованием " + nameField + " отсутствует на странице " +
                        "'Создать командировку'");
        }
        Assertions.assertEquals(value, element.getAttribute("value"),
                "Поле " + nameField + " было заполнено некорректно");
        return pageManager.getCreateBusinessTripsPage();
    }

    @Step("Нажатие на кнопку 'Сохранить и закрыть'")
    public CreateBusinessTripsPage clickSaveAndClose() {
        saveAndCloseButton.click();
        return pageManager.getCreateBusinessTripsPage();
    }

    @Step("Проверка появившейся ошибки")
    public CreateBusinessTripsPage checkErrorMessageAlert(String errMessage) {
        scrollToElementJs(errorMessageAlert);
        Assertions.assertEquals(errMessage, errorMessageAlert.getText(), "Проверка ошибки у alert на странице " +
                "'Создать командировку' было не пройдено" );
        attachScreenshot();
        return pageManager.getCreateBusinessTripsPage();
    }

}
