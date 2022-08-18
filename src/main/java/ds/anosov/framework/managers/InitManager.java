package ds.anosov.framework.managers;

import java.time.Duration;

public class InitManager {

    private static final DriverManager driverManager = DriverManager.getDriverManager();

    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverManager.getDriver().manage().timeouts().scriptTimeout(Duration.ofMillis(500));
        driverManager.getDriver().get(TestPropManager.getTestPropManager().getProperty("base.url"));
    }

    public static void quitFramework() {
        driverManager.closeDriver();
    }

}
