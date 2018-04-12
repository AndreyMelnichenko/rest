package com.hashcode;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UserTest extends TestBase {

    @Test
    public void testGetSingleUser(){
       /* SingleUser actualPerson = given()
                .spec(spec)
                .expect()
                .statusCode(200)
                .when()
                .get("single-user/1")
                .as(SingleUser.class);
        assertEquals("test@hascode.com", actualPerson.getEmail());*/
    }
}
