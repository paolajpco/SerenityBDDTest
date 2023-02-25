package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import tasks.GetDataUsers;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.assertj.core.api.Assertions.assertThat;


public class GetUsersSteps {
    private static final String restApiUrl = "https://dummyapi.io";

    @Given("I need to know the available users")
    public void i_need_to_know_the_available_users() {
        //actor = Actor.named("Paola user").whoCan(CallAnApi.at(restApiUrl));
        theActorCalled("Paola user").whoCan(CallAnApi.at(restApiUrl));
        throw new io.cucumber.java.PendingException();
    }

    @When("I get the response from the GET method")
    public void i_get_the_response_from_the_get_method() {
        //actor.attemptsTo(new GetDataUsers());
        theActorInTheSpotlight().attemptsTo(new GetDataUsers());
        throw new io.cucumber.java.PendingException();
    }

    @Then("I get a valid HTTP response code {int}")
    public void i_get_a_valid_http_response_code(Integer int1) {
        //assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);
        assertThat(lastResponse().statusCode()).isEqualTo(200);
        throw new io.cucumber.java.PendingException();

    }


}