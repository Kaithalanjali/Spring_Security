package com.in28minutes.learnspringsecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private static List<Todo> getTodoList() {
        return List.of(new Todo("in@28minutes", "Learn AWS"), new Todo("in@38minutes", "Learn Cloud"));
    }
@GetMapping("/todos")
    public List<Todo> retrieveAllTodos(){
    return getTodoList();
}
    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodosForSpecificUSer(@PathVariable String username){
        return getTodoList().get(0);
    }
    @PostMapping("/users/{username}/todos")
    public void createTodosForSpecificUSer(@PathVariable String username, @RequestBody Todo todo){
        logger.info("Creating {} for {}", todo, username); ;
    }

}
record Todo (String username, String description){}
