package riva.vincent.mytodolist.Add;

import riva.vincent.mytodolist.Todo.TodoList;

/**
 * Created by vriva on 26/03/2018.
 */

public class AddPresenterImpl implements AddPresenter {

    private AddView addView;

    public AddPresenterImpl(AddView addView) {
        this.addView = addView;
    }

    @Override
    public void addItemToList(String string) {
        this.addView.goBack(string);
    }
}
