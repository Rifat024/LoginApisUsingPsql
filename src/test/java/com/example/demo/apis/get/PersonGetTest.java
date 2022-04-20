package com.example.demo.apis.get;

import com.example.demo.apis.BaseDemoApiTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PersonGetTest extends BaseDemoApiTest {

    @Test(enabled = true, description = "Check if user can get all person username and password ")
    void getAllUserLoginAndPassword() {
        given()
                .spec(requestSpecification())
                .log().uri()
                .when()
                .get("/person")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test(enabled = true, description = "Check if user can get username and password using id")
    void getUserLoginAndPasswordById() {
        String id = "0adaa0e2-e87c-4b47-b8f7-cf047381899c";
        given()
                .spec(requestSpecification())
                .log().uri()
                .when()
                .get("/person/id={id}", id)
                .then()
                .log().body()
                .statusCode(200);
    }
}
