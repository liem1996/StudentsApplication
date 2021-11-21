package com.example.studentsapplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

interface OnItemClickListener{
    void onItemClick(int position,View view);
}

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    OnItemClickListener listener;

    List<Student> studentsList;

    public MyAdapter(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textName;
        TextView textID;
        CheckBox cb;

        public TextView getTextName() {
            return textName;
        }

        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
             textName = itemView.findViewById(R.id.main_activity_name);
             textID = itemView.findViewById(R.id.main_activity_id);
             cb = itemView.findViewById(R.id.main_activity_check_box);
             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     int position = getAdapterPosition();
                     listener.onItemClick(position,itemView);
                 }
             });
        }
    }

    // the view of the row
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(v,listener);
        return viewHolder;
    }

    // in order to update the view of the row
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.textID.setText(studentsList.get(position).getId());
        holder.textName.setText(studentsList.get(position).getName());
        holder.cb.setChecked(studentsList.get(position).getCheck());

    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

}
