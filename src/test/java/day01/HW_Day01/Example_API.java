package day01.HW_Day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Example_API {

    @Test
    public void test() {

        /*
    Given Send GET request to https://reqres.in/api/users?page=2
    Then print status code
    And print status line
     */

        String url = "https://reqres.in/api/users?page=2";
        Response response = given().when().get(url);
        response.prettyPrint();

        int statuscode = response.statusCode();
        System.out.println("statuscode = " + statuscode);

        String statusLine = response.statusLine();
        System.out.println("statusLine = " + statusLine);
    }
}
