package ds.anosov.framework.steps;

import io.cucumber.datatable.DataTable;
import ds.anosov.framework.managers.PageManager;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

import java.util.Map;

public class CreateBusinessTripsPageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @И("^проверяет заголовок на странице создания командировок$")
    public void checkCreateBusinessTripsTitle() {
        pageManager.getCreateBusinessTripsPage().checkCreateBusinessTripsTitle();
    }

    @И("^выбирает подразделение$")
    public void clickSubdivision() {
        pageManager.getCreateBusinessTripsPage().clickSubdivision();
    }

    @И("^открывыет список организаций$")
    public void clickOrganizationsButtons() {
        pageManager.getCreateBusinessTripsPage().clickOrganizationsButtons();
    }

    @И("^выбирает организацию \"(.+)\" из списка$")
    public void selectOrganization(String nameOfOrganization) {
        pageManager.getCreateBusinessTripsPage().selectOrganization(nameOfOrganization);
    }

    @И("^выбирает чекбокс \"(.+)\"$")
    public void setCheckBox(String nameOfCheckBox) {
        pageManager.getCreateBusinessTripsPage().setCheckBox(nameOfCheckBox);
    }

    @И("^заполняет поля:$")
    public void fillField(DataTable dataTable) {
        Map<String,String> fields = dataTable.asMap(String.class, String.class);
        fields.forEach((nameField, value) -> pageManager.getCreateBusinessTripsPage().fillField(nameField, value));
    }

    @И("^нажимает на кнопку 'Сохранить и закрыть'$")
    public void clickSaveAndClose() {
        pageManager.getCreateBusinessTripsPage().clickSaveAndClose();
    }

    @Тогда("^проверяет появившуюся ошибку: \"(.+)\"$")
    public void checkErrorMessageAlert(String errMessage) {
        pageManager.getCreateBusinessTripsPage().checkErrorMessageAlert(errMessage);
    }
}
