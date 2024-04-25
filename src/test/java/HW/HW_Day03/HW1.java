package HW.HW_Day03;

import BaseUrls.JsonPlaseHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class HW1 extends JsonPlaseHolderBaseUrl {


     /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */
        @Test
        public void testPostRequest () {
            // Given
            String url = "https://reqres.in/api/users";
            Map<String, String> requestBody = Map.of(
                    "name", "morpheus",
                    "job", "leader"
            );

            // When
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .post(url);

            // Then
            assertEquals(response.statusCode(), 201);

            Map<String, Object> responseBody = response.body().as(Map.class);
            assertNotNull(responseBody.get("id"));
            assertNotNull(responseBody.get("createdAt"));
            assertEquals(responseBody.get("name"), "morpheus");
            assertEquals(responseBody.get("job"), "leader");
        }
    }






