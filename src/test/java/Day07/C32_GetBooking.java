package Day07;

import BaseUrls.CreateBooking;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;


import static Day07.C31_CreateBooking.bookingid;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C32_GetBooking extends CreateBooking {
    /*
        Given
        url: "https://restful-booker.herokuapp.com/booking/1
        When
        user send GET request
        Then
        verify status code is 200
        And
        response is like :
        {
            "bookingid": 1,
                "booking": {
            "firstname": "Jim",
                    "lastname": "Brown",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                "checkin": "2018-01-01",
                        "checkout": "2019-01-01"
            },
            "additionalneeds": "Breakfast"
        }
        }
    */
    @Test(dependsOnMethods = {"Day07.C31_CreateBooking.createBookingTest"})
    public void GetBookingTest() {

        spes.pathParams("first", "booking", "second", bookingid);

        // send request and get response

        Response response = given(spes).when().get("{first}/{second}");
        response.prettyPrint();

        BookingPojo actualData = response.as(BookingPojo.class);
        BookingDatesPojo bookingDates = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Jim", "Brown", 111, true, bookingDates, "Breakfast");

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
