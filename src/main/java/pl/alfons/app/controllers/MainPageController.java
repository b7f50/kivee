package pl.alfons.app.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.alfons.app.services.SmartService;

@Slf4j
@Controller
public class MainPageController {

    //TODO remove dummy service
    @Autowired
    SmartService smartService;

    @GetMapping(value = "/")
    public String mainPage(Model model) {
        model.addAttribute("name", smartService.getName());
        log.debug("lombok debug: " + smartService.getName());
        return "mainPage";
    }


}
