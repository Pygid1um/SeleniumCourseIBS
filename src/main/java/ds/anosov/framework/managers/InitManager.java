package ds.anosov.framework.managers;

import java.time.Duration;

public class InitManager {

    private static final DriverManager driverManager = DriverManager.getDriverManager();
    private static final TestPropManager testPropManager = TestPropManager.getTestPropManager();

    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverManager.getDriver().manage().timeouts().scriptTimeout(Duration.ofMillis(500));
    }

    public static void quitFramework() {
        driverManager.closeDriver();
    }

}
