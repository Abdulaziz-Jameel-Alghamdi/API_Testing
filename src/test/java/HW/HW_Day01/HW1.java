package HW.HW_Day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HW1 {


    /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */
    @Test
    public void test() {


//    Given
//    https://reqres.in/api/users/3

        String url = "https://reqres.in/api/users/3";

        //    When
//    User sends a GET Request to the url

        Response response = given().when().get(url);

//    Then
//    HTTP Status Code should be 200
        int statuscode = response.statusCode();
        System.out.println("statuscode = " + statuscode);

//    And
//    Content Type should be JSON
        String contantType = response.contentType();
        System.out.println("contantType = " + contantType);

//            And
//    Status Line should be HTTP/1.1 200 OK
        String statusline = response.statusLine();
        System.out.println("statusline = " + statusline);

        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .statusLine("HTTP/1.1 200 OK");
    }


}
