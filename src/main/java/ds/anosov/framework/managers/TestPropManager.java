package ds.anosov.framework.managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropManager {

    private final Properties testPropManager = new Properties();
    private static TestPropManager INSTANCE = null;

    private TestPropManager() {
        try {
            testPropManager.load(new FileInputStream(
                    new File("src/main/resources/properties/" +
                            System.getProperty("env", "environment") + ".properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TestPropManager getTestPropManager() {
        if (INSTANCE == null) {
            INSTANCE = new TestPropManager();
        }
        return INSTANCE;
    }


    public String getProperty(String key) {
        return testPropManager.getProperty(key);
    }

}
