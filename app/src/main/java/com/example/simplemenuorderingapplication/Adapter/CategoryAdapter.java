package com.example.simplemenuorderingapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplemenuorderingapplication.Activity.CategoryActivity;
import com.example.simplemenuorderingapplication.Model.Categories;
import com.example.simplemenuorderingapplication.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private ArrayList<Categories> dataSet;

    public CategoryAdapter(ArrayList<Categories> data) {
        this.dataSet = data;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCategoryName;
        ImageView imageViewCategoryPic;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewCategoryName = (TextView) itemView.findViewById(R.id.textViewName);
            this.imageViewCategoryPic = (ImageView) itemView.findViewById(R.id.foodImage);
        }
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        view.setOnClickListener(CategoryActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull CategoryAdapter.MyViewHolder holder, int position) {
        TextView textViewCategoryName = holder.textViewCategoryName;
        ImageView imageViewCategoryPic = holder.imageViewCategoryPic;

        textViewCategoryName.setText(dataSet.get(position).getCategoryName());
        imageViewCategoryPic.setImageResource(dataSet.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}