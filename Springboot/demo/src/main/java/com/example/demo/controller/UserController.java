package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;




@RestController

@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserRepository userrepo_obj;


    @GetMapping("/getUser")
    public List<UserModel> index(Model model){
        //List<UserModel> listofusers=userrepo_obj.findAll();
        //return (UserModel) (model.addAttribute("kesav", listofusers));
        // return "welcome";
        return userrepo_obj.findAll();
    }

  

    @PostMapping("/createUser")
    public String createUSer(UserModel usernew,Model model){
        userrepo_obj.save(usernew);
        System.out.println("Data Saved Successfully");
        List<UserModel> listofusers=userrepo_obj.findAll();
        model.addAttribute("kesav", listofusers);
       return "welcome";
    }

    // @PostMapping("/createUser")
    // public String createUser(@RequestBody UserModel userNew) {
    //     userrepo_obj.save(userNew);
    //     System.out.println("Data Saved Successfully");

    //     // You can return a response, or perform additional processing as needed
    //     return "User created successfully";
    // }
    
}
