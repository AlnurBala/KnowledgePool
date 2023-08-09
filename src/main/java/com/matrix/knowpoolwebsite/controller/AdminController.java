package com.matrix.knowpoolwebsite.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@SecurityRequirement(name = "jwt")
public class AdminController {

    @GetMapping
    public String get() {
        return "GET:: admin controller";
    }
    @PostMapping
    @Hidden
    public String post() {
        return "POST:: admin controller";
    }
    @PutMapping
    @Hidden
    public String put() {
        return "PUT:: admin controller";
    }
    @DeleteMapping
    @Hidden
    public String delete() {
        return "DELETE:: admin controller";
    }
}
