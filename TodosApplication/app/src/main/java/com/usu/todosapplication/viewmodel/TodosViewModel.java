package com.usu.todosapplication.viewmodel;

import android.os.Handler;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.usu.todosapplication.model.Todo;
import com.usu.todosapplication.repository.TodosRepository;

import java.util.ArrayList;
import java.util.Observable;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class TodosViewModel extends ViewModel {
    TodosRepository repository;
    ObservableArrayList<Todo> todos = new ObservableArrayList<>();
    Handler handler = new Handler();

    @Inject
    public TodosViewModel(TodosRepository repository) {
        System.out.println("VM CREATED");
        this.repository = repository;
    }

    public ObservableArrayList<Todo> getTodos() {
        this.todos.clear();
        new Thread(() -> {
            ArrayList<Todo> repoTodos = this.repository.getTodos();
            handler.post(() -> {
                this.todos.addAll(repoTodos);
            });
        }).start();
        return this.todos;
    }

    public void toggleTodoStatus(Todo todo) {
        new Thread(() -> {
            todo.isComplete = !todo.isComplete;
            this.repository.updateTodo(todo);
            int index = todos.indexOf(todo);
            handler.post(() -> {
                todos.set(index, todo);
            });
        }).start();
    }
}
