package com.sammal.plantation.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/abc")
    public String abc() {
        return "abc";
    }
}
