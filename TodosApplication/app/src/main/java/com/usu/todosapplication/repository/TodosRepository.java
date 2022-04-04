package com.usu.todosapplication.repository;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.usu.todosapplication.model.AppDatabase;
import com.usu.todosapplication.model.Todo;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.qualifiers.ApplicationContext;

@Singleton
public class TodosRepository {

    AppDatabase db;

    ArrayList<Todo> todos;

    @Inject
    public TodosRepository(@ApplicationContext Context context) {
        db = Room.databaseBuilder(context, AppDatabase.class, "todos-database" ).build();
    }

    public void saveTodo(String task) {
        // save it
        Todo newTodo = new Todo();
        newTodo.id = todos.size() + 1;
        newTodo.task = task;
        newTodo.isComplete = false;
        // TODO save to database
        db.getTodosDao().createTodo(newTodo);
        todos.add(newTodo);
    }

    public ArrayList<Todo> getTodos() {
        if (todos == null) {
            todos = (ArrayList<Todo>) db.getTodosDao().getTodos();
        }
        return todos;
    }

}
