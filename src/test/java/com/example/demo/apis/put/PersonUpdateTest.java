package com.example.demo.apis.put;

import com.example.demo.apis.BaseDemoApiTest;
import com.example.demo.apis.pojo.PersonInfo;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PersonUpdateTest extends BaseDemoApiTest {

    @Test(enabled = true, description = "Check if user can update username and password")
    void updateUserLoginAndPasswordById() {
        String id = "0adaa0e2-e87c-4b47-b8f7-cf047381899c";
        given()
                .spec(requestSpecification())
                .body(personInfo())
                .log().uri()
                .log().body()
                .when()
                .put("/person/id={id}", id)
                .then()
                .log().body()
                .statusCode(200);

    }

    private PersonInfo personInfo() {
        return new PersonInfo(LoremIpsum.getInstance().getTitle(2),
                LoremIpsum.getInstance().getTitle(1));
    }
}
