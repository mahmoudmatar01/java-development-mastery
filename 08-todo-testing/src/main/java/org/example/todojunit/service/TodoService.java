package org.example.todojunit.service;

import org.example.todojunit.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> findAllTodos();
    Todo saveTodo(Todo todo);
    Todo findTodoById(Long id);
}
