package com.example.be_study_2026.week6_advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    // 임시 DB
    private final List<Todo> todoList = new CopyOnWriteArrayList<>();
    private final AtomicLong sequence = new AtomicLong(1L);

    public void create(String content) {
        Long id = sequence.getAndIncrement();
        boolean isDone = false;
        todoList.add(new Todo(id, content, isDone));
    }

    public List<TodoResponse> findAll() {
        return todoList.stream().map(todo -> new TodoResponse(todo.getId(), todo.getContent(), todo.getIsDone())).toList();
    }
}
