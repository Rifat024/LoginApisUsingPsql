package com.example.demo.apis;

import com.example.demo.BaseApiTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseDemoApiTest extends BaseApiTest {

    @Override
    public String getControllerName() {
        return "/api/v1";
    }

    public RequestSpecification requestSpecification(){
        return new RequestSpecBuilder()
                .addHeader("content-type","application/json")
                .build();
    }
}
