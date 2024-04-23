package day01.HW_Day01;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class HW2 {

    /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void test() {

//        Given
//        https://reqres.in/api/users/23
        String url = "https://reqres.in/api/users/23";

//        When
//        User send a GET Request to the url
        Response response = given().when().get(url);

//        Then
//        HTTP Status code should be 404
        int statuscode = response.statusCode();
        System.out.println("statuscode = " + statuscode);

//        And
//        Status Line should be HTTP/1.1 404 Not Found
        String statusline = response.statusLine();
        System.out.println("statusline = " + statusline);

//        And
//        Server is "cloudflare"
//        And
//        Response body should be empty

        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server", "cloudflare")
                .body("isEmpty()", Matchers.is(true));


    }

}
