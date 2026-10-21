package com.edme.policy.controller;

import com.edme.policy.model.Policy;
import com.edme.policy.service.PolicyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PolicyController {

    private final PolicyService service;

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    public PolicyController(PolicyService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    @GetMapping("/api/info")
    public Map<String, String> info() {
        return Map.of("name", appName, "version", appVersion);
    }

    @GetMapping("/api/policies")
    public List<Policy> all() {
        return service.findAll();
    }

    @GetMapping("/api/policies/{id}")
    public ResponseEntity<Policy> byId(@PathVariable int id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}