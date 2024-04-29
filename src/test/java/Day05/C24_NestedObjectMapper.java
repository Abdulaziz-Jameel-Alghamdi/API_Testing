package Day05;

import BaseUrls.JsonPlaseHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;

public class C24_NestedObjectMapper extends JsonPlaseHolderBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/466
        When
            I send GET Request to the url
        Then
            Response body should be like that;
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
            }
*/

    @Test
    public void NestedObjectMapperTest() throws JsonProcessingException {

        // set url
        spes.pathParams("first", "booking", "second", 15);

        // set Expected Data
        String expectedstr = """
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
        BookingPojo expectedData = objectMapper.readValue(expectedstr, BookingPojo.class);

        // send request and get response

        Response response = given(spes).when().get("{first}/{second}");
        response.prettyPrint();

        // do assertion
        BookingPojo actualdata = objectMapper.readValue(response.asString(), BookingPojo.class);

        Assert.assertEquals(expectedData.getFirstname(), actualdata.getFirstname());
        Assert.assertEquals(expectedData.getLastname(), actualdata.getLastname());
        Assert.assertEquals(expectedData.getTotalprice(), actualdata.getTotalprice());
        Assert.assertEquals(expectedData.getDepositpaid(), actualdata.getDepositpaid());
        Assert.assertEquals(expectedData.getBookingdates().getCheckin(), actualdata.getBookingdates().getCheckin());
        Assert.assertEquals(expectedData.getBookingdates().getCheckout(), actualdata.getBookingdates().getCheckout());
        Assert.assertEquals(expectedData.getAdditionalneeds(), actualdata.getAdditionalneeds());
    }
}
