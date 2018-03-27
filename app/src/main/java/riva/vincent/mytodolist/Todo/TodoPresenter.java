package riva.vincent.mytodolist.Todo;

import android.view.View;

public interface TodoPresenter {

    void handleClickOnClearButton(View view);
    void handleClickOnValidateButton(View view, String string, boolean isImportant);

    void handleClickOnFabButton(View view);

}
