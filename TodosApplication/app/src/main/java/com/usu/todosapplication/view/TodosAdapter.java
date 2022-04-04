package com.usu.todosapplication.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.usu.todosapplication.R;
import com.usu.todosapplication.model.Todo;

import java.util.ArrayList;

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.TodoViewHolder> {

    ArrayList<Todo> todos;
    public TodosAdapter(ArrayList<Todo> todos) {
        this.todos = todos;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TodoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = todos.get(position);
        CheckBox checkBox = holder.itemView.findViewById(R.id.checkBox);
        checkBox.setChecked(todo.isComplete);
        checkBox.setText(todo.task);
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
