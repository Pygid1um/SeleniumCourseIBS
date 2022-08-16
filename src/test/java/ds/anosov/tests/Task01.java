package ds.anosov.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Task01 {

    WebDriver driver;
    WebDriverWait wait;
    final private String LOGIN = "Irina Filippova";
    final private String PASSWORD = "testing";

    @BeforeEach
    public void beforeEachTests() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://training.appline.ru/user/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMillis(500));
        driver.manage().window().maximize();

    }

    @Test
    public void createOpty() {
        //Авторизация
        wait.until(visibilityOf(driver.findElement(By.xpath("//form[@id='login-form']"))));
        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys(LOGIN);
        driver.findElement(By.xpath("//input[@name='_password']")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//button[@id='_submit']")).click();
        wait.until(visibilityOf(driver.findElement(By.xpath("//h1[@class='oro-subtitle']"))));


        //Переход на страницу командировок
        WebElement costsList = driver.findElement(By.xpath(
                "//ul[contains(@class, 'main-menu')]/li/a//span[text()='Расходы']"));
        costsList.click();
        wait.until(visibilityOf(costsList.findElement(By.xpath(
                "./ancestor::li/ul[@class='dropdown-menu menu_level_1']"))));
        driver.findElement(By.xpath("//span[text()='Командировки']")).click();
        loadingPage();


        //Создать коммандировку
        driver.findElement(By.xpath("//a[@title='Создать командировку']")).click();
        wait.until(visibilityOf(costsList.findElement(By.xpath("//h1[@class='user-name']"))));


        //выбираем подразделение
        driver.findElement(By.xpath("//select[contains(@id, 'crm_business_trip_businessUnit')]")).click();
        WebElement actualSubdivision = driver.findElement(By.xpath(
                "//div[contains(@id, 'uniform-crm_business_trip_businessUnit')]//option[@value='7']"));
        actualSubdivision.click();
        String expectedSubdivision = "Отдел внутренней разработки";
        Assertions.assertEquals(expectedSubdivision, actualSubdivision.getText(),
                "Выбранное подразделение не соответствует ожидаемому!");


        //Выбираем организацию из списка
        driver.findElement(By.xpath("//a[@id='company-selector-show']")).click();
        driver.findElement(By.xpath("//a[@class='select2-choice select2-default']")).click();
        wait.until(visibilityOf(driver.findElement(By.xpath(
                "//ul[@class='select2-results']/li[contains(@class, 'select2-highlighted')]")))).click();
        String actualOrganization = driver.findElement(By.xpath("//span[@class='select2-chosen']")).getText();
        String expectedOrganization = "?????";
        Assertions.assertEquals(expectedOrganization, actualOrganization,
                "Выбранная организация не соответствует ожидаемому!");


        //Чекбокс Заказ билетов
        WebElement checkboxTasks = driver.findElement(By.xpath("//div[@class='oro-clearfix']/input[@data-name='field__1']"));
        checkboxTasks.click();
        Assertions.assertTrue(checkboxTasks.isDisplayed());


        //Выбор городов
        WebElement fieldDepartureCity = driver.findElement(By.xpath("//input[@data-name='field__departure-city']"));
        fieldDepartureCity.clear();
        String departureCity = "Россия, Питер";
        fieldDepartureCity.sendKeys(departureCity);
        String actualDepartureCity = fieldDepartureCity.getAttribute("value");
        Assertions.assertEquals(departureCity, actualDepartureCity,"Город выбытия введен не верно!");

        WebElement fieldArrivalCity = driver.findElement(By.xpath("//div[@class='controls']" +
                "/input[@data-name='field__arrival-city']"));
        String arrivalCity = "Россия, Сетище";
        fieldArrivalCity.sendKeys(arrivalCity);
        String actualArrivalCity = fieldArrivalCity.getAttribute("value");
        Assertions.assertEquals(arrivalCity, actualArrivalCity, "Город выбытия введен не верно!");



        //Выбор дат
        WebElement fieldDateOfDeparture = driver.findElement(By.xpath(
                "//*[text()='Планируемая дата выезда']/../following-sibling::div/input"));
        String dateOfDeparture = "02.08.2022";
        fieldDateOfDeparture.sendKeys(dateOfDeparture);
        wait.until(visibilityOf(driver.findElement(By.xpath("//div[@id='ui-datepicker-div']"))));
        String dayOfDeparture = "2";
        driver.findElement(By.xpath(String.format("//td[@data-handler='selectDay']/a[text()='%s']", dayOfDeparture))).click();
        String actualDateOfDeparture = fieldDateOfDeparture.getAttribute("value");
        Assertions.assertEquals(dateOfDeparture, actualDateOfDeparture, "Дата выбытия не совпадает с введенной!");

        WebElement fieldDateOfArrival = driver.findElement(By.xpath(
                "//*[text()='Планируемая дата возвращения']/../following-sibling::div/input"));
        String dateOfArrival = "12.08.2022";
        fieldDateOfArrival.sendKeys(dateOfArrival);
        wait.until(visibilityOf(driver.findElement(By.xpath("//div[@id='ui-datepicker-div']"))));
        String dayOfArrival = "12";
        driver.findElement(By.xpath(String.format("//td[@data-handler='selectDay']/a[text()='%s']", dayOfArrival))).click();
        String actualDateOfArrival = fieldDateOfArrival.getAttribute("value");
        Assertions.assertEquals(dateOfArrival, actualDateOfArrival, "Дата прибытия не совпадает с введенной!");


        //Кнопка Сохранить и далее
        driver.findElement(By.xpath("//div[@class='btn-group']" +
                "/button[@class='btn btn-success action-button']")).click();
        loadingPage();


        //Появляющееся сообщение
        String errorMessage = "Список командируемых сотрудников не может быть пустым";
        Assertions.assertTrue(driver.findElement(By.xpath("//span[@class='validation-failed']"))
                .isDisplayed(), "Сообщение " + errorMessage + " не появилось!");
        String actualErrorMessage = driver.findElement(By.xpath("//span[@class='validation-failed']")).getText();
        Assertions.assertEquals(errorMessage, actualErrorMessage);

    }


    @AfterEach
    public void afterEachTests () {
        driver.quit();
    }


    public void loadingPage() {
        wait.until(invisibilityOf(driver.findElement(By.xpath(
                "//div[@class='loader-mask shown']"))));
    }

}
