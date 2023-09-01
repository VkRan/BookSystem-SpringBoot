package com.vikalp.booksystem.model;
import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document(collection = "Book")

public class Book {
    @Id
    @NotNull
    @NotBlank
    private int id;
    @NotNull
    @NotBlank
    private int copiesAvailable;
    @NotNull
    @NotBlank
    private int authorId;
    @NotBlank
    @NotNull
    private String genre;

    public Book(int i, int i1, int i2, String romance) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
