package riva.vincent.mytodolist.Todo;

import android.content.SharedPreferences;

import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> list = new ArrayList<String>();

    private static final TodoList ourInstance = new TodoList();

    public static TodoList getInstance() {
        return ourInstance;
    }

    private TodoList() {
    }

    public void addItemToList(String string) {
        list.add(string);
    }

    public void clearList() {
        list.clear();
    }

    public ArrayList<String> getItems() {
        return list;
    }

    public void initialize(ArrayList<String> newList) {
        list = newList;
    }
}
