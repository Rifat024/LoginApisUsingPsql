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
        String id = "bbfaf9e5-878e-43f7-a46a-23609b116fa0";
        given()
                .spec(requestSpecification())
                .log().uri()
                .when()
                .get("/person/{id}", id)
                .then()
                .log().body()
                .statusCode(200);
    }
}
