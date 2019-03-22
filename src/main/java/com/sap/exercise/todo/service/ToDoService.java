package com.sap.exercise.todo.service;

import com.sap.exercise.todo.controller.ToDoController;
import com.sap.exercise.todo.entity.ToDo;
import com.sap.exercise.todo.repository.ToDoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

	private final Logger log = LoggerFactory.getLogger(ToDoController.class);

	public List<ToDo> getAllToDos() {
		log.info("GET allToDos");
		return (List<ToDo>) toDoRepository.findAll();
	}

	public ToDo getTodo(int id) {
		Optional<ToDo> toDo = toDoRepository.findById(id);
		if (toDo.isPresent()) {
			log.info("GET byId=" + id);
			return toDo.get();
		} else {
			log.error("GET byId=" + id + ", non-existant");
			return null;
		}
	}

	public ToDo createToDo(ToDo toDo) {
		Optional<ToDo> toDoOptional = toDoRepository.findById(toDo.getId());
		if (!toDoOptional.isPresent()) {
			toDoRepository.save(toDo);
			return toDo;
		}
		return null;
	}

	public ToDo updateToDo(int id, ToDo toDo) {
		Optional<ToDo> toDoOptional = toDoRepository.findById(id);
		if (toDoOptional.isPresent()) {
			toDo.setId(id);
			toDoRepository.save(toDo);
			return toDo;
		}
		return null;
	}

	public ToDo deleteToDo(int id) {
		Optional<ToDo> toDo = toDoRepository.findById(id);
		if (toDo.isPresent()) {
			ToDo ret = toDo.get();
			toDoRepository.deleteById(id);
			return ret;
		}
		return null;
	}
}
