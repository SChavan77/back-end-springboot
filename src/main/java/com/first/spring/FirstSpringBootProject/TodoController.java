package com.first.spring.FirstSpringBootProject;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/todos") //for versioning we use
public class TodoController {

    @Autowired //no need the DI thru constructor
    @Qualifier("FakeService")
    private TodoService todoService;

    private TodoService todoService2;
    private TodoService todoService3;

    private static List<Todo> todos;
    public TodoController(/*TodoService todoService*/){ //when we use @Autowired
        todos=new ArrayList<>();
        todos.add(new Todo(1,false,"Todo 1",1));
        todos.add(new Todo(2,true,"Todo 2",2));
        //this.todoService=todoService;
    }
    //But now a days, DI through constructor is recommended over @Autowired
    public TodoController(@Qualifier("FakeService") TodoService todoService){
        todos=new ArrayList<>();
        todos.add(new Todo(1,false,"Todo 1",1));
        todos.add(new Todo(2,true,"Todo 2",2));
        this.todoService=todoService;
    }

    //When we need both
    public TodoController(@Qualifier("FakeService") TodoService todoService2,
                          @Qualifier("AnotherService") TodoService todoService3){
        todos=new ArrayList<>();
        todos.add(new Todo(1,false,"Todo 1",1));
        todos.add(new Todo(2,true,"Todo 2",2));
        this.todoService2=todoService2;
        this.todoService3=todoService3;
    }

   /* @GetMapping
    public ResponseEntity<List<Todo>> allAllTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(todos) ;
    }*/

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(@RequestParam(required = false,defaultValue = "true") boolean isCompleted){
        System.out.println(this.todoService.doSomething());
        return ResponseEntity.status(HttpStatus.OK).body(
                todos.stream().filter(a->a.isCompleted()==isCompleted).collect(Collectors.toUnmodifiableList()));
    }

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
