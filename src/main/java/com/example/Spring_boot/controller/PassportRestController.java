package com.example.Spring_boot.controller;

import com.example.Spring_boot.entities.Passport;
import com.example.Spring_boot.service.PassportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
//@RestController
//@RequestMapping("/api/passports")
public class PassportRestController {

    private final PassportService passportService;

    public PassportRestController(PassportService passportService) {
        this.passportService = passportService;
    }

    @GetMapping(value = "/")
    public String print(ModelMap model) {
        model.addAttribute("passports", passportService.getAllPassports());
        return "passports";
    }

    @GetMapping(value = "/passports")
    public String printPassports(ModelMap model) {
        model.addAttribute("passports", passportService.getAllPassports());
        return "passports";
    }

    @GetMapping(value = "/new")
    public String newPassport(ModelMap model) {
        model.addAttribute("passport", new Passport());
        return "new";
    }

    @PostMapping(value = "/passports")
    public String saveNewPassport(@ModelAttribute("passport") Passport passport) {
        passportService.save(passport);
        return "redirect:/passports";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("passport", passportService.findById(id));
        return "edit";
    }

    @PostMapping(value = "/passports/{id}")
    public String update(@ModelAttribute("passport") Passport passport, @PathVariable("id") long id) {
        passportService.update(id, passport);
        return "redirect:/passports";
    }

    @PostMapping(value = "/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        passportService.delete(id);
        return "redirect:/passports";
    }

    @PostMapping(value = "/delete")
    public String isExistById(@PathVariable Passport passport) {
        passportService.delete(passport.getId());
        return "redirect:/passports";
    }
}
