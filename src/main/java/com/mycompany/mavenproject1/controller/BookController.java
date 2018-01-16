/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.domain.Book;
import com.mycompany.mavenproject1.dto.BookDto;
import com.mycompany.mavenproject1.service.BookService;
import java.util.logging.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="front")
public class BookController {
    
      final static Logger logger = Logger.getLogger(BookController.class.getName());
      
      @Autowired
      BookService bookService ;
      
      @Autowired
      private ModelMapper modelMapper;
       
       
      
      
    @RequestMapping("/getBook/{id}")
    @ResponseBody
    public BookDto getUserREST(@PathVariable Integer id){
        
        logger.info(id.toString());
        Book u = bookService.getBookById(id);
        BookDto bookDto = convertToDto(u);
       return bookDto;
    }
       
    private BookDto convertToDto(Book book){
        
        BookDto bookDto = modelMapper.map(book,BookDto.class);
        
        return bookDto;
        
    }
    private Book convertToEntity(BookDto bookDto){
        
        Book book = modelMapper.map(bookDto, Book.class);
        
        return book;
    }
}
