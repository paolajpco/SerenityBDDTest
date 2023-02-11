import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SerenityRunner.class)
public class DeleteDataUsersTests {
    private static final String restApiUrl = "https://dummyapi.io";

    @Test
    //HappyPath
    public void deleteUsersID() {

        Actor paola = Actor.named("Paola user").whoCan(CallAnApi.at(restApiUrl));
        String registerUserInfo = "{" +
                "\"id\": \"74973374307\"}";
        paola.attemptsTo(new GetDataUserID(registerUserInfo));
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);

    }

    //UnHappyPath
    @Test

    public void deleteUsersIDFail() {

        Actor paola = Actor.named("Paola user").whoCan(CallAnApi.at(restApiUrl));
        String registerUserInfo = "{" +
                "\"id\": \"74973374307\"}";
        paola.attemptsTo(new GetDataUserID(registerUserInfo));
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(403);

    }
}
