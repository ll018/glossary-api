package com.pleonasmen.glossaryapi.controller;

import com.pleonasmen.glossaryapi.GlossaryApiApplication;
import com.pleonasmen.glossaryapi.domain.ProjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = GlossaryApiApplication.class)
@AutoConfigureMockMvc
class GlossaryProjectControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void givenExistingId_whenGetProject_thenStatus200() throws Exception {
        mockMvc.perform(get("/projects/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void givenNonExistingId_whenGetProject_thenStatus404() throws Exception {
        mockMvc.perform(get("/projects/11")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void givenNonExistingProject_whenCreateProject_thenCreateAndReturnId() throws Exception {
        mockMvc.perform(post("/projects")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }
}