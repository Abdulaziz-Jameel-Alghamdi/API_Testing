package day01;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class StaticImportBaseURI {

    /*
Given Send GET request by adding static import to the class
Then assert that status code is 200
And assert that status line is HTTP/1.1 200 OK
 */

    @Test
    public void test() {

        String url = "https://reqres.in/api/users?page=2";

        Response response = given().when().get(url);
        response.prettyPrint();

        int statuscode = response.statusCode();
        System.out.println("statuscode = " + statuscode);

        String statusline = response.statusLine();
        System.out.println("statusline = " + statusline);

        response
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");
    }
}
