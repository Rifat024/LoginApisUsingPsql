package com.example.demo.apis.delete;

import com.example.demo.apis.BaseDemoApiTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PersonDeleteTest extends BaseDemoApiTest {

        @Test
        void deletePersonLoginAndPasswordById(){
                given()
                        .spec(requestSpecification())
                        .log().uri()
                        .when()
                        .delete("/person/f8e5c651-5a21-4796-8c96-ca024bf004ee")
                        .then()
                        .log().body()
                        .statusCode(200);
        }
        }
