package com.ariman.book.provider;

import com.ariman.book.model.Books;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Biao on 27/10/2017.
 */
public class GetGoogleBookApiTest {

    private GoogleBookApi googleBookApi = new GoogleBookApi();

    @Test
    public void testGetGoogleBooks() throws Exception {
        Books books = this.googleBookApi.getGoogleBooks("Miku", "3");

        assertEquals(books.getItems().get(0).getVolumeInfo().getTitle(), "Hatsune Miku: Acute");
    }
}
