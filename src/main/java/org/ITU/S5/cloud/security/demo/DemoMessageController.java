package org.ITU.S5.cloud.security.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/message-demo")
public class DemoMessageController {

    @GetMapping
    public ResponseEntity<String> messageDemo() {
        return ResponseEntity.ok("Endpoint sécurisé, accessible uniquement par les utilisateurs connectés.");
    }
}
