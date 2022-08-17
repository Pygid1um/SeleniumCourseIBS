package ds.anosov.tests.Task02;


import ds.anosov.tests.Task02.basetestsclass.BaseTest;
import org.junit.jupiter.api.Test;

public class Task02 extends BaseTest {

    @Test
    public void createOpty() {
        app.getLoginPage()
                .enterLoginAndPassword("Irina Filippova", "testing")
                .submitEnterButtonClick()
                .checkMainMenuTitle()
                .selectBaseMenu("Расходы")
                .selectSubMenu("Командировки")
                .checkBusinessTripsTitle()
                .clickButtonCreateBusinessTrips()
                .checkCreateBusinessTripsTitle()
                .clickSubdivision()
                .clickOrganizationsButtons()
                .selectOrganization("11111")
                .setCheckBox("Заказ билетов")
                .fillField("Город выбытия", "Россия, Питер")
                .fillField("Город прибытия", "Россия, Сетище")
                .fillField("Планируемая дата выезда", "02.08.2022")
                .fillField("Планируемая дата возвращения", "12.08.2022")
                .clickSaveAndClose()
                .checkErrorMessageAlert("Список командируемых сотрудников не может быть пустым");
    }
}
