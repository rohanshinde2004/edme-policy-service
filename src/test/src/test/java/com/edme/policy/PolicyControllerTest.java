package com.edme.policy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PolicyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void healthReturnsUp() throws Exception {
        mockMvc.perform(get("/health"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.status").value("UP"));
    }

    @Test
    void policiesReturnsThreeRecords() throws Exception {
        mockMvc.perform(get("/api/policies"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    void unknownPolicyReturns404() throws Exception {
        mockMvc.perform(get("/api/policies/999"))
               .andExpect(status().isNotFound());
    }
}