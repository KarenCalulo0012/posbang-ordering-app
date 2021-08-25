package com.example.simplemenuorderingapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplemenuorderingapplication.Activity.CategoryActivity;
import com.example.simplemenuorderingapplication.Activity.MenuActivity;
import com.example.simplemenuorderingapplication.Model.Categories;
import com.example.simplemenuorderingapplication.Model.Food;
import com.example.simplemenuorderingapplication.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {
    private ArrayList<Food> dataSet;

    public FoodAdapter(ArrayList<Food> data_food) {
        this.dataSet = data_food;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView FoodName, Price, Tax;
        ImageView FoodPic;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.FoodName = (TextView) itemView.findViewById(R.id.foodName);
            this.Price = (TextView) itemView.findViewById(R.id.foodPrice);
            this.Tax = (TextView) itemView.findViewById(R.id.foodTax);
            this.FoodPic = (ImageView) itemView.findViewById(R.id.foodsImage);
        }
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menulist_layout, parent, false);

        view.setOnClickListener(MenuActivity.myOnClickListener);

        FoodAdapter.MyViewHolder myViewHolder = new FoodAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FoodAdapter.MyViewHolder holder, int position) {
        TextView FoodName = holder.FoodName;
        TextView Price = holder.Price;
        TextView Tax = holder.Tax;
        ImageView FoodPic = holder.FoodPic;

        FoodName.setText(dataSet.get(position).getFoodName());
        Price.setText(Integer.toString(dataSet.get(position).getFoodPrice()));
        Tax.setText(Integer.toString(dataSet.get(position).getFoodTax()));
        FoodPic.setImageResource(dataSet.get(position).getFoodPic());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
