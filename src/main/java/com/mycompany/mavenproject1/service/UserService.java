/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.service;


import com.mycompany.mavenproject1.domain.Item;
import com.mycompany.mavenproject1.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public UserService(){
        
    }
    
    public User getUserById(Integer id){
           User u = userRepository.findOne(id);
           return u;
    }
    
    
    
    public User addUser(User user){
        
        User u = new User();
        Item i = new Item("item",u);
        
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setItem(i);
        
       return userRepository.save(u);

    }
    
    public List<User> getAllUsers(){
        
        List<User> users;
        users = (List<User>) userRepository.findAll();
        return users;
    }
    
    public void deleteUser(Integer id){
        userRepository.delete(id);
    }
    
    public void editUser(Integer id,String name,String email){
        
         User u = userRepository.findOne(id);
         
        if (name != null && email == null) {
            u.setName(name);
        } else if (name == null && email != null) {
            u.setEmail(email);
        } else if (name != null && email != null) {
            u.setName(name);
            u.setEmail(email);
        }
        userRepository.save(u);
    }
    
    
}