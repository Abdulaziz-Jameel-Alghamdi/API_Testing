package HW.HW_Day05;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.pet_HW.createUser;

import static io.restassured.RestAssured.given;

public class Create_HW1 extends HW_BaseUrl {

    //Write an automation test that will create a 'user' then read, update and delete the created user using the "https://petstore.swagger.io/"
    // document.
    // (Create a classes for each request.)


    @Test
    public void createUser() throws JsonProcessingException {

        // set Url
        spes.pathParams("first", "v2", "second", "user");

        String expectedStr = """
                {
                  "id": 1,
                  "username": "azoz",
                  "firstName": "abdulaziz",
                  "lastName": "jameel",
                  "email": "azozalhout2017@gmail.com",
                  "password": "asas",
                  "phone": "054279222",
                  "userStatus": 0
                }""";

        ObjectMapper objectMapper = new ObjectMapper();
        createUser payload = objectMapper.readValue(expectedStr, createUser.class);

        // send request and get response
        Response response = given(spes).body(payload).when().post("{first}/{second}");
        response.prettyPrint();

        // do assertion


        Assert.assertEquals(201, response.statusCode());
//        Assert.assertEquals(payload.getId(),expectedStr.contains("id"));
//        Assert.assertEquals(payload.getUsername(), expectedStr.contains("username"));
//        Assert.assertEquals(payload.getFirstName(), expectedStr.contains("firstName"));
//        Assert.assertEquals(payload.getLastName(),expectedStr.contains("lastName"));
//        Assert.assertEquals(payload.getEmail(), expectedStr.contains("email"));
//        Assert.assertEquals(payload.getPassword(), expectedStr.contains("password"));
//        Assert.assertEquals(payload.getPhone(), expectedStr.contains("phine"));
//        Assert.assertEquals(payload.getUserStatus(),expectedStr.contains("userStatus"));


    }
}

