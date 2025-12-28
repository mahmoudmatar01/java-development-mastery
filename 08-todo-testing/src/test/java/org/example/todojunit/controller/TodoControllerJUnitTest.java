package org.example.todojunit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.todojunit.entity.Todo;
import org.example.todojunit.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TodoControllerJUnitTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TodoService todoService;

    @Test
    public void whenGetAllTodos_thenReturnJsonArray()throws Exception{
        // Mock up
        Todo todo1=new Todo(1L,"FirstTodo","FirstTodoDescription","www.todo1image.com");
        Todo todo2=new Todo(2L,"SecondTodo","SecondTodoDescription","www.todo2image.com");
        List<Todo>todoList= Arrays.asList(todo1,todo2);
        given(todoService.findAllTodos()).willReturn(todoList);

        // Test Logic
        mockMvc.perform(get("/api/v1/todo").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].name",equalTo(todo1.getName())));
    }



    @Test
    public void whenPostTodo_thenCreateTodo()throws Exception{
        Todo todo=Todo.builder()
                .name("FirstTodo")
                .description("FirstTodoDescription")
                .imageUrl("www.first_todo_image.com")
                .build();

        given(todoService.saveTodo(Mockito.any(Todo.class))).willReturn(todo);

        ObjectMapper mapper=new ObjectMapper();

       ResultActions response= mockMvc.perform(post("/api/v1/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(todo)));
       response.andExpect(status().isOk())
               .andExpect(jsonPath("$.name",is(todo.getName())));
    }
}
