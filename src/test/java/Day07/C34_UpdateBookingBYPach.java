package Day07;

import BaseUrls.CreateBooking;
import Utilities.ObjectMapperUtilities;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Objects;


import static Day07.C31_CreateBooking.bookingid;
import static Utilities.ObjectMapperUtilities.convertJsonToJava;
import static io.restassured.RestAssured.given;

public class C34_UpdateBookingBYPach extends CreateBooking {

                /*
    Given
        url: "https://restful-booker.herokuapp.com/booking/:id
    And
        body:     {
                    "firstname" : "Tom",
                    "lastname" : "Hanks",
                }

    When
        user send patch request
    Then
        verify status code is 200
    And
        response is like :
                              {
                        "firstname" : "Tom",
                        "lastname" : "Hanks",
                        "totalprice" : 111,
                        "depositpaid" : true,
                        "bookingdates" : {
                            "checkin" : "2018-01-01",
                            "checkout" : "2019-01-01"
                        },
                        "additionalneeds" : "Lunch"
                    }
     */

    @Test(dependsOnMethods = {"Day07.C31_CreateBooking.createBookingTest"})
    public void updateByPatchTest() {

        // Set Expected Data
        spes.pathParams("first", "booking"
                , "second", bookingid);

        String payloadstr = """
                {
                                    "firstname" : "Tom",
                                    "lastname" : "Hanks"
                                }""";

        Map<String, Objects> payload = convertJsonToJava(payloadstr, Map.class);

        Response response = given(spes).body(payload).when().patch("{first}/{second}");
        response.prettyPrint();


    }
}
