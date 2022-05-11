package com.example.demo.apis.delete;

import com.example.demo.apis.BaseDemoApiTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PersonDeleteTest extends BaseDemoApiTest {

    @Test(enabled = true, description = "Check if user can delete username and password using id")
    void deletePersonLoginAndPasswordById() {
        String id = "0c71a301-333a-478d-b9ff-0db8fbe44517";
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
