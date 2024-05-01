package BaseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import static Utilities.AuthenticationRestful.getToken;

public class CreateBooking {


    protected RequestSpecification spes;

    @BeforeMethod
    public void setUp() {

        spes = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .addHeader("Cookie", "token=" +getToken())
                .setContentType(ContentType.JSON)
                .build();

    }


}

