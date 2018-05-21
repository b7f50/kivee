package pl.alfons.app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MainPageController {

    @GetMapping(value = "/")
    public String mainPage() {
        return "mainPage";
    }
}
