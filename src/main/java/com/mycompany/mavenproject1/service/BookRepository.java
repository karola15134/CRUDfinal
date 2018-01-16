/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.service;

import com.mycompany.mavenproject1.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Karo
 */
public interface BookRepository  extends CrudRepository<Book, Integer>{
    
}
