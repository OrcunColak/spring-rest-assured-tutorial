package com.colak.springrestassuredtutorial.controller;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest {

    @LocalServerPort
    private Integer port;

    @Test
    void testSayHello() {
        given()
                .port(port)
                .when()
                .get("/hello")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.TEXT)
                .body(equalTo("Hello, World!"));
    }

    @Test
    void sayHelloWithPathVariable() {
        given()
                .port(port)
                .when()
                .get("/hello/{name}", "John")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.TEXT)
                .body(equalTo("Hello, John!"));
    }

    @Test
    void sayHelloWithRequestParameter() {
        given()
                .port(port)
                .queryParam("name", "Jane")
                .when()
                .get("/hello1")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.TEXT)
                .body(equalTo("Hello, Jane!"));
    }

    @Test
    void testUpdateMessage() {
        String newMessage = "Hello, Post Message!";

        // Update the message with a PUT request
        given()
                .port(port)
                .contentType(ContentType.TEXT)
                .body(newMessage)
                .when()
                .put("/hello")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.TEXT)
                .body(equalTo(newMessage));
    }

    @Test
    void testDeleteMessage() {
        String newMessage = "Hello, Delete Message!";

        // Delete the message with a DELETE request
        given()
                .port(port)
                .contentType(ContentType.TEXT)
                .body(newMessage)
                .when()
                .delete("/hello")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.TEXT)
                .body(equalTo(newMessage));

    }

}