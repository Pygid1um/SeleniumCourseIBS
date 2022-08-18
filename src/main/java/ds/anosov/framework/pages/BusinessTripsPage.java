package ds.anosov.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessTripsPage extends BasePage {

    @FindBy(xpath = "//ul[@class='breadcrumb']")
    private WebElement businessTripsTitle;

    @FindBy(xpath = "//a[@title='Создать командировку']")
    private WebElement buttonCreateBusinessTrips;

    public BusinessTripsPage checkBusinessTripsTitle() {
        Assertions.assertEquals("Расходы/ Командировки", businessTripsTitle.getText(),
                "Заголовок не соответствует ожидаемому!");
        return pageManager.getBusinessTripsPage();
    }

    public CreateBusinessTripsPage clickButtonCreateBusinessTrips() {
        buttonCreateBusinessTrips.click();
        return pageManager.getCreateBusinessTripsPage();
    }

}
