package com.example.simplemenuorderingapplication.Adapter;

import android.util.Log;
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

    private final ArrayList<Categories> dataSet;

    public CategoryAdapter(ArrayList<Categories> data) {
        this.dataSet = data;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCategoryName;
        ImageView imageViewCategoryPic;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewCategoryName = itemView.findViewById(R.id.textViewName);
            this.imageViewCategoryPic = itemView.findViewById(R.id.foodImage);

            String name = textViewCategoryName.getText().toString();
            String pic = String.valueOf(imageViewCategoryPic.getDrawable());
        }
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        view.setOnClickListener(CategoryActivity.myOnClickListener);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull CategoryAdapter.MyViewHolder holder, int position) {
       Categories categories = dataSet.get(position);
        holder.textViewCategoryName.setText(categories.getCategoryName());
        holder.imageViewCategoryPic.setImageResource(categories.getImage());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
