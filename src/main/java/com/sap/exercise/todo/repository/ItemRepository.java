package com.sap.exercise.todo.repository;

import com.sap.exercise.todo.entity.Item;
import com.sap.exercise.todo.entity.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

	List<Item> findByToDo(ToDo id);

}
