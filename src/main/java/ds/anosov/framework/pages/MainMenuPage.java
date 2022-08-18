package ds.anosov.framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import java.util.List;

public class MainMenuPage extends BasePage {

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement mainMenuTitle;

    @FindBy(xpath = "//ul[contains(@class, 'main-menu')]/li")
    private List<WebElement> listBaseMenu;

    @FindBy(xpath = "//ul[contains(@class, 'menu_level_1')]/li[@data-route or @class='dropdown']")
    private List<WebElement> listSubMenu;

    @FindBy(xpath = "//ul[contains(@class, 'main-menu')]/li/a//span[text()='Расходы']/ancestor::" +
            "li/ul[@class='dropdown-menu menu_level_1']")
    private WebElement dropDownMenu;


    @Step("Проверка заголовка на основной странице")
    public MainMenuPage checkMainMenuTitle() {
        Assertions.assertEquals("Панель быстрого запуска", mainMenuTitle.getText(),
                "Заголовок не соответствует ожидаемому");
        return pageManager.getMainMenuPage();
    }

    @Step("Выбор основного меню на главной странице")
    public MainMenuPage selectBaseMenu(String nameBaseMenu) {
        for (WebElement itemMenu : listBaseMenu) {
            if (itemMenu.getText().contains(nameBaseMenu)) {
                itemMenu.click();
                return pageManager.getMainMenuPage();
            }
        }
        Assertions.fail("Меню " + nameBaseMenu + " не найдено на странице!");
        return pageManager.getMainMenuPage();
    }

    @Step("Выбор подменю на главной странице")
    public BusinessTripsPage selectSubMenu(String nameSubMenu) {
        wait.until(visibilityOf(dropDownMenu));
        for (WebElement itemMenu : listSubMenu) {
            if (itemMenu.getText().contains(nameSubMenu)) {
                itemMenu.click();
                return pageManager.getBusinessTripsPage();
            }
        }
        Assertions.fail("Меню " + nameSubMenu + " не найдено на странице!");
        return pageManager.getBusinessTripsPage();
    }
}
