package com.usu.todosapplication.viewmodel;

import androidx.lifecycle.ViewModel;

import com.usu.todosapplication.model.Todo;
import com.usu.todosapplication.repository.TodosRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class TodosViewModel extends ViewModel {
    TodosRepository repository;

    @Inject
    public TodosViewModel(TodosRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Todo> getTodos() {
        return this.repository.getTodos();
    }
}
