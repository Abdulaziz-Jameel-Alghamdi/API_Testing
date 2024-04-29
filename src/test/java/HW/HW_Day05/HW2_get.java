package HW.HW_Day05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class HW2_get extends HW_BaseUrl {

    //Write an automation test that will create a 'user' then read, update and delete the created user using the "https://petstore.swagger.io/"
    // document.
    // (Create a classes for each request.)

    @Test
    public void getdataTest() {

        // set Url
        spes.pathParams("first", "v2", "second", "user", "thrid", "homework");
        // send request and get response
        Response response = given(spes).when().contentType(ContentType.JSON).get("{first}/{second}/{thrid}");
        response.prettyPrint();

        Assert.assertEquals(200, response.statusCode());
    }
}
