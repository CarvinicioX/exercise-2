package com.sap.exercise.todo.controller;

import com.sap.exercise.todo.entity.Item;
import com.sap.exercise.todo.entity.Response;
import com.sap.exercise.todo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/to-do/{toDoId}/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping
	public Response getItemPerToDo(@PathVariable("toDoId") int toDoId) {
		return new Response(itemService.getItemPerToDo(toDoId), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Response getItemFromToDo(@PathVariable("toDoId") int toDoId, @PathVariable("id") int id) {
		return new Response(itemService.getItemFromToDo(toDoId, id), HttpStatus.OK);
	}

	@PostMapping
	public Response saveItem(@PathVariable("toDoId") int toDoId, @RequestBody Item item) {
		return new Response(itemService.createItem(item, toDoId), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public Response updateItem(@PathVariable("id") int id, @RequestBody Item item) {
		return new Response(itemService.updateItem(id, item), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public Response deleteItem(@PathVariable("toDoId") int toDoId, @PathVariable("id") int id) {
		return new Response(itemService.deleteItem(id, toDoId), HttpStatus.OK);
	}

}
