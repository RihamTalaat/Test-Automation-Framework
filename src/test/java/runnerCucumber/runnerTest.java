package runnerCucumber;

import io.cucumber.testng.CucumberOptions;
import test.Day1;

@CucumberOptions(features = "src/test/java/featureCucumber"
        ,glue= {"stepsCucumber"}
        ,plugin= {"pretty","html:target/cucumber_html_report.html"})
public class runnerTest extends Day1 {
}
