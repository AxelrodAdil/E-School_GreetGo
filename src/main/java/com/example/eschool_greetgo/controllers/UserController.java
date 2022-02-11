package com.example.eschool_greetgo.controllers;

import com.example.eschool_greetgo.model.User;
import com.example.eschool_greetgo.exception.UserNotFoundException;
import com.example.eschool_greetgo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping(value = "/users")
    public String showUserList(Model model){
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model){
        model.addAttribute("user", new User());
        return "user_form";
    }

    //@RequestMapping(name = "/users/save", method = RequestMethod.POST)
    @PostMapping("/users/save")
    public String saveUser(User user){
        service.save(user);
        return "success";  // also we can use "redirect:/users"
    }

    @GetMapping(value = "/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            User user = service.get(id);
            model.addAttribute("user", user);
            return "user_form";
        } catch (UserNotFoundException e){
            ra.addFlashAttribute("message", "GJ");
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            service.delete(id);
        } catch (UserNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/users";
    }
}