package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutDataUser implements Performable {
    private final String userInfo;
    private final String idInfo;


    public PutDataUser(String userInfo, String idInfo) {
        this.userInfo = userInfo;
        this.idInfo = idInfo;
    }

    public static Performable withInfo(String userInfo) {
        return instrumented(PostDataUser.class, userInfo);
    }
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/data/v1/user/{id}").with(
                        requestSpecification ->
                                requestSpecification.header("app-id", "63e57ac1b09c73713be29554")
                                        .contentType(ContentType.JSON)
                                        .pathParam("id", idInfo)
                                        .body(userInfo)
                )
        );
    }
}

