package HW.HW_Day05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Hw3_Delete extends HW_BaseUrl {

    @Test
    public void deleteTest() {

        // set Url
        spes.pathParams("first", "v2", "second", "user", "thrid", "azoz");
        // send request and get response
        Response response = given(spes).when().contentType(ContentType.JSON).delete("{first}/{second}/{thrid}");
        response.prettyPrint();

        Assert.assertEquals(200, response.statusCode());
    }
}
