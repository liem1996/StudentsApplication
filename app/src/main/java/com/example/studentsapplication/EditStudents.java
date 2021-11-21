package com.example.studentsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class EditStudents extends AppCompatActivity {
    Button Cancel;
    Button Save;
    EditText Name;
    EditText Id;
    CheckBox Cb;
    Button Delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_students);
        Cancel = findViewById(R.id.Edit_Student_cancel);
        Save = findViewById(R.id.Edit_Student_SaveBtn);
        Delete = findViewById(R.id.Edit_Student_delete);
        Name = findViewById(R.id.Edit_Student_Name);
        Id = findViewById(R.id.Edit_Student_Id);
        Cb = findViewById(R.id.Edit_student_cb);

        String name = getIntent().getStringExtra("name");
        String id = getIntent().getStringExtra("id");
        Boolean checkbox = getIntent().getExtras().getBoolean("checkbox");
        int position = getIntent().getExtras().getInt("position");


        Name.setText(name);
        Id.setText(id);
        Cb.setChecked(checkbox);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Name.getText().toString().trim()==null){
                    Toast.makeText(EditStudents.this,"Please enter Name", Toast.LENGTH_LONG).show();
                }
                if(Id.getText().toString().trim()==null){
                    Toast.makeText(EditStudents.this,"Please enter Id", Toast.LENGTH_LONG).show();
                }
                Model.instance.editByPosition(position).id=Id.getText().toString().trim();
                Model.instance.editByPosition(position).name=Name.getText().toString().trim();
                Model.instance.editByPosition(position).isCheck=Cb.isChecked();
                Intent intent=new Intent(EditStudents.this,com.example.studentsapplication.MainActivity.class);
                startActivity(intent);

            }
        });
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditStudents.this,com.example.studentsapplication.MainActivity.class);
                startActivity(intent);
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();

                student=Model.instance.data.get(position);

                Model.instance.data.remove(student);

                Intent intent=new Intent(EditStudents.this,com.example.studentsapplication.MainActivity.class);
                startActivity(intent);

            }
        });

    }
}