/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {
    
    private Integer id;

    
    @NotNull
    @Size(min=2, max=30)
    private String name;

    @Size(min=2, max=30)
    private String email;

    public UserDto() {
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
