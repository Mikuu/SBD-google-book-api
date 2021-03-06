package com.ariman.book.provider;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by Biao on 27/10/2017.
 */
public class GetGoogleBookApiTest {

    private String baseUrl = "http://localhost:8080/books";

    @Test
    public void testGetGoogleBooksSelfLink() throws Exception {
        given()
                .param("query", "Miku")
        .when()
                .get(baseUrl)
        .then()
                .assertThat()
                .statusCode(200)
                .body("items[0].selfLink", startsWith("https://www.googleapis.com/books/"));
    }

    @Test
    public void testGetGoogleBooksTitle1() throws Exception {
        given()
                .param("query", "Nanoha")
        .when()
                .get(baseUrl)
        .then()
                .assertThat()
                .statusCode(200)
                .body("items[0].volumeInfo.title", containsString("Nanoha"));
    }

    @Test
    public void testGetGoogleBooksTitle2() throws Exception {
        given()
                .param("query", "Selenium")
        .when()
                .get(baseUrl)
        .then()
                .assertThat()
                .statusCode(200)
                .body("items[0].volumeInfo.title", containsString("Selenium"));
    }

    @Test
    public void testGetGoogleBooksTitle3() throws Exception {
        given()
                .param("query", "Cucumber")
        .when()
                .get(baseUrl)
        .then()
                .assertThat()
                .statusCode(200)
                .body("items[0].volumeInfo.title", containsString("Cucumber"));
    }

    @Test
    public void testGetGoogleBooksTitle4() throws Exception {
        given()
                .param("query", "Python")
        .when()
                .get(baseUrl)
        .then()
                .assertThat()
                .statusCode(200)
                .body("items[0].volumeInfo.title", containsString("Python"));
    }

    @Test
    public void testGetGoogleBooksTitle5() throws Exception {
        given()
                .param("query", "Java")
        .when()
                .get(baseUrl)
        .then()
                .assertThat()
                .statusCode(200)
                .body("items[0].volumeInfo.title", containsString("Java"));
    }
}
