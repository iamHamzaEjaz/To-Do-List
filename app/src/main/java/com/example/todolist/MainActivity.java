package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.todolist.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    List<String> toDoList;
    ArrayAdapter<String> arrayAdapter;
    ListView  listView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        toDoList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this,R.layout.layout, toDoList);
        listView = findViewById(R.id.listView1);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView textView = (TextView) view;
                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


//               Toast.makeText(MainActivity.this, "position", Toast.LENGTH_SHORT).show();
//               Intent intent=new Intent(MainActivity.this, MainActivity1.class);
//               startActivity(intent);
            }
        });


            editText = findViewById(R.id.editText1);


    }
    public void addItemToList1(View view){
        toDoList.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        editText.setText(" ");
    }
}
