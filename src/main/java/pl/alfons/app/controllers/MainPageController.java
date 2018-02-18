package pl.alfons.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping(value = "/")
    public String mainPage(Model model) {
        model.addAttribute("name", "to jest nazwa");
        return "mainPage";
    }
}
