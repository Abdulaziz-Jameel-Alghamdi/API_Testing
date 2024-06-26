package day01;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class C06_QueryParameters {

        /*
    Given
       https://restful-booker.herokuapp.com/booking
    When
       User sends a GET request to the URL
    Then
       Status code is 200
    And
       Among the data, there should be someone whose first name is "john" and last name is "smith"
*/

    @Test
    public void queryParametersTest() {

//        1. Set the URL
        String url = "https://restful-booker.herokuapp.com/booking?firstname=John&lastname=Smith";
//        2. Set the expected data

//        3. Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();
//        4. Do Assertion
        //1st way:

        response
                .then()
                .statusCode(200);

        String responseSTring = response.asString();
        Assert.assertTrue(responseSTring.contains("bookingid"));


        //2nd way:

        response
                .then()
                .statusCode(200)
                .body(containsString("bookingid"));

    }
}
