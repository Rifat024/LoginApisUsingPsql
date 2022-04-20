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
       String id="f8e5c651-5a21-4796-8c96-ca024bf004ee";
        given()
                .spec(requestSpecification())
                .log().uri()
                .when()
                .get("/person/{id}",id)
                .then()
                .log().body()
                .statusCode(200);
    }
}
