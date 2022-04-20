package com.example.demo.apis.put;

import com.example.demo.apis.BaseDemoApiTest;
import com.example.demo.apis.pojo.PersonInfo;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PersonUpdateTest extends BaseDemoApiTest {

    @Test
    void updateUserLoginAndPasswordById(){
        String id="f8e5c651-5a21-4796-8c96-ca024bf004ee";
        given()
                .spec(requestSpecification())
                .body(personInfo())
                .log().uri()
                .log().body()
                .when()
                .put("/person/{id}",id)
                .then()
                .log().body()
                .statusCode(200);

    }

    private PersonInfo personInfo(){
        return new PersonInfo(LoremIpsum.getInstance().getTitle(2),
                LoremIpsum.getInstance().getTitle(1) );
    }
}
