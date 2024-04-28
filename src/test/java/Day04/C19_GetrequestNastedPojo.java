package Day04;

import BaseUrls.JsonPlaseHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C19_GetrequestNastedPojo extends JsonPlaseHolderBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking/243
    When
        I send GET Request to the url
    Then
        Status code should be 200
        Response body should be like that;
            {
                "firstname": "John",
                "lastname": "Smith",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
                },
                "additionalneeds": "Breakfast"
            }
 */
    @Test
    public void test() {
        // Set Url
        spes.pathParams("first", "booking"
                , "second", 451);

        // Set Expected data
        BookingDatesPojo bookingDates = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("John", "Smith", 111, true, bookingDates, "Breakfast");


        // Send request get response
        Response response = given(spes).when().get("{first}/{second}");
        response.prettyPrint();

        // Do Assertions
        BookingPojo actualData = response.as(BookingPojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getBookingdates().getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(bookingDates.getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(bookingDates.getCheckout(), actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());

    }
}