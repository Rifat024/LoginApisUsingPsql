package com.example.demo.apis.delete;

import com.example.demo.apis.BaseDemoApiTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PersonDeleteTest extends BaseDemoApiTest {

    @Test(enabled = true, description = "Check if user can delete username and password using id")
    void deletePersonLoginAndPasswordById() {
        String id = "bbfaf9e5-878e-43f7-a46a-23609b116fa0";
        given()
                .spec(requestSpecification())
                .log().uri()
                .when()
                .delete("/person/{id}", id)
                .then()
                .log().body()
                .statusCode(200);
    }
}
