package ds.anosov.framework.steps;

import ds.anosov.framework.managers.InitManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void before() {
        InitManager.initFramework();
    }

    @After
    public void after() {
        InitManager.quitFramework();
    }
}
