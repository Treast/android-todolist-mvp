package riva.vincent.mytodolist.Todo;

import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> list = new ArrayList<String>();

    private static final TodoList ourInstance = new TodoList();

    public static TodoList getInstance() {
        return ourInstance;
    }

    private TodoList() {
        list.add("Salut à tous");
        list.add("les amis");
        list.add("C'est David LafargePokemon");
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
}
