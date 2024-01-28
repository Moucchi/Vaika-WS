package org.ITU.S5.cloud.frontOffice.chat.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserChatRepository extends MongoRepository<User, String> {
    List<User> findAllByStatus(Status status);
}
