/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.service;


import com.mycompany.mavenproject1.domain.User;
import org.springframework.data.repository.CrudRepository;




public interface UserRepository extends CrudRepository<User, Integer>   {

}

