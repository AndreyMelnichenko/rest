package com.hashcode;

import com.hashcode.model.User;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UserTest extends TestBase {

    @Test
    public void testGetSingleUser(){
        User actualPerson = given()
                .spec(spec)
                .expect()
                .statusCode(200)
                .when()
                .get("single-user/1")
                .as(User.class);
        assertEquals("test@hascode.com", actualPerson.getEmail());
    }
}
