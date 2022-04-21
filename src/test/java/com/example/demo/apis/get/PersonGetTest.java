package com.example.demo.apis.get;

import com.example.demo.apis.BaseDemoApiTest;
import com.example.demo.apis.pojo.PersonInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PersonGetTest extends BaseDemoApiTest {

    @Test(enabled = true, description = "Check if user can get all person username and password ")
    void getAllUserLoginAndPassword() {
       List<PersonInfo> personInfoList= given()
                .spec(requestSpecification())
                .log().uri()
                .when()
                .get("/person")
                .then()
                .log().body()
                .statusCode(200)
               .extract().jsonPath().getList("",PersonInfo.class);

       for (int i=0;i< personInfoList.size();i++){
           Assert.assertNotNull(personInfoList.get(i).getName());
           Assert.assertNotNull(personInfoList.get(i).getPassword());
       }
    }

    @Test(enabled = true, description = "Check if user can get username and password using id")
    void getUserLoginAndPasswordById() {
        String id = "0adaa0e2-e87c-4b47-b8f7-cf047381899c";
       List<PersonInfo> personInfoList= given()
                .spec(requestSpecification())
                .log().uri()
                .when()
                .get("/person/id={id}", id)
                .then()
                .log().body()
                .statusCode(200)
               .extract().jsonPath().getList("",PersonInfo.class);

       for (int i=0; i<personInfoList.size();i++){
           Assert.assertEquals(personInfoList.get(i).getId(),id);
       }

    }
}
