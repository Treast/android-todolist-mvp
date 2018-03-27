package riva.vincent.mytodolist.Todo;


import android.content.Intent;
import android.view.View;

import riva.vincent.mytodolist.Add.AddActivity;

public class TodoPresenterImpl implements TodoPresenter {

    private TodoView todoView;

    public TodoPresenterImpl(TodoView todoView) {
        this.todoView = todoView;
    }

    @Override
    public void handleClickOnClearButton(View view) {
        TodoList.getInstance().clearList();
        this.todoView.refreshAdapter();
    }

    @Override
    public void handleClickOnValidateButton(View view, String string, boolean isImportant) {
        TodoList.getInstance().addItemToList(string, isImportant);
        this.todoView.refreshAdapter();
    }

    @Override
    public void handleClickOnFabButton(View view) {
        todoView.goToAddView();
    }

}
