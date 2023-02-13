import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;


import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SerenityRunner.class)
public class DeleteDataUsersTests {
    private static final String restApiUrl = "https://dummyapi.io";

    @Test
    //HappyPath
    public void deleteUsersID() {
        File file = new File("id.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String id = br.readLine();
            Actor paola = Actor.named("Paola user").whoCan(CallAnApi.at(restApiUrl));
            String registerUserInfo = "{" + "\"id\": \"" + id + "\"}";
            paola.attemptsTo(new GetDataUserID(registerUserInfo));
            assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //UnHappyPath
    @Test

    public void deleteUsersIDFail() {

        Actor paola = Actor.named("Paola user").whoCan(CallAnApi.at(restApiUrl));
        String registerUserInfo = "{" +
                "\"id\": \"1234567890\"}";
        paola.attemptsTo(new GetDataUserID(registerUserInfo));
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(403);

    }
}
