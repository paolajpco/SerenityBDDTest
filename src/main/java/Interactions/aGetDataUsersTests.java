package Interactions;

import tasks.GetDataUsers;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)

public class aGetDataUsersTests {
    private static final String restApiUrl = "https://dummyapi.io";

    @Test
    //HappyPath
    public void getUsers() {
        Actor paola = Actor.named("Paola user").whoCan(CallAnApi.at(restApiUrl));
        paola.attemptsTo(new GetDataUsers("63e57ac1b09c73713be29554"));
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);
    }

    //UnHappyPath
    @Test
    public void getUsersFail() {
        Actor paola = Actor.named("Paola user").whoCan(CallAnApi.at(restApiUrl));
        paola.attemptsTo(new GetDataUsers("12345"));
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(403);
    }
}
