package org.ITU.S5.cloud.frontOffice.chat.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserChatController {

    private final UserChatService service;

    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public User addUser(@Payload User user) {
        service.saveUser(user);
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    public User disconnect(User user) {
        service.disconnect(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findConnectedUsers() {
        return ResponseEntity.ok(service.findConnectedUsers());
    }

    @PostMapping("/api/v1/chat/new-user")
    public ResponseEntity<String> addNewUser(@RequestBody User user) {
        if (user.getUsername() != null) {
            service.saveUser(user);
            return ResponseEntity.ok("Success : Utilisateur chat ajouté");
        }
        return ResponseEntity.ok("Failed : Nom d'utilisateur manquant");
    }
}
