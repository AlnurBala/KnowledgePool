package com.matrix.knowpoolwebsite.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

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
