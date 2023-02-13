import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class PostDataUsersTests  {
    private static final String restApiUrl = "https://dummyapi.io";

    @Test
    //HappyPath
    public void postUsers() {
        Random random = new Random();
        int randomNumber = random.nextInt(100000);
        String randomNumberString = Integer.toString(randomNumber);
        Actor paola = Actor.named("Paola user").whoCan(CallAnApi.at(restApiUrl));
        String registerUserInfo = "{" +
                "\"lastName\": \"Smith\"," +
                "\"firstName\": \"John\"," +
                "\"email\": \"mail"+randomNumberString+"@example.com\"" +
                "}";
        paola.attemptsTo(PostDataUser.withInfo(registerUserInfo));
        String id = SerenityRest.lastResponse().body().jsonPath().get("id");
        try {
            File file = new File("id.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(id);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
