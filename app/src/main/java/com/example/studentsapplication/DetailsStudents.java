package com.example.studentsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class DetailsStudents extends AppCompatActivity {

    Button Edit;
    TextView Name;
    TextView Id;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_students);
        Edit = findViewById(R.id.Details_Students_edit);
        Name=findViewById(R.id.Details_Students_Name);
        Id = findViewById(R.id.Details_Students_Id);
        cb = findViewById(R.id.Details_Students_cb);


        String name = getIntent().getStringExtra("name");
        String id = getIntent().getStringExtra("id");
        int position = getIntent().getExtras().getInt("position");
        Boolean checkbox = getIntent().getExtras().getBoolean("checkbox");

        Name.setText(name);
        Id.setText(id);
        cb.setChecked(checkbox);

        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailsStudents.this,com.example.studentsapplication.EditStudents.class);
                intent.putExtra("name",name);
                intent.putExtra("id",id);
                intent.putExtra("checkbox",checkbox);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });


    }
}