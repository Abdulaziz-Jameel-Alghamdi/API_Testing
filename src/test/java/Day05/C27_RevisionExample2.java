package Day05;

import BaseUrls.GorestrBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C27_RevisionExample2 extends GorestrBaseUrl {

    /*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Abhaidev Kaur", "Fr. Deenabandhu Adiga", "Akshita Singh DC" are among the users -> Data may change
        And
            The female users are less than or equals to male users -> Data may change
*/
    @Test
    public void test() {

        spes.pathParam("first", "users");

        // Send request and get response:
        Response response = given(spes).when().get("{first}");
        response.prettyPrint();

//        response
//                .then()
//                .body("meta.pagination.limit",equalTo(10)
//                ).body("meta.pagination.current",equalTo("https://gorest.co.in/public/v1/users?page=1")
//                ).body("data.name",hasSize(10))
//                .body("data.status",equalTo("active"))
//
//        ;

        JsonPath json = response.jsonPath();
//Then
//        The value of "pagination limit" is 10
        int limit = json.getInt("meta.pagination.limit");
        System.out.println("limit = " + limit);
        Assert.assertTrue(limit == 10);

        //And
        //        The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        String currentlink = json.getString("meta.pagination.links.current");
        System.out.println("currentlink = " + currentlink);
        Assert.assertEquals(currentlink, "https://gorest.co.in/public/v1/users?page=1");

        //        And
        //        The number of users should  be 10
        List<String> numberOfUsers = json.getList("data.name");
        System.out.println("numberOfUsers = " + numberOfUsers);
        Assert.assertTrue(numberOfUsers.size() == 10);

//        And
//        We have at least one "active" status
        String status = json.getString("data.status");
        System.out.println("status = " + status);
        Assert.assertTrue(status.contains("active"));

//        And
//        "Radha Mukhopadhyay", "Devagya Joshi", "Goswamee Mishra" are among the users -> Data may change

        Assert.assertTrue(numberOfUsers.contains("Radha Mukhopadhyay"));
        Assert.assertTrue(numberOfUsers.contains("Devagya Joshi"));
        Assert.assertTrue(numberOfUsers.contains("Lakshminath Rana"));

        System.out.println("------------------------------------------------------");
//                And
//        The female users are less than or equals to male users -> Data may change

        List<Object> female = json.getList("data.findAll{it.gender=='female'}");
        System.out.println("female = " + female);

        List<Object> male = json.getList("data.findAll{it.gender=='male'}");
        System.out.println("male = " + male);

        int sizfemale = female.size();
        int sizemale = male.size();
        Assert.assertTrue(sizfemale >= sizemale);


//        System.out.println("gender = " + gender);
//        Assert.assertTrue(gender.contains("male"));
//        Assert.assertTrue(gender.contains("female"));
//
//        boolean male = gender.contains("male");
//
//        boolean female = gender.contains("female");
//
//        Assert.assertTrue(female>=male);


//        List<Object> female = json.getList("data.gender");
//
//        System.out.println("female = " + female);
//


//        Assert.assertTrue(female.size() >= male.size());


    }
}
