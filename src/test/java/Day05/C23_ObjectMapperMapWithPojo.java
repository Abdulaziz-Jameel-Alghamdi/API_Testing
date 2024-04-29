package Day05;

import BaseUrls.JsonPlaseHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.JsonPlaseHolderPojo;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class C23_ObjectMapperMapWithPojo extends JsonPlaseHolderBaseUrl {

    /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
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

Note: Use map and POJO seperately
*/

    @Test
    public void ObjectMapperMapTest() throws JsonProcessingException {
        //set url
        spes.pathParam("first", "todos");

        // set expected data
        //Json_Plase_Holder_Test_Data.jsonPlaseHolderMapper(55,"Tidy your room" , false)

        String expectedStr = """
                                {
                                 "userId": 55,
                                "title": "Tidy your room",
                                "completed": false
                                }""";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonPlaseHolderPojo payload = objectMapper.readValue(expectedStr, JsonPlaseHolderPojo.class);

        // send request and get response
        Response response = given(spes).body(payload).post("{first}");
        response.prettyPrint();

        JsonPlaseHolderPojo actualData = objectMapper.readValue(response.asString(), JsonPlaseHolderPojo.class);

        Assert.assertEquals(201, response.statusCode());
        Assert.assertEquals(payload.getUserId() , actualData.getUserId());
        Assert.assertEquals(payload.getTitle() , actualData.getTitle());
        Assert.assertEquals(payload.getCompleted() , actualData.getCompleted());

    }

}
