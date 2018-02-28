package pl.alfons.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.alfons.app.services.SmartService;

@Controller
public class MainPageController {

    @Autowired
    SmartService smartService;

    @GetMapping(value = "/")
    public String mainPage(Model model) {
        model.addAttribute("name", smartService.getName());
        return "mainPage";
    }
    @GetMapping(value="/tp")
    public String creatingProject (){
        return "creatingProject";
    }
}
