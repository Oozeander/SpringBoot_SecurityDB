package com.oozeander.model;

import com.oozeander.model.auth.Permission;
import com.oozeander.model.auth.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users", schema = "default_schema")
public class User implements Serializable {
    @Id
    private String username;
    private String email, password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ElementCollection
    @CollectionTable(name = "user_permissions", schema = "default_schema",
        joinColumns = {@JoinColumn(name = "username")})
    @Enumerated(EnumType.STRING)
    private List<Permission> permissions;
    private boolean enabled;

    public User() {}

    public User(String username, String email, String password, Role role, List<Permission> permissions, boolean enabled) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.permissions = permissions;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }
}