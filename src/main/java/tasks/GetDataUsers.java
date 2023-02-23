package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetDataUsers implements Task {

    private final String key;

    public GetDataUsers(String key) {
        this.key = key;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/data/v1/user")
                        .with(requestSpecification
                                -> requestSpecification.contentType(ContentType.JSON)
                                .header("app-id", key))
        );

    }
}
