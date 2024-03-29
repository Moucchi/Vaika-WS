package org.ITU.S5.cloud.frontOffice.chat.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("user")
public class User {

    @Id
    private String username;
    private Status status;
}
