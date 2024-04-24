package HW.HW_Day02;

import BaseUrls.HomeWork;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HW1 extends HomeWork {
    /*
        Given
        https://reqres.in/api/users/2
        When
        User send GET Request to the URL
                Then
        HTTP Status Code should be 200
        And
        Response format should be "application/json"
        And
               "email" is "janet.weaver@reqres.in",
        And
               "first_name" is "Janet"
        And
               "last_name" is "Weaver"
        And
               "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
                */
    @Test
    public void testHW1() {

//      When
//      User send GET Request to the URL

        spes.pathParams("first", "api"
                , "second", "users",
                    "thrid", 2);

        Response response = given(spes).when().get("{first}/{second}/{thrid}");
        response.prettyPrint();

        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


    }

}
