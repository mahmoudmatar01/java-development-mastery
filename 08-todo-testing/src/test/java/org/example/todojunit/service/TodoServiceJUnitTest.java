package org.example.todojunit.service;

import org.example.todojunit.entity.Todo;
import org.example.todojunit.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.*;

@SpringBootTest
class TodoServiceJUnitTest {

    @MockBean
    private TodoRepository todoRepository;
    private final TodoService todoService;

    @Autowired
    public TodoServiceJUnitTest(TodoService todoService) {
        this.todoService = todoService;
    }

    @Test
    public void whenFindAll_ReturnTodosList(){
        // Mockup
        Todo todo1=new Todo(1L,"FirstTodo","FirstTodoDescription","www.todo1image.com");
        Todo todo2=new Todo(2L,"SecondTodo","SecondTodoDescription","www.todo2image.com");
        List<Todo> todoList= Arrays.asList(todo1,todo2);
        given(todoRepository.findAll()).willReturn(todoList);

        // Assertion Test
        assertThat(todoService.findAllTodos())
                .contains(todo1,todo2)
                .hasSize(2);
    }

    @Test
    public void whenGetById_TodoShouldBeFound(){
        // Mockup
        Todo todo=new Todo(1L,"TodoName","TodoDescription","www.todo-image.com");
        given(todoRepository.findById(anyLong())).willReturn(Optional.ofNullable(todo));

        // Assertion Test
        Todo result=todoService.findTodoById(1L);
        assertThat(result.getName())
                .containsIgnoringCase("TodoName");
    }

    @Test
    public void whenInvalidId_TodoShouldNotBeFound(){
        given(todoRepository.findById(anyLong())).willReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> todoService.findTodoById(1L));
    }
}
