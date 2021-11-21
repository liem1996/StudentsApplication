package com.example.studentsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class NewStudents extends AppCompatActivity {
    EditText Name;
    EditText Id;
    Button Cancel;
    Button Save;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_students);
        Name=findViewById(R.id.NewStudents_Name);
        Id = findViewById(R.id.NewStudents_ID);
        cb = findViewById(R.id.NewStudents_CB);
        Save = findViewById(R.id.NewStudents_SAVE);
        Cancel=findViewById(R.id.NewStudents_CANCEL);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Name.getText().toString().trim()==null){
                    Toast.makeText(NewStudents.this,"Please enter Name", Toast.LENGTH_LONG).show();
                }
                if(Id.getText().toString().trim()==null){
                    Toast.makeText(NewStudents.this,"Please enter Id", Toast.LENGTH_LONG).show();
                }
                Student student = new Student(Name.getText().toString().trim(), Id.getText().toString().trim(), cb.isChecked());
                Model.instance.addStudent(student);

                Intent intent=new Intent(NewStudents.this,com.example.studentsapplication.MainActivity.class);
                startActivity(intent);
            }
        });


        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NewStudents.this,com.example.studentsapplication.MainActivity.class);
                startActivity(intent);
            }
        });


    }
}