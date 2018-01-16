/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;


import com.mycompany.mavenproject1.domain.User;
import com.mycompany.mavenproject1.dto.UserDto;
import com.mycompany.mavenproject1.service.UserService;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="back")
public class UserController {

    final static Logger logger = Logger.getLogger(UserController.class.getName());
  

    @Autowired
    private UserService userService;
    
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/addUser")
    public String addUser(ModelMap model) {  
        
        UserDto userDto = convertToDto(new User());
        model.addAttribute("user",userDto);
        return "addUser";
    }

    @PostMapping(value = "/addUser")
    public String addUserForm(@ModelAttribute("user") @Valid UserDto userDto , BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "addUser";
        }
        
        User user = convertToEntity(userDto);
        userService.addUser(user);
        return "saved";
    }

    @GetMapping("/showUsers")
    public String getAllUsers(ModelMap model) {

        List<User> listOfUsers = userService.getAllUsers();
        List<UserDto> listOfDtoUsers = listOfUsers.stream().map(user -> convertToDto(user))
                .collect(Collectors.toList());
        
        model.put("users", listOfDtoUsers);
        return "showUsers";
    }

    @GetMapping("/removeUser")
    public String removeUser(@RequestParam Integer id) {

        userService.deleteUser(id);
        return "remove";
    }

    @GetMapping("/editUser")
    public String editUser(@RequestParam Integer id, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        
        userService.editUser(id, name, email);
        return "edited";
    }
    
    @RequestMapping("/getUser/{id}")
    @ResponseBody
    public UserDto getUserREST(@PathVariable Integer id){
        
        User u = userService.getUserById(id);
        UserDto userDto = convertToDto(u);
       return userDto;
    }
   @RequestMapping("/getUsers")
   @ResponseBody
   public List<UserDto> getUsersREST(){
        List<User> listOfUsers = userService.getAllUsers();
        List<UserDto> listOfDtoUsers = listOfUsers.stream().map(user -> convertToDto(user))
                .collect(Collectors.toList());
        return listOfDtoUsers;
       
   }
   
   @PostMapping("/addUserREST")
   @ResponseBody
   public  User addUserRest(@RequestBody UserDto userDto){
       
   User user = convertToEntity(userDto);
        
     return  userService.addUser(user);
       
   }
   
   @GetMapping("showUsersQ")
   public String showUserQ()
   {
       return "showUsersJQ";
   }
    
    private UserDto convertToDto(User user){
        
        UserDto userDto = modelMapper.map(user,UserDto.class);
        
        return userDto;
        
    }
    private User convertToEntity(UserDto userDto){
        
        User user = modelMapper.map(userDto, User.class);
        
        return user;
    }
}