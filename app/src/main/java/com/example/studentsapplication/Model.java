package com.example.studentsapplication;

import java.util.LinkedList;
import java.util.List;

public class Model {

    public final static Model instance = new Model();

    private Model(){
        for (int i=1; i<5; i++)
        {
            Student s = new Student("amit", ""+i, false);
            data.add(s);
        }
    }

    List<Student> data = new LinkedList<Student>();

    public List<Student> getAllStudents(){
        return data;
    }

    public void addStudent(Student student)
    {
        data.add(student);
    }

    public Student editByPosition(int position)
    {
        Student student=new Student();
        student=data.get(position);
        return student;

    }
}