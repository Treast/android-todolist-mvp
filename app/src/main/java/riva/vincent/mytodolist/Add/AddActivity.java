package riva.vincent.mytodolist.Add;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import riva.vincent.mytodolist.R;

/**
 * Created by vriva on 26/03/2018.
 */

public class AddActivity extends Activity implements AddView, View.OnClickListener {

    private EditText editText;
    private Button validateButton;
    private AddPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        presenter = new AddPresenterImpl(this);

        editText = findViewById(R.id.editTextView);
        validateButton = findViewById(R.id.validateButton);

        validateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.validateButton:
                presenter.addItemToList(editText.getText().toString());
                break;
        }
    }

    @Override
    public void goBack(String string) {
        Intent intent = new Intent();
        intent.putExtra("item", string);
        setResult(RESULT_OK, intent);
        finish();
    }
}
