package Runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/PutUser.feature")
public class PutDataUsersRunner {
    private static final String restApiUrl = "https://dummyapi.io";

}
