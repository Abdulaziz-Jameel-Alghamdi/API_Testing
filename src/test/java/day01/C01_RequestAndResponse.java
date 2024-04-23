package day01;

import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class C01_RequestAndResponse {

    public static void main(String[] args) {

        /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET Request to the url
    Then
        Print Status Code (should be 200)
    And
        Print Content Type (should be JSON)
    And
        Print Status Line (should be HTTP/1.1 200 OK)
    And
        Print Connection and Date headers on console
    And
        Print all headers on console

*/
//-------------------------------------------------------------------
//        Given
//        https://restful-booker.herokuapp.com/booking
//------------------------------------------------------------------
//        When
//        User sends a GET Request to the url
        String url = "https://restful-booker.herokuapp.com/booking";
//--
        Response response = given().get(url);//All data i need is in response
        // how to print response
//        System.out.println(response);//this print referns of the response

        response.prettyPrint();//this print the response

//--------------------------------------------------------------
//        Then
//        Print Status Code (should be 200)

        int statusCode = response.statusCode();
        System.out.println("statusCode = " + statusCode);
//------------------------------------------------------------------------
//        And
//        Print Content Type (should be JSON)

        String contentType = response.contentType();
        System.out.println("contentType = " + contentType);

//        ---------------------------------------------------------------------
//        And
//        Print Status Line (should be HTTP/1.1 200 OK)
        String statusLine = response.statusLine();
        System.out.println("statusLine = " + statusLine);

//        --------------------------------------------------------
//        And
//        Print Connection and Date headers on console
        String connaction = response.header("Connection");
        System.out.println("Connection = " + connaction);

//        -----------------------------------------------
        //Date headers
        String date = response.header("Date");
        System.out.println("date = " + date);
//        ---------------------------------------------------------------
//                And
//        Print all headers on console
        Headers headers = response.headers();
        System.out.println("headers = " + headers);

//    ----------------------------------------------
        //how to get response time
        System.out.println("response.time() = " + response.time());


    }
}
