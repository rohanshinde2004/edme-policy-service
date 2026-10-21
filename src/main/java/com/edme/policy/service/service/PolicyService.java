package com.edme.policy.service;

import com.edme.policy.model.Policy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

    private final List<Policy> policies = List.of(
        new Policy(1, "Rohan", "HEALTH", 12000.0),
        new Policy(2, "Anita", "LIFE", 25000.0),
        new Policy(3, "Vikram", "MOTOR", 8000.0)
    );

    public List<Policy> findAll() {
        return policies;
    }

    public Optional<Policy> findById(int id) {
        return policies.stream().filter(p -> p.id() == id).findFirst();
    }
}