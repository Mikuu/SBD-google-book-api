package com.ariman.book.provider;

import com.ariman.book.config.MyConfig;
import com.ariman.book.model.Books;
import org.springframework.web.util.UriTemplate;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by Biao on 27/10/2017.
 */
public class GoogleBookApi {

    private RestTemplate restTemplate = new RestTemplate();

    public Books getGoogleBooks(MyConfig myConfig, String query, String maxResults) {
        String endpoint = myConfig.getGoogleApiUrl()+myConfig.getGoogleApiPath();

        System.out.println("FBI >> "+endpoint);
        URI uri = new UriTemplate(endpoint).expand(query, maxResults);

        Books books = restTemplate.getForObject(uri, Books.class);

        return books;
    }
}
