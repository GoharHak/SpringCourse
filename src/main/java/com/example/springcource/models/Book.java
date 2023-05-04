package com.example.springcource.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;
    @NotEmpty(message = "Title could not be empty")
    @Size(min=2,max=100, message = "Title of the books should be from 2 to 100 symbols")
    private String title;

    @NotEmpty(message = "Title could not be empty")
    @Size(min=2,max=100, message = "Name of author should be from 2 to 100 symbols")
    private String author;


    public Book(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Min(value = 1500, message = "Year should be greater than 1500")
    private int year;
}
