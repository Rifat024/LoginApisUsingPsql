package com.example.demo.apis.put;

import com.example.demo.apis.BaseDemoApiTest;
import com.example.demo.apis.pojo.PersonInfo;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PersonUpdateTest extends BaseDemoApiTest {

    @Test
    void updateUserLoginAndPasswordById(){
        given()
                .spec(requestSpecification())
                .body(personInfo())
                .log().uri()
                .log().body()
                .when()
                .put("/person/13fa0d3e-a3f6-4a26-9551-3f6ad1fcad07")
                .then()
                .log().body()
                .statusCode(200);

    }

    private PersonInfo personInfo(){
        return new PersonInfo(LoremIpsum.getInstance().getTitle(2),
                LoremIpsum.getInstance().getTitle(1) );
    }
}
