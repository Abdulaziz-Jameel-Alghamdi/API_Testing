package Day03;

import BaseUrls.JsonPlaseHolderBaseUrl;
import TestData.Json_Plase_Holder_Test_Data;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static TestData.Json_Plase_Holder_Test_Data.jsonPlaseHolderMapper;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C13_PutRequset extends JsonPlaseHolderBaseUrl {

    /*
    Given
        1) https://jsonplaceholder.typicode.com/todos/198
        2) {
             "userId": 21,
             "title": "Read Books",
             "completed": false
           }
    When
        I send a PUT request to the URL
    Then
       the status code should be 200
       And the response body should be like:
       {
          "completed": false,
          "title": "Read Books",
          "userId": 21,
          "id": 198
       }
*/

    @Test
    public void pitRequestTest() {

        //set url
        spes.pathParams("first", "todos"
                , "second", 198);

        Map<String, Object> payLoad = jsonPlaseHolderMapper
                (21, "Read Books", false);

        Response response = given(spes)
                .body(payLoad)
                .when()
                .put("{first}/{second}");

        response.prettyPrint();

        Map<String, Object> actualData = response.as(Map.class);

        assertEquals(200, response.statusCode());
        assertEquals(payLoad.get("userId"), actualData.get("userId"));
        assertEquals(payLoad.get("title"), actualData.get("title"));
        assertEquals(payLoad.get("completed"), actualData.get("completed"));

    }
}









