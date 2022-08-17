package ds.anosov.tests.Task02.basetestsclass;

import ds.anosov.framework.managers.DriverManager;
import ds.anosov.framework.managers.InitManager;
import ds.anosov.framework.managers.PageManager;
import ds.anosov.framework.managers.TestPropManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected PageManager app = PageManager.getPageManager();
    private DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeAll
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @BeforeEach
    public void beforeEach() {
        driverManager.getDriver().get(TestPropManager.getTestPropManager().getProperty("base.url"));
    }

    @AfterAll
    public static void afterAll() {
        InitManager.quitFramework();
    }
}
