package org.ITU.S5.cloud.security.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users-demo")
public class DemoUserController {

    @GetMapping
    public ResponseEntity<String> userDemo() {
        return ResponseEntity.ok("Endpoint sécurisé, partie dédiée aux utilisateurs connectés.");
    }
}
