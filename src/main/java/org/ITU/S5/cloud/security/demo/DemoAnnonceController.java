package org.ITU.S5.cloud.security.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/annonce-demo")
public class DemoAnnonceController {

    @GetMapping
    public ResponseEntity<String> annonceDemo() {
        return ResponseEntity.ok("Endpoint non sécurisé, accessible par tous.");
    }
}
