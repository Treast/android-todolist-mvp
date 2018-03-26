package riva.vincent.mytodolist.Todo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import riva.vincent.mytodolist.Add.AddActivity;
import riva.vincent.mytodolist.R;


public class TodoActivity extends Activity implements TodoView, View.OnClickListener {

    private Button clearButton;
    private ListView listView;
    private FloatingActionButton fab;

    private TodoArrayAdapter adapter;

    private TodoPresenterImpl presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        clearButton = findViewById(R.id.clearButton);
        listView = findViewById(R.id.listView);
        fab = findViewById(R.id.fab);

        presenter = new TodoPresenterImpl(this);

        clearButton.setOnClickListener(this);
        fab.setOnClickListener(this);

        adapter = new TodoArrayAdapter(getApplicationContext(), TodoList.getInstance().getItems());

        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.clearButton:
                this.presenter.handleClickOnClearButton(v);
                break;
            case R.id.fab:
                this.presenter.handleClickOnClearButton(v);
                break;
        }
    }

    @Override
    public void refreshAdapter() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void goToAddView() {
        Intent intent = new Intent(getApplicationContext(), AddActivity.class);
        startActivity(intent);
    }
}
