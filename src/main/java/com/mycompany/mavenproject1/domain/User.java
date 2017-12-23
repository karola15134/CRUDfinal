/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.domain;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer id;

    @NotNull
    @Size(min=2, max=30)
    private String name;

    @Size(min=2, max=30)
    private String email;

    @OneToMany(mappedBy="user" , cascade = CascadeType.ALL)
    private Set<Item> items = new HashSet<>();

    public User(){
       
    }
   
    public Integer getId() {
        return id;  
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
    
    public void setItem(Item item){
        this.items.add(item);
    }
    
   
}