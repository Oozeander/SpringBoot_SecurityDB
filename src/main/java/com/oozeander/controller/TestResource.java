package com.oozeander.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")
public class TestResource {
    @GetMapping("user")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String getUserRole() {
        return "For users / admin";
    }

    @GetMapping("admin")
    @Secured({"ROLE_ADMIN"})
    public String getAdminRole() {
        return "For admin";
    }

    @GetMapping("public")
    @PreAuthorize("permitAll()")
    public String getAll() {
        return "For all";
    }

    @GetMapping("permission")
    @PreAuthorize("hasAnyAuthority('uer:read', 'user:write')")
    public String getUserPermissions() {
        return "For user:read / user:write permissions only";
    }
}