package ds.anosov.framework.managers;

import ds.anosov.framework.pages.BusinessTripsPage;
import ds.anosov.framework.pages.CreateBusinessTripsPage;
import ds.anosov.framework.pages.LoginPage;
import ds.anosov.framework.pages.MainMenuPage;

public class PageManager {

    private static PageManager INSTANCE = null;

    private LoginPage loginPage;
    private MainMenuPage mainMenuPage;
    private BusinessTripsPage businessTripsPage;
    private CreateBusinessTripsPage createBusinessTripsPage;


    private PageManager() {

    }

    public static PageManager getPageManager() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }


    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public MainMenuPage getMainMenuPage() {
        if (mainMenuPage == null) {
            mainMenuPage = new MainMenuPage();
        }
        return mainMenuPage;
    }

    public BusinessTripsPage getBusinessTripsPage() {
        if (businessTripsPage == null) {
            businessTripsPage = new BusinessTripsPage();
        }
        return businessTripsPage;
    }

    public CreateBusinessTripsPage getCreateBusinessTripsPage() {
        if (createBusinessTripsPage == null) {
            createBusinessTripsPage = new CreateBusinessTripsPage();
        }
        return createBusinessTripsPage;
    }


}


