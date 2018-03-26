package riva.vincent.mytodolist.Add;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

        editText = findViewById(R.id.editTextView);
        validateButton = findViewById(R.id.validateButton);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.validateButton:

                break;
        }
    }

    @Override
    public void goBack() {

    }
}
