package Day03;

import BaseUrls.JsonPlaseHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C11_PostRequestMap extends JsonPlaseHolderBaseUrl {



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
        spes.pathParams("first", "todos");

        //Set the expected data(Payload) --> Prepare it as Map

        Map<String, Object> payload = new HashMap<>();

        payload.put("userid", 55);
        payload.put("title", "Tidy your room");
        payload.put("completed", false);
        //System.out.println("payload.get(\"userId\") = " + payload.get("userid"));

        //Send the request and get the response

        Response response = given(spes).body(payload).when().post("{first}");
        response.prettyPrint();

        //Do assertion
        JsonPath json = response.jsonPath();
        assertEquals(201, response.statusCode());
        assertEquals(payload.get("userid"), json.getInt("userid"));

        Map<String, Object> actualData = response.as(Map.class);
        assertEquals(201, response.statusCode());
        assertEquals(payload.get("userid"), actualData.get("userid"));
        assertEquals(payload.get("title"), actualData.get("title"));
        assertEquals(payload.get("completed"), actualData.get("completed"));


    }
}
