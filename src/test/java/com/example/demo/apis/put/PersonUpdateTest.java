package com.example.demo.apis.put;

import com.example.demo.apis.BaseDemoApiTest;
import com.example.demo.apis.pojo.PersonInfo;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PersonUpdateTest extends BaseDemoApiTest {

    @Test(enabled = true, description = "Check if user can update username and password")
    void updateUserLoginAndPasswordById() {
        String id = "bbfaf9e5-878e-43f7-a46a-23609b116fa0";
        given()
                .spec(requestSpecification())
                .body(personInfo())
                .log().uri()
                .log().body()
                .when()
                .put("/person/{id}", id)
                .then()
                .log().body()
                .statusCode(200);

    }

    private PersonInfo personInfo() {
        return new PersonInfo(LoremIpsum.getInstance().getTitle(2),
                LoremIpsum.getInstance().getTitle(1));
    }
}
