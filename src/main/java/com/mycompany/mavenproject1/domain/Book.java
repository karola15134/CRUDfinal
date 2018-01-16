/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="book")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer id;
    
    @NotNull
    @Size(min=2, max=50)
    private String title;
    
    @NotNull
    @Size(min=2, max=50)
    private String author;
    
    @NotNull
    private Integer numberOfPages;
    
   

    public Book(Integer id, String title, String author, Integer numberOfPages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    
    
    
}
