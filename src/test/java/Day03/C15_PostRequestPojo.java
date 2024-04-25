package Day03;

import BaseUrls.JsonPlaseHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.JsonPlaseHolderPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C15_PostRequestPojo extends JsonPlaseHolderBaseUrl {


    /*
     Given
        https://jsonplaceholder.typicode.com/todos
        {
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
    public void PostRequestPojoTest() {

        //set url
        spes.pathParam("first", "todos");

        // set Expected Data
        JsonPlaseHolderPojo payLoad = new JsonPlaseHolderPojo(false, 55, "Tidy your room");

        System.out.println("payLoad.getTitle() = " + payLoad.getTitle());

        //sent request and get response

        Response response = given(spes).body(payLoad).when().post("{first}");

        // do assertions
        JsonPlaseHolderPojo actualData = response.as(JsonPlaseHolderPojo.class);

        assertEquals(201, response.statusCode());
        assertEquals(actualData.getUserId(),payLoad.getUserId()   );
        assertEquals(actualData.getTitle(),payLoad.getTitle()    );
        assertEquals( actualData.getCompleted(),payLoad.getCompleted());


    }
}
