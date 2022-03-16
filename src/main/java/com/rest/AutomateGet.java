package com.rest;
import io.restassured.config.LogConfig;
import org.apache.http.Header;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.config;
import static  io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class AutomateGet {





    @org.testng.annotations.Test
    public void request_response_logging(){

        List<String> list= new ArrayList<>();
        list.add("x-api-key");
        list.add("Accept");

        given().
                baseUri("https://api.getpostman.com").
                header("x-api-key","PMAK-61ed7117c5b3ad00460f540f-391c87b55c7716113bcef605386e401409").
                config(config.logConfig(LogConfig.logConfig().blacklistHeaders(list))).
                log().all().
    //log().
        when().
                get("/workspaces").
        then().
               // log().ifError().
                assertThat().
                statusCode(200).
                body("workspaces.name",hasItems("Test","My Workspace","TEstingDevops"),
                        "workspaces.type",hasItems("personal"));
    }
}

