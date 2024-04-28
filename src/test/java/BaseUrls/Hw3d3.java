package BaseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;


public class Hw3d3 {

    protected RequestSpecification spes;
    @BeforeMethod
    public void setUp() {

        spes = new RequestSpecBuilder()
                .setBaseUri("https://automationexercise.com")
                .setContentType(ContentType.JSON)
                .build();

    }
}
