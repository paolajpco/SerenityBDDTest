import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class PostDataUsersTests {
    private static final String restApiUrl = "https://dummyapi.io";

    @Test
    //HappyPath
    public void postUsers() {

        Actor paola = Actor.named("Paola user").whoCan(CallAnApi.at(restApiUrl));
        String registerUserInfo = "{" +
                "\"lastName\": \"Smith\"," +
                "\"firstName\": \"John\"," +
                "\"email\": \"johnx.smith@example.com\"" +
                "}";
        paola.attemptsTo(PostDataUser.withInfo(registerUserInfo));
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);

    }

    //UnHappyPath
    @Test

    public void postUsersFail() {

        Actor paola = Actor.named("Paola user").whoCan(CallAnApi.at(restApiUrl));
        String registerUserInfo = "{" +
                "\"lastName\": \"Smith\"," +
                "\"firstName\": \"John\"," +
                "\"email\": \"john.smith@example.com\"" +
                "}";
        paola.attemptsTo(PostDataUser.withInfo(registerUserInfo));
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(400);

    }
}
