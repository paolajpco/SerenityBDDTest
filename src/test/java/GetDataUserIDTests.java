import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class GetDataUserIDTests {
    private static final String restApiUrl = "https://dummyapi.io";

    @Test
    //HappyPath
    public void getUsersID() {

        Actor paola = Actor.named("Paola user").whoCan(CallAnApi.at(restApiUrl));
        String registerUserInfo = "60d0fe4f5311236168a109cf";
        paola.attemptsTo(new GetDataUserID(registerUserInfo));
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);

    }

    //UnHappyPath

    @Test

    public void getUsersIDFail() {

        Actor paola = Actor.named("Paola user").whoCan(CallAnApi.at(restApiUrl));
        String registerUserInfo = "123456";
        paola.attemptsTo(new GetDataUserID(registerUserInfo));
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(400);

    }

}
