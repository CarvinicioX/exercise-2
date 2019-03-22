package com.sap.exercise.todo.entity;

import javax.persistence.*;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;

    private String description;
    private boolean done;

    @ManyToOne
    private ToDo toDo;

	public Item() {
	}

	public Item(int itemId, String descrption, boolean done, ToDo toDo) {
		this.itemId = itemId;
		this.description = descrption;
		this.done = done;
		this.toDo = toDo;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public ToDo getToDo() {
		return toDo;
	}

	public void setToDo(ToDo toDo) {
		this.toDo = toDo;
	}
}
