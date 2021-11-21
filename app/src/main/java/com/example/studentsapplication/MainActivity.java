package com.example.studentsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Student> data;
    Button AddStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddStudent=findViewById(R.id.main_activity_add_student);

        RecyclerView rv = findViewById(R.id.main_activity_RV);

        LinearLayoutManager layoutManager;

        layoutManager=new LinearLayoutManager(this);

        rv.setLayoutManager(layoutManager);

        rv.setHasFixedSize(true);

        data = Model.instance.getAllStudents();

        MyAdapter adapter = new MyAdapter(data);
        rv.setAdapter(adapter);

        adapter.setListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position,View view) {
                Intent intent=new Intent(MainActivity.this,com.example.studentsapplication.DetailsStudents.class);
                intent.putExtra("name",(String) ((TextView) view.findViewById(R.id.main_activity_name)).getText());
                intent.putExtra("id",(String) ((TextView) view.findViewById(R.id.main_activity_id)).getText());
                intent.putExtra("checkbox",(Boolean) ((CheckBox) view.findViewById(R.id.main_activity_check_box)).isChecked());
                intent.putExtra("position", position);
                startActivity(intent);
            }

        });

        AddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,com.example.studentsapplication.NewStudents.class);
                 startActivity(intent);
                adapter.notifyDataSetChanged();
            }
        });
      //  data.add(new Student("name"," ",true));

        adapter.notifyDataSetChanged();


    }


}