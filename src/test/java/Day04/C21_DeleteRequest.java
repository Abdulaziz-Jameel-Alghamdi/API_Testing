package Day04;

import BaseUrls.JsonPlaseHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class C21_DeleteRequest extends JsonPlaseHolderBaseUrl {

    /*
    Given
        https://jsonplaceholder.typicode.com/todos/198
    When
        I send DELETE Request to the Url
    Then
        Status code is 200
        And Response body is { }
*/

    @Test
    public void DeleteRequest() {

        spes.pathParams("first", "todos", "second", 198);

        // set expected Data

        // send request and get response
        Response response = given(spes).when().delete("{first}/{second}");

        // do assertion
        String responseString = response.asString();

        assertEquals(200, response.statusCode());
        assertTrue(responseString.equals("{}"));
    }
}
