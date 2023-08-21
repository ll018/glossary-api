package com.pleonasmen.glossaryapi.controller;

import com.pleonasmen.glossaryapi.domain.ProjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@Controller
@RequestMapping("/projects")
public class GlossaryProjectController {

    @GetMapping
    public ResponseEntity<String> all() {
        return ResponseEntity.ok().body("Hello");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> byId(@PathVariable String id) {
        if (id.equals("11"))
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body("Hello");
    }

    @PostMapping
    public ResponseEntity<ProjectId> create() {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProjectId(1));
    }
}
