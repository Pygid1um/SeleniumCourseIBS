package ds.anosov.framework.steps;

import ds.anosov.framework.managers.PageManager;
import io.cucumber.java.ru.И;

public class BusinessTripsPageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @И("^проверяет заголовок на странице 'Все Командировки'$")
    public void checkBusinessTripsTitle() {
        pageManager.getBusinessTripsPage().checkBusinessTripsTitle();
    }

    @И("^кликает по кнопке 'Создать командировку'$")
    public void clickButtonCreateBusinessTrips() {
        pageManager.getBusinessTripsPage().clickButtonCreateBusinessTrips();
    }


}
