package ds.anosov.framework.steps;

import ds.anosov.framework.managers.PageManager;
import io.cucumber.java.ru.И;

public class MainMenuPageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @И("^проверяет заголовок на основной странице$")
    public void checkMainMenuTitle() {
        pageManager.getMainMenuPage().checkMainMenuTitle();
    }

    @И("^выбирает \"(.+)\" в основном меню на главной странице$")
    public void selectBaseMenu(String nameBaseMenu) {
        pageManager.getMainMenuPage().selectBaseMenu(nameBaseMenu);
    }


    @И("^выбирает \"(.+)\" в подменю на главной странице$")
    public void selectSubMenu(String nameBaseMenu) {
        pageManager.getMainMenuPage().selectSubMenu(nameBaseMenu);
    }
}
