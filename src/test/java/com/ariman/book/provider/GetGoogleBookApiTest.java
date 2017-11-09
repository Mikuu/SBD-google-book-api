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
    public void testGetGoogleBooksTitle() throws Exception {
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
}
