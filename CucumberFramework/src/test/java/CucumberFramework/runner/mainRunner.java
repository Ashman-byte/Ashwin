package CucumberFramework.runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;





@RunWith(Cucumber.class)

@CucumberOptions (
	features = {"src/test/java/CucumberFramework/featurefile/"},
			glue = {"CucumberFramework.stepFiles"},
			tags = "@napa05"
//	plugin = {"pretty", "html:target/autocare",
//				"json:target/autocare.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)






public class mainRunner {

}
