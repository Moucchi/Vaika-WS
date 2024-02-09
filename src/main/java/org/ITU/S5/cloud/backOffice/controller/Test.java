package org.ITU.S5.cloud.backOffice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tests")
public class Test {
    @GetMapping
    public String test() {
        return "Aonaaaaaa";
    }
}
