package com.example.demo.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sec_users")
public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "sec_enabled")
    private boolean enabled;

    @Column(name = "authority")
    private String authority;

    public UserDetails toUserDetails(){
        return User.builder()
                .username(username)
                .password(password)
                .disabled(!enabled)
                .accountExpired(!enabled)
                .build();
    }
}
