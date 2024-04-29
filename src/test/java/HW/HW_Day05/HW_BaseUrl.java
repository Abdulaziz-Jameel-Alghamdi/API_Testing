package HW.HW_Day05;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class HW_BaseUrl {

    protected RequestSpecification spes;

    @BeforeMethod
    public void setUp() {

        spes = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/")
                .setContentType(ContentType.JSON)
                .build();

    }
}


