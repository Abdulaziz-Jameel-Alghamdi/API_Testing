package BaseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class JsonPlaseHolderBaseUrl {

    protected RequestSpecification spes;

    @BeforeMethod
    public void setUp() {

        spes = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();

    }

}
