package riva.vincent.mytodolist.Add;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import riva.vincent.mytodolist.R;

/**
 * Created by vriva on 26/03/2018.
 */

public class AddActivity extends Activity implements AddView, View.OnClickListener {

    private EditText editText;
    private Button validateButton;
    private AddPresenter presenter;
    private CheckBox checkBoxView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        presenter = new AddPresenterImpl(this);

        editText = findViewById(R.id.editTextView);
        validateButton = findViewById(R.id.validateButton);
        checkBoxView = findViewById(R.id.checkBoxView);

        validateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.validateButton:
                presenter.addItemToList(editText.getText().toString(), checkBoxView.isChecked() );
                break;
        }
    }

    @Override
    public void goBack(String string, boolean isImportant) {
        Intent intent = new Intent();
        intent.putExtra("item", string);
        intent.putExtra("isImportant", isImportant);
        setResult(RESULT_OK, intent);
        finish();
    }
}
