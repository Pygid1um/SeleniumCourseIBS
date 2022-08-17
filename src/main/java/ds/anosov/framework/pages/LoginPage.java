package ds.anosov.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class LoginPage extends BasePage {

    @FindBy(xpath = "//form[@id='login-form']")
    private WebElement loginFormWindow;

    @FindBy(name = "_username")
    private WebElement loginField;

    @FindBy(name = "_password")
    private WebElement passwordField;

    @FindBy(name = "_submit")
    private WebElement singInButton;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement subtitle;


    public LoginPage enterLoginAndPassword(String login, String password) {
        wait.until(visibilityOf(loginFormWindow));
        fillInputField(loginField, login);
        fillInputField(passwordField, password);
        return pageManager.getLoginPage();
    }

    public MainMenuPage submitEnterButtonClick() {
        singInButton.click();
        wait.until(visibilityOf(subtitle));
        return pageManager.getMainMenuPage();
    }

}
