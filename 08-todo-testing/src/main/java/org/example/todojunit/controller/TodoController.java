package org.example.todojunit.controller;

import lombok.RequiredArgsConstructor;
import org.example.todojunit.entity.Todo;
import org.example.todojunit.service.TodoService;
import org.example.todojunit.service.TodoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<?> saveTodos(@RequestBody Todo todo) {
        var savedTodo = todoService.saveTodo(todo);
        return ResponseEntity.status(HttpStatus.OK)
                .body(savedTodo);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<?> getTodoById(@PathVariable Long todoId) {
        var todo = todoService.findTodoById(todoId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(todo);
    }

    @GetMapping
    public ResponseEntity<?> getAllTodos() {
        var todos = todoService.findAllTodos();
        return ResponseEntity.status(HttpStatus.OK)
                .body(todos);
    }
}
