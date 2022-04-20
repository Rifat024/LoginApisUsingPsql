package com.example.demo.apis.post;

import com.example.demo.apis.BaseDemoApiTest;
import com.example.demo.apis.pojo.PersonInfo;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PersonPostTest extends BaseDemoApiTest {
    @Test(enabled = true, description = "Check if user can post username and password")
    void postUserLoginAndPassword() {
        given()
                .spec(requestSpecification())
                .body(personInfo())
                .log().uri()
                .log().body()
                .when()
                .post("/person")
                .then()
                .log().body()
                .statusCode(200);
    }


    private PersonInfo personInfo() {
        return new PersonInfo(LoremIpsum.getInstance().getTitle(2),
                LoremIpsum.getInstance().getTitle(1));
    }
}
