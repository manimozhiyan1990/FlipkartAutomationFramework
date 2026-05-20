package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature",
        glue = {"stepdefinition","hooks"},
        plugin = {"pretty","html:target/reports/HtmlReports/Flipkart.html",
                "json:target/reports/JsonReports/Flipkart.json",
                "junit:target/reports/XmlReports/Flipkart.xml",
        },
        publish = true,tags = "@sanity")

public class TestRunner {

}
