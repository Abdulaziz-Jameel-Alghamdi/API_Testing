package HW.HW_Day02;

import BaseUrls.HomeWork2;
import BaseUrls.HomeWork3;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class HW3 extends HomeWork3 {


    /*
     Given
                https://reqres.in/api/unknown/
     When
          I send GET Request to the URL
     Then
          1)Status code is 200
          2)Print all pantone_values
          3)Print all ids greater than 3 on the console
            Assert that there are 3 ids greater than 3
          4)Print all names whose ids are less than 3 on the console
            Assert that the number of names whose ids are less than 3 is 2
  */
    @Test
    public void testH() {

        spes.pathParams("first", "api"
                , "second", "unknown");

        Response response = given(spes).when().get("{first}/{second}");
        response.prettyPrint();

        JsonPath json = response.jsonPath();
//        1)Status code is 200
        response.then().statusCode(200);
//        2)Print all pantone_values

        String pantoneValues = response.jsonPath().getString("{it.data}.pantone_value");
        System.out.println("Pantone Values: " + pantoneValues);

        //        3)Print all ids greater than 3 on the console
//        Assert that there are 3 ids greater than 3
        List<Integer> idgreterThan3 = json.getList("findAll{it.data}.id");
        System.out.println("idgreterThan3 = " + idgreterThan3);
        assertTrue(idgreterThan3.size() > 3);
//        4)Print all names whose ids are less than 3 on the console
//        Assert that the number of names whose ids are less than 3 is 2


    }

}
