package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature",
        glue = "stepdefinition",
        plugin = {"pretty","html:target/reports/HtmlReports/Cricbuzz.html",
                "json:target/reports/JsonReports/Cricbuzz.json",
                "junit:target/reports/XmlReports/Cricbuzz.xml",
        },
        publish = true,tags = "@sanity")

public class TestRunner {

}
