package com.example.eschool_greetgo.WebController;

import com.example.eschool_greetgo.mapper.mapper_main;
import com.example.eschool_greetgo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private mapper_main mapper_main;

    @GetMapping("/api/GreetGO")
    public String showHomePage(){
        return "index";
    }

    @GetMapping(value="/users")
    public String docPage(Model model){
        List<User> listUsers = mapper_main.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }




    //@PostMapping("/users/new")
    @RequestMapping(value = "/users/new", method = { RequestMethod.GET, RequestMethod.POST })
    public String showNewForm(Model model){
        model.addAttribute("user", new User());
        mapper_main.insert((User) model);
        return "user_form";
    }

    /*@PostMapping("/users/new")
    public ResponseEntity<Void> saveOrUpdateCompany(@RequestBody User user) {
        mapper_main.insert(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }*/



    @PostMapping(value = "/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        User user = mapper_main.userById(id);
        model.addAttribute("user", user);
        return "user_form";
    }



    /*@DeleteMapping("/users/delete/{id}")
    public String deleteUser(Integer id){
        mapper_main.delete(id);
        return "success";
    }*/

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Integer id) {
        mapper_main.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}