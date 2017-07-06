package com.zyzakj.controller;

import com.zyzakj.model.User;
import com.zyzakj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by zyzakj on 2017-06-04.
 */
@Controller
public class DefaultController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home1() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/another")
    public String another(){
        return "another";
    }

    @GetMapping("/events")
    public String events(){
        return "events";
    }

    @GetMapping("/registration")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }


    @PostMapping("/registration")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if(userExists != null){
            bindingResult.rejectValue("email","error.user", "There is already a user registered with the email provided");
        }
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("registration");
        }
        else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfull");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }

}
