package org.example.todojunit.service;
import org.example.todojunit.entity.Todo;
import org.example.todojunit.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo saveTodo(Todo todo) {
        if(todoRepository.findByName(todo.getName()).isPresent()){
            throw new RuntimeException("Todo with name : "+todo.getName()+" is already exist!");
        }
        return todoRepository.save(todo);
    }

    @Override
    public Todo findTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException("Todo with id : "+id+" not found!")
        );
    }
}
