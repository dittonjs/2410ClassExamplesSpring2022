package com.usu.todosapplication.repository;

import com.usu.todosapplication.model.Todo;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TodosRepository {

    ArrayList<Todo> todos = new ArrayList<>();

    @Inject
    public TodosRepository() {}

    public void saveTodo(String task) {
        // save it
        Todo newTodo = new Todo();
        newTodo.id = todos.size() + 1;
        newTodo.task = task;
        newTodo.isComplete = false;
        // TODO save to database
        todos.add(newTodo);
    }

    public ArrayList<Todo> getTodos() {
        return todos;
    }

}
