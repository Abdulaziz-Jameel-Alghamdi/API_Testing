package Day05;

import BaseUrls.JsonPlaseHolderBaseUrl;
import TestData.Json_Plase_Holder_Test_Data;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class C22_ObjectMapperMap extends JsonPlaseHolderBaseUrl {

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
        Map<String, Object> payload = objectMapper.readValue(expectedStr, Map.class);

        // send request and get response
        Response response = given(spes).body(payload).post("{first}");
        response.prettyPrint();

        Map<String, Object> actualData = objectMapper.readValue(response.asString(), Map.class);

        Assert.assertEquals(201, response.statusCode());
        Assert.assertEquals(payload.get("userId"), actualData.get("userId"));
        Assert.assertEquals(payload.get("title"), actualData.get("title"));
        Assert.assertEquals(payload.get("completed"), actualData.get("completed"));

    }

}
