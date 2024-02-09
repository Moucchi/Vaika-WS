package org.ITU.S5.cloud.backOffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/tests")
public class Test {
    @GetMapping
    public String test() {
        return "index";
    }
}
