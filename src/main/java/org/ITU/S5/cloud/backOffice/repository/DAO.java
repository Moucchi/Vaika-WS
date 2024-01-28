package org.ITU.S5.cloud.backOffice.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;

@NoArgsConstructor
@Getter
@Component
public class DAO {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    public Connection getConnection() {
        Connection result = null;

        try {
            Class.forName(this.getDriverClassName());
            result = DriverManager.getConnection(this.getUrl(), this.getUsername(), this.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return result;
    }
}
