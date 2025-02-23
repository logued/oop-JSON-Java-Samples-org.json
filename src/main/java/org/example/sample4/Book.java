package org.example.sample4;                //Feb 2025

import java.util.Arrays;

public class Book {

    private String title;
    private String isbn;
    private double price;
    private long year;
    private boolean recommended;
    private String[] authors;

    public Book() {
    }

    public Book(String title, String isbn, double price, long year, boolean recommended, String[] authors) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.year = year;
        this.recommended = recommended;
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", recommended=" + recommended +
                ", authors=" + Arrays.toString(authors) +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }
}