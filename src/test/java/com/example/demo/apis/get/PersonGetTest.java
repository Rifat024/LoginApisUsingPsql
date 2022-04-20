package com.example.demo.apis.get;

import com.example.demo.apis.BaseDemoApiTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PersonGetTest extends BaseDemoApiTest {

    @Test
     void getAllUserLoginAndPassword(){
        given()
                .spec(requestSpecification())
                .log().uri()
                .when()
                .get("/person")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    void getUserLoginAndPasswordById(){
        given()
                .spec(requestSpecification())
                .log().uri()
                .when()
                .get("/person/0c71a301-333a-478d-b9ff-0db8fbe44517")
                .then()
                .log().body()
                .statusCode(200);
    }
}
