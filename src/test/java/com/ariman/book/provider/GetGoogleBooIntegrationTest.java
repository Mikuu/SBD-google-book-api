package com.ariman.book.provider;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.startsWith;

/**
 * Created by Biao on 27/10/2017.
 */
public class GetGoogleBooIntegrationTest {

    private String baseUrl = "http://localhost:8080/books";

    private static WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8001).usingFilesUnderDirectory("mock/mock-data"));

    @BeforeClass
    public static void setup() {
        wireMockServer.start();
    }

    @AfterClass
    public static void teardown() {
        wireMockServer.shutdown();
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
