package com.music;

import com.hashcode.TestBase;
import guru.nidi.ramltester.RamlDefinition;
import guru.nidi.ramltester.RamlLoaders;
import guru.nidi.ramltester.restassured3.RestAssuredClient;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static guru.nidi.ramltester.junit.RamlMatchers.validates;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MusicTest extends TestBase {

    @Test
    public void music(){
        RestAssured.baseURI="http://localhost:8080";

        RamlDefinition api = RamlLoaders.fromClasspath().load("api2.raml");
 //       assertThat(api.validate(), validates());

        RestAssuredClient assuredClient = api.failFast().createRestAssured3();

        assuredClient.given().queryParam("id","1")
                .expect()
                .body("name", equalTo("Prodigy"))
                .when()
                .get("music");
    }
}
