package com.example.demo.apis.delete;

import com.example.demo.apis.BaseDemoApiTest;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class PersonDeleteTest extends BaseDemoApiTest {

        @Test(enabled = true,description = "Check if user can delete username and password using id")
        void deletePersonLoginAndPasswordById(){
                String id="f8e5c651-5a21-4796-8c96-ca024bf004ee";
                given()
                        .spec(requestSpecification())
                        .log().uri()
                        .when()
                        .delete("/person/{id}",id)
                        .then()
                        .log().body()
                        .statusCode(200);
        }
        }
