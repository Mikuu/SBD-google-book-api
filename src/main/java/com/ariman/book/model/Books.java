package com.ariman.book.model;

import java.util.ArrayList;

/**
 * Created by Biao on 27/10/2017.
 */
public class Books {
    private String kind;
    private Integer totalItems;
    private ArrayList<Book> items = new ArrayList<Book>();

    public ArrayList<Book> getItems() {
        return items;
    }

    public void setItems(ArrayList<Book> items) {
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

}
