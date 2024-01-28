package org.ITU.S5.cloud.security.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = """
        SELECT t FROM Token t INNER JOIN User u\s 
        ON t.user.id = u.id\s
        WHERE u.id = :id and (t.expired = false or t.revoked = false)
    """)
    List<Token> findAllValidTokenByUser(Integer id);

    Optional<Token> findByToken(String token);
}
