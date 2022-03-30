package com.usu.todosapplication.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.usu.todosapplication.model.Todo;
import com.usu.todosapplication.repository.TodosRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NewTodoViewModel extends ViewModel {
    TodosRepository repository;
    MutableLiveData<String> errorMessage = new MutableLiveData<>();

    @Inject
    public NewTodoViewModel(TodosRepository repository) {
        this.repository = repository;
        errorMessage.setValue("");
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public void saveTodo(String task) {
        // check to make sure task is not empty
        errorMessage.setValue("");
        if (task.isEmpty()) {
            errorMessage.setValue("Task cannot be empty");
        } else {
            this.repository.saveTodo(task);
        }
    }
}
