package ds.anosov.tests.framework.CucumberRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/scenario"},
        glue = {"ds.anosov.framework.steps"},
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        tags = "@FirstTest"
)

public class CucumberRunner {

}
