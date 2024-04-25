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

public class C14_PatchRequest extends JsonPlaseHolderBaseUrl {
  /*
        Given
            1) https://jsonplaceholder.typicode.com/todos/198
            2) {
                 "title": "Read Books"
               }
        When
            I send PATCH Request to the Url
        Then
           Status code is 200
           And response body is like  {
                                            "userId": 10,
                                            "id": 198,
                                            "title": "Read Books",
                                            "completed": true
                                        }
    */

    @Test
    public void patchRequestTest() {
        // Set Url
        spes.pathParams("first", "todos", "second", 198);

        // Set Expected Data

        Map<String, Object> payload = Json_Plase_Holder_Test_Data.jsonPlaseHolderMapper(null, "Read Books", null);
        System.out.println("payload = " + payload);

        Map<String, Object> expectedData = Json_Plase_Holder_Test_Data.jsonPlaseHolderMapper(10, "Read Books", true);
        expectedData.put("id", 198);
        System.out.println("expectedData = " + expectedData);

        // sent Request and get response
        Response response = given(spes).body(payload).when().patch("{first}/{second}");
        response.prettyPrint();


        Map<String, Object> actualData = response.as(Map.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("id"), actualData.get("id"));
    }
}


