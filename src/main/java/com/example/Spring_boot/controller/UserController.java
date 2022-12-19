package com.example.Spring_boot.controller;

import com.example.Spring_boot.entities.Passport;
import com.example.Spring_boot.service.PassportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
//@RestController
//@RequestMapping("/api/users")
public class UserController {

    private final PassportService userService;

    public UserController(PassportService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String print(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/users")
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new Passport());
        return "new";
    }

    @PostMapping(value = "/users")
    public String saveNewUser(@ModelAttribute("user") Passport user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PostMapping(value = "/users/{id}")
    public String update(@ModelAttribute("user") Passport user, @PathVariable("id") long id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @PostMapping(value = "/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @PostMapping(value = "/delete")
    public String isExistById(@PathVariable Passport user) {
        userService.delete(user.getId());
        return "redirect:/users";
    }
}
