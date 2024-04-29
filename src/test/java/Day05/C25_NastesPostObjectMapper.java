package Day05;

import BaseUrls.JsonPlaseHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;

import static io.restassured.RestAssured.given;

public class C25_NastesPostObjectMapper extends JsonPlaseHolderBaseUrl {

           /*
   Given
       1) https://restful-booker.herokuapp.com/booking
       2) {
               "firstname": "Jane",
               "lastname": "Doe",
               "totalprice": 111,
               "depositpaid": true,
               "bookingdates": {
                   "checkin": "2018-01-01",
                   "checkout": "2019-01-01"
               },
               "additionalneeds": "Extra pillows please"
           }
   When
       I send POST Request to the Url
   Then
       Status code is 200
       And response body should be like
       {
           "bookingid": 2243,
           "booking":{
                       "firstname": "Jane",
                       "lastname": "Doe",
                       "totalprice": 111,
                       "depositpaid": true,
                       "bookingdates": {
                           "checkin": "2018-01-01",
                           "checkout": "2019-01-01"
                       },
                       "additionalneeds": "Extra pillows please"
                   }
            }
*/

    @Test
    public void NastesPostObjectMapperTest() throws JsonProcessingException {

        // set Url
        spes.pathParam("first", "booking");

        String expectedStr = """
                {
                               "firstname": "Jane",
                               "lastname": "Doe",
                               "totalprice": 111,
                               "depositpaid": true,
                               "bookingdates": {
                                   "checkin": "2018-01-01",
                                   "checkout": "2019-01-01"
                               },
                               "additionalneeds": "Extra pillows please"
                           }""";

        ObjectMapper objectMapper = new ObjectMapper();
        BookingPojo payload = objectMapper.readValue(expectedStr, BookingPojo.class);

        // send request and get response
        Response response = given(spes).body(payload).when().post("{first}");
        response.prettyPrint();

        // do assertion

        BookingResponsePojo actualdata = objectMapper.readValue(response.asString(), BookingResponsePojo.class);

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(payload.getFirstname(), actualdata.getBooking().getFirstname());
        Assert.assertEquals(payload.getLastname(), actualdata.getBooking().getLastname());
        Assert.assertEquals(payload.getTotalprice(), actualdata.getBooking().getTotalprice());
        Assert.assertEquals(payload.getBookingdates().getCheckin(), actualdata.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(payload.getBookingdates().getCheckout(), actualdata.getBooking().getBookingdates().getCheckout());


    }
}
