package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetDataUserID implements Task {
    private final String userInfo;

    public GetDataUserID(String userInfo) {
        this.userInfo = userInfo;
    }

    public <T extends Actor> void performAs(T actor) {
        SerenityRest.enableLoggingOfRequestAndResponseIfValidationFails();
        actor.attemptsTo(
                Get.resource("/data/v1/user/{id}")
                        .with(requestSpecification
                                -> requestSpecification
                                .header("app-id", "63e57ac1b09c73713be29554")
                                .contentType(ContentType.JSON)
                                .pathParam("id", userInfo)
                        ));
    }
}
