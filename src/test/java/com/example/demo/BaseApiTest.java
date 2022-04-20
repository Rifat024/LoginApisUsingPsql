package com.example.demo;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public abstract class BaseApiTest {

    public abstract String getControllerName();

    @BeforeClass
    protected void setup() {
        // RestAssured.baseURI = "localhost";
        //  RestAssured.port = 8080;
        RestAssured.basePath = getControllerName();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}


