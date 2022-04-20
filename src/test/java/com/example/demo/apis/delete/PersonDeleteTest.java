package com.example.demo.apis.delete;

import com.example.demo.apis.BaseDemoApiTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PersonDeleteTest extends BaseDemoApiTest {

    @Test(enabled = true, description = "Check if user can delete username and password using id")
    void deletePersonLoginAndPasswordById() {
        String id = "0adaa0e2-e87c-4b47-b8f7-cf047381899c";
        given()
                .spec(requestSpecification())
                .log().uri()
                .when()
                .delete("/person/id={id}", id)
                .then()
                .log().body()
                .statusCode(200);
    }
}
