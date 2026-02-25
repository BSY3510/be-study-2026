package com.example.be_study_2026.week6_advanced;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @PostMapping("/todos")
    public void create(
        @RequestBody TodoRequest request
    ) {
        service.create(request.content());
    }

    @GetMapping("/todos")
    public List<TodoResponse> findAll() {
        return service.findAll();
    }

}
