package Runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/PostUser.feature")
public class PostDataUsersRunner {
    private static final String restApiUrl = "https://dummyapi.io";


}
