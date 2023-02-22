package Runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/GetIdUser.feature")
public class GetDataUserIDRunner {
    private static final String restApiUrl = "https://dummyapi.io";

}
