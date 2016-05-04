package com.ted.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ted.controller.form.FormTest;

@Controller
public class FormController {
	@RequestMapping(value="/form", method=RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("formTest", new FormTest());
        return "form_input";
    }

    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String form(@ModelAttribute FormTest formTest, Model model) {
        model.addAttribute("formTest", formTest);
        return "form_output";
    }
}
