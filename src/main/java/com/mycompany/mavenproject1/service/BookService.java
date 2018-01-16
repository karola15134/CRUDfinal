/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.service;

import com.mycompany.mavenproject1.domain.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
        
    @Autowired
    BookRepository bookRepository ;

    public BookService() {
    }
    
     public Book getBookById(Integer id){
           Book b = bookRepository.findOne(id);
           return b;
    }
     
     public Book addBook(Book book){
         
         Book b = new Book();
         b.setAuthor(book.getAuthor());
         b.setTitle(book.getTitle());
         b.setNumberOfPages(book.getNumberOfPages());
         
         return bookRepository.save(b);
         
     }
     
     
     public List<Book> getAllBooks(){
         
         List<Book> listOfBooks;
         listOfBooks = (List<Book>) bookRepository.findAll();
         return listOfBooks;
         
     }
     
     public void deleteBook(Integer id){
         bookRepository.delete(id);
         
     }
    
    public void editTitile(Integer id,String title)
    {
        Book b=bookRepository.findOne(id);
        b.setTitle(title);
        
        bookRepository.save(b);
    }
    
    public void editAuthor(Integer id,String author)
    {
        Book b=bookRepository.findOne(id);
        b.setAuthor(author);
        
        bookRepository.save(b);
    }
    
    public void editPages(Integer id,Integer numOfPages)
    {
        Book b=bookRepository.findOne(id);
        b.setNumberOfPages(numOfPages);
        
        bookRepository.save(b);
    }
}
