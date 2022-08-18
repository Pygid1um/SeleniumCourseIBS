package ds.anosov.framework.steps;

import ds.anosov.framework.managers.PageManager;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;

public class LoginPageSteps {
    PageManager pageManager = PageManager.getPageManager();

    @Когда("^вводит логин \"(.*)\" и пароль \"(.*)\"$")
    public void enterLoginAndPassword(String login, String password) {
        pageManager.getLoginPage().enterLoginAndPassword(login, password);
    }

    @И("^входит в приложение$")
    public void submitEnterButtonClick() {
        pageManager.getLoginPage().submitEnterButtonClick();
    }
}
