package com.hashcode;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class TestBase {
    protected RequestSpecification spec;
    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> T readExpectedResult(String file, Class<T> classType) throws IOException {
        URL resource = getClass().getClassLoader().getResource(file);
        File userJSON;
        if(resource!=null){
            userJSON = new File(resource.getFile());
        }else {
            throw new FileNotFoundException("File not found: " + file);
        }
        return objectMapper.readValue(userJSON, classType);
    }
    @BeforeClass
    public void setUp(){
        String baseURL = "https://reqres.in/api/users/4";
        spec = new RequestSpecBuilder()
                .setBaseUri(baseURL)
                //.setContentType(ContentType.XML)
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}
