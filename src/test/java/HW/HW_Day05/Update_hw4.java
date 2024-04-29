package HW.HW_Day05;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.pet_HW.createUser;

import java.util.Map;

import static TestData.Json_Plase_Holder_Test_Data.jsonPlaseHolderMapper;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Update_hw4 extends HW_BaseUrl {

    @Test
    public void putrequestTest() {

        //set url
        spes.pathParams("first", "v2", "second", "user", "thrid", "azoz");

        createUser payLoad = new createUser
                ("fahad", "mohammed", "azoz0044", 1, "0505842910", 152, "azaz@gmail.com", "homework");

        Response response = given(spes)
                .body(payLoad)
                .when()
                .put("{first}/{second}/{thrid}");

        response.prettyPrint();

        Map<String, Object> actualData = response.as(Map.class);

        assertEquals(200, response.statusCode());
    }
}

