package Day03;

import BaseUrls.JsonPlaseHolderBaseUrl;
import TestData.Json_Plase_Holder_Test_Data;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C12_PostRequestTestData extends JsonPlaseHolderBaseUrl {

      /*
     Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
          }
    When
        I send POST Request to the Url

    Then
        Status code is 201
    And
        response body is like {
                                "userId": 55,
                                "title": "Tidy your room",
                                "completed": false,
                                "id": 201
                                }
*/

    @Test
    public void postRequestTest() {

        //Set the Url
        spes.pathParam("first", "todos");

        //Set the expected data(Payload) --> Prepare it as Map

        Map<String, Object> payLoad = Json_Plase_Holder_Test_Data
                .jsonPlaseHolderMapper(55, "Tidy your room", false);

        //Send the request and get the response
        Response response = given(spes).body(payLoad).when().post("{first}");
        response.prettyPrint();

        //Do assertion
        JsonPath json = response.jsonPath();
        assertEquals(201, response.statusCode());
        assertEquals(payLoad.get("userId"), json.getInt("userId"));

        Map<String, Object> actualData = response.as(Map.class);
        assertEquals(201, response.statusCode());
        assertEquals(payLoad.get("userId"), actualData.get("userId"));
        assertEquals(payLoad.get("title"), actualData.get("title"));
        assertEquals(payLoad.get("completed"), actualData.get("completed"));


    }
}

