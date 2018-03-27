package riva.vincent.mytodolist.Todo;

import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;

import riva.vincent.mytodolist.TodoTask;

public class TodoList {
    private ArrayList<TodoTask> list = new ArrayList<TodoTask>();

    private static final TodoList ourInstance = new TodoList();

    public static TodoList getInstance() {
        return ourInstance;
    }

    private TodoList() {
    }

    public void addItemToList(String string, boolean isImportant) {
        TodoTask task = new TodoTask(string, isImportant);
        this.list.add(task);
    }

    public void clearList() {
        list.clear();
    }

    public ArrayList<TodoTask> getItems() {
        return list;
    }

    public void initialize(ArrayList<TodoTask> newList) {
        list = newList;
    }
}
