package com.ariman.book.controller;

/**
 * Created by Biao on 28/10/2017.
 */
import com.ariman.book.config.MyConfig;
import com.ariman.book.model.Books;
import com.ariman.book.provider.GoogleBookApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private GoogleBookApi googleBookApi = new GoogleBookApi();

    private MyConfig myConfig = new MyConfig();

    @Autowired
    public void setMyConfig(MyConfig myConfig) {
        this.myConfig = myConfig;
    }

    @RequestMapping("/books")
    public Books books(@RequestParam(value="query", defaultValue="Miku") String query) {
        Books books = googleBookApi.getGoogleBooks(myConfig, query, "3");
        return books;
    }
}
