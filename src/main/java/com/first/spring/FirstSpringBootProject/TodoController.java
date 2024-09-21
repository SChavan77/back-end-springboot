package com.first.spring.FirstSpringBootProject;

import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos") //for versioning we use
public class TodoController {

    private static List<Todo> todos;
    public TodoController(){
        todos=new ArrayList<>();
        todos.add(new Todo(1,false,"Todo 1",1));
        todos.add(new Todo(2,true,"Todo 2",2));
    }

   /* @GetMapping("/hello")
    public String HelloPrint(){
        return "<b>Hello World!</b>";
    }

    @GetMapping("/home")
    public String goHome(){
        return "<b>Welcome to Home!!!</b>";
    }*/
    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(todos) ;
    }

   /* @PostMapping("/todos")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@RequestBody Todo todo){
        todos.add(todo);
        return todo;
    }*/

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        todos.add(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable int id){
        for(Todo todo:todos){
            if(todo.getId()==id)
                return ResponseEntity.ok().body(todo);
        }
        //client trying to fetch a resource which is not available.
        throw new ResourceNotFoundExe();
    }
}


/*
private static List<Todo> todos;
public TodoController(){
    todos=new ArrayList<>();
    todos.add(new Todo(1,false,"Todo 1",1));
    todos.add(new Todo(2,true,"Todo 2",2));
}

*/
/* @GetMapping("/hello")
 public String HelloPrint(){
     return "<b>Hello World!</b>";
 }

 @GetMapping("/home")
 public String goHome(){
     return "<b>Welcome to Home!!!</b>";
 }*//*

@GetMapping
public ResponseEntity<List<Todo>> getTodos(){
    return ResponseEntity.status(HttpStatus.OK).body(todos) ;
}

   */
/* @PostMapping("/todos")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@RequestBody Todo todo){
        todos.add(todo);
        return todo;
    }*//*


@PostMapping
public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
    todos.add(todo);
    return ResponseEntity.status(HttpStatus.CREATED).body(todo);
}

@GetMapping("/{id}")
public ResponseEntity<Todo> getTodo(@PathVariable int id){
    for(Todo todo:todos){
        if(todo.getId()==id)
            return ResponseEntity.ok().body(todo);
    }
    //client trying to fetch a resource which is not available.
    return ResponseEntity.notFound().build();
}*/
