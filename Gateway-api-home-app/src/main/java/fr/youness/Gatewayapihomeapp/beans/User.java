package fr.youness.Gatewayapihomeapp.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column @JsonIgnore
    private String password;
    @Column
    private Boolean isActive;
    @Column(nullable = false, updatable = false) @CreationTimestamp
    private Date updated_timestamp;

    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() { return isActive; }

    public void setActive(Boolean active) { isActive = active; }
}