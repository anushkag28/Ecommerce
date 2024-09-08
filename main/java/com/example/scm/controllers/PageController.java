package com.example.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.scm.entities.User;
import com.example.scm.forms.UserForm;
import com.example.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

    @Controller
    public class PageController {
    
        @Autowired
        private UserService userService;
    
        @GetMapping("/")
        public String index() {
            return "redirect:/home";
        }
    
        @RequestMapping("/home")
        public String home(Model model) {
            System.out.println("Home page handler");
            // sending data to view
            model.addAttribute("name", " Technologies");
            model.addAttribute("youtubeChannel", "Learn with Anushka");
            model.addAttribute("githubRepo", "https://github.com/anushkag28/");
            return "home";
        }
    
        // about route
    
        @RequestMapping("/about")
        public String aboutPage(Model model) {
            model.addAttribute("isLogin", true);
            System.out.println("About page loading");
            return "about";
        }
    
        // services
    
        @RequestMapping("/services")
        public String servicesPage() {
            System.out.println("services page loading");
            return "services";
        }
    
        // contact page
    
        @GetMapping("/contact")
        public String contact() {
            return new String("contact");
        }
    
        // this is showing login page
        @GetMapping("/login")
        public String login() {
            return new String("login");
        }
    
        // registration page
        @GetMapping("/register")
        public String register(Model model) {
    
            UserForm userForm = new UserForm();
           
            model.addAttribute("userForm", userForm);
    
            return "register";
        }
    
        // processing register
    
        @RequestMapping(value = "/do-register", method = RequestMethod.POST)
        public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult,
                HttpSession session) {
            System.out.println("Processing registration");
            // fetch form data
            // UserForm
            System.out.println(userForm);
    
            // validate form data
            if (rBindingResult.hasErrors()) {
                return "register";
            }
    
        
          
            User user = new User();
            user.setName(userForm.getName());
            user.setEmail(userForm.getEmail());
            user.setPassword(userForm.getPassword());
            user.setAbout(userForm.getAbout());
            user.setPhoneNumber(userForm.getPhoneNumber());
            user.setEnabled(false);
            user.setProfilePic(
                    "");
    
            User savedUser = userService.saveUser(user);
    
            System.out.println("user saved :");
    

    
            return "redirect:/register";
        }
    
    }
    