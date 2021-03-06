package com.b7f50.kivee.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class WelcomeController {

    @GetMapping(value = "/")
    public String mainPage() {
        return "welcome";
    }
}
