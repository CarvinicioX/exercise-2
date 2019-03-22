package com.sap.exercise.todo.service;

import com.sap.exercise.todo.entity.Item;
import com.sap.exercise.todo.entity.ToDo;
import com.sap.exercise.todo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ToDoService toDoService;

	public List<Item> getItemPerToDo(int toDoId) {
		return itemRepository.findByToDo(toDoService.getTodo(toDoId));
	}

	public Object getItemFromToDo(int toDoId, int id) {
		return itemRepository.findByToDo(toDoService.getTodo(toDoId)).stream().filter(toDo -> toDo.getItemId() == id).findFirst();
	}

	public Object createItem(Item item, int toDoId) {
		item.setToDo(toDoService.getTodo(toDoId));
		return itemRepository.save(item);
	}

	public Object updateItem(int id, Item item) {
		Optional<Item> itemOptional = itemRepository.findById(id);
		if (itemOptional.isPresent()) {
			item.setItemId(id);
			itemRepository.save(item);
			return item;
		}
		return null;
	}

	public Object deleteItem(int id, int toDoId) {
		Optional<Item> itemOptional = itemRepository.findByToDo(toDoService.getTodo(toDoId)).stream().filter(toDo -> toDo.getItemId() == id).findFirst();
		if (itemOptional.isPresent()) {
			Item ret = itemOptional.get();
			itemRepository.delete(ret);
			return ret;
		}
		return null;
	}
}
