package riva.vincent.mytodolist.Todo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import riva.vincent.mytodolist.R;
import riva.vincent.mytodolist.TodoTask;

public class TodoArrayAdapter extends ArrayAdapter<TodoTask> {
    private final Context context;
    private final ArrayList<TodoTask> values;

    public TodoArrayAdapter(Context context, ArrayList<TodoTask> values) {
        super(context, R.layout.row_todo, values);
        this.context = context;
        this.values = values;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_todo, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.rowTextView);

        TodoTask task = this.values.get(position);
        if(task.isImportant()) {
            textView.setText("!!" + this.values.get(position).getTask() + "!!");
            textView.setTextColor(Color.parseColor("#FF0000"));
        } else {
            textView.setText(this.values.get(position).getTask());

        }

        return rowView;
    }
}