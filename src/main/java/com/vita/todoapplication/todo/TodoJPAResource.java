package com.vita.todoapplication.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoJPAResource {

    @Autowired
    private TodoHardCodeService todoService;

    @Autowired
    private TodoRepository todoJPaRepository;

    @GetMapping("/jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        // return all todos
        return todoJPaRepository.findByUsername(username);
    }

    @GetMapping("/jpa/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id){
        // return all todos
        return todoJPaRepository.findById(id).get();
    }

    @DeleteMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,
                                           @PathVariable Long id){
        todoJPaRepository.deleteById(id);
        return ResponseEntity.notFound().build();
    }
//
    @PutMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,
                                           @PathVariable Long id, @RequestBody Todo todo){
        Todo todoUpdate = todoJPaRepository.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> createTodo(@PathVariable String username,
                                           @PathVariable Long id, @RequestBody Todo todo){

        todo.setUsername(username);
        Todo createdTodo = todoJPaRepository.save(todo);
        //Location, get current resourse
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}
