package HW.HW_Day03;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW3 {

//    Using the
//    https://petstore.swagger.io/ document,
//    write an automation test that finds the number of "pets"
//    with the status "available"
//    and asserts that there are more than 100.


    @Test
    public void testAvailablePetsCount() {
        // Base URL of the PetStore API
        String baseUrl = "https://petstore.swagger.io/v2";

        // Endpoint to get available pets
        String endpoint = "/pet/findByStatus?status=available";

        // Send GET request to get available pets
        Response response = RestAssured.get(baseUrl + endpoint);

        // Check if response code is 200 OK
        Assert.assertEquals(response.getStatusCode(), 200, "Failed to get available pets");

        // Get the count of available pets
        int availablePetsCount = response.jsonPath().getList("").size();

        // Assert that there are more than 100 available pets
        Assert.assertTrue(availablePetsCount > 100, "Expected more than 100 available pets, but found only " + availablePetsCount);
    }
}




