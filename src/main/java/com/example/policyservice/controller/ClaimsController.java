package com.example.policyservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/claims")
public class ClaimsController {

    @GetMapping
    public String getClaims() {
        return "Claims endpoint is working";
    }
}