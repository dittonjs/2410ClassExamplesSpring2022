package com.usu.todosapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
todo
=======================================================================
id int32          |      task varchar(512)  |         isComplete       |
=======================================================================
1                |   go pick up grandma  |           false             |
2                |   do my homework      |           true              |
 */

@Entity
public class Todo {
    @PrimaryKey
    public long id;

    @ColumnInfo
    public String task;

    @ColumnInfo
    public boolean isComplete;

    @ColumnInfo
    public long createdAt;
}
