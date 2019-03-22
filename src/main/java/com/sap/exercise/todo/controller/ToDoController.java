package com.sap.exercise.todo.controller;

import com.sap.exercise.todo.entity.Response;
import com.sap.exercise.todo.entity.ToDo;
import com.sap.exercise.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/to-do")
public class ToDoController {

	@Autowired
	private ToDoService toDoService;

	@GetMapping
	public Response getToDos() {
		return new Response(toDoService.getAllToDos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Response getToDo(@PathVariable("id") int id) {
		return new Response(toDoService.getTodo(id), HttpStatus.OK);
	}

	@PostMapping
	public Response saveToDo(@RequestBody ToDo toDo) {
		return new Response(toDoService.createToDo(toDo), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public Response updateToDo(@PathVariable("id") int id, @RequestBody ToDo toDo) {
		return new Response(toDoService.updateToDo(id, toDo), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public Response deleteToDo(@PathVariable("id") int id) {
		return new Response(toDoService.deleteToDo(id), HttpStatus.OK);
	}

}
