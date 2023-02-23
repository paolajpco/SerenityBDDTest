package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import tasks.GetDataUsers;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.assertj.core.api.Assertions.assertThat;


public class GetUsersSteps {
    private static final String restApiUrl = "https://dummyapi.io";
    @Given("{actor} need to know the available users")
    public void callApiEndpoint(Actor actor) {
        //actor = Actor.named("Paola user").whoCan(CallAnApi.at(restApiUrl));
        theActorCalled("Paola user").whoCan(CallAnApi.at(restApiUrl));
    }
    @When("{actor] get the response from the GET method ")
    public void requestHeader(Actor actor) {
        //actor.attemptsTo(new GetDataUsers());
        theActorInTheSpotlight().attemptsTo(new GetDataUsers());
    }

    @Then("I get a valid HTTP response code 200")
    public void getValidResponse(){
        //assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);
        assertThat(lastResponse().statusCode()).isEqualTo(200);

    }



}