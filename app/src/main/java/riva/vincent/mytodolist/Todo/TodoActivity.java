package riva.vincent.mytodolist.Todo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import riva.vincent.mytodolist.Add.AddActivity;
import riva.vincent.mytodolist.R;


public class TodoActivity extends Activity implements TodoView, View.OnClickListener {

    public static final String SUPER_PREFS = "MyTodoList";

    private Button clearButton;
    private ListView listView;
    private FloatingActionButton fab;

    private TodoArrayAdapter adapter;

    private TodoPresenterImpl presenter;
    private int ITEM_ADDED = 101;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        clearButton = findViewById(R.id.clearButton);
        listView = findViewById(R.id.listView);
        fab = findViewById(R.id.fab);

        SharedPreferences settings = getSharedPreferences(SUPER_PREFS, 0);
        Set<String> set = settings.getStringSet("list", new HashSet<String>());
        TodoList.getInstance().initialize(new ArrayList<String>(set));
        Log.d("lol", TodoList.getInstance().getItems().toString());

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
                this.presenter.handleClickOnFabButton(v);
                break;
        }
    }

    @Override
    public void refreshAdapter() {
        adapter.notifyDataSetChanged();
        updateSharedPreferences();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ITEM_ADDED && resultCode == RESULT_OK) {
            TodoList.getInstance().addItemToList(data.getStringExtra("item"));
            refreshAdapter();
        }
    }

    @Override
    public void goToAddView() {
        Intent intent = new Intent(getApplicationContext(), AddActivity.class);
        startActivityForResult(intent, ITEM_ADDED);
    }

    public void updateSharedPreferences() {
        SharedPreferences settings = getSharedPreferences(SUPER_PREFS, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putStringSet("list", new HashSet<String>(TodoList.getInstance().getItems()));
        editor.commit();
    }
}
