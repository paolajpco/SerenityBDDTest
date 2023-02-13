

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostDataUser implements Performable {
    private final String userInfo;

    public PostDataUser(String userInfo) {
        this.userInfo = userInfo;
    }

    public static Performable withInfo(String userInfo) {
        return instrumented(PostDataUser.class, userInfo);
    }
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/data/v1/user/create").with(
                        requestSpecification ->
                                requestSpecification.header("app-id", "63e57ac1b09c73713be29554")
                                        .contentType(ContentType.JSON)
                                        .body(userInfo)
                )
        );
    }
}

