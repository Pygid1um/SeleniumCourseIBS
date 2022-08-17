package ds.anosov.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Properties;

public class DriverManager {

    private WebDriver driver;
    private static DriverManager INSTANCE = null;
    private final TestPropManager testPropManager = TestPropManager.getTestPropManager();

    private DriverManager() {

    }

    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }


    public void initDriver() {
        if (testPropManager.getProperty("type.browser").equals("chrome")){
            System.setProperty(testPropManager.getProperty("web.driver"), testPropManager.getProperty("web.driver.path"));
            driver = new ChromeDriver();
        }
        //else if()... если несколько браузеров используются, можно добавить сюда другие, например, fireFox
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}



