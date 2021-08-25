package com.example.simplemenuorderingapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simplemenuorderingapplication.Adapter.CategoryAdapter;
import com.example.simplemenuorderingapplication.Adapter.FoodAdapter;
import com.example.simplemenuorderingapplication.Model.Categories;
import com.example.simplemenuorderingapplication.Model.Data.CategoryData;
import com.example.simplemenuorderingapplication.Model.Data.FoodData;
import com.example.simplemenuorderingapplication.Model.Food;
import com.example.simplemenuorderingapplication.R;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    TextView newString;
    public static View.OnClickListener myOnClickListener;
    private static RecyclerView recyclerView;
    private static ArrayList<Food> data_food;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        myOnClickListener = new MenuActivity.MyOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.food_RV);
        layoutManager = new LinearLayoutManager(this);

        newString = findViewById(R.id.categoryTitle);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("category");
            newString.setText(j);
        }
//Food(Integer id, String foodName, int foodPrice, int foodTax, int foodPic, Categories categories)
        data_food = new ArrayList<Food>();
        for (int i = 0; i < FoodData.foodName.length; i++){
            data_food.add(new Food(
                    FoodData.id[i],
                    FoodData.foodName[i],
                    FoodData.price[i],
                    FoodData.tax[i],
                    FoodData.foodPic[i]
//                    FoodData.category_id[i]
            ));
        }
        adapter = new FoodAdapter(data_food);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private class MyOnClickListener implements View.OnClickListener {
        private final Context context;
        public MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            int selectedItemPosition = recyclerView.getChildPosition(v);
            RecyclerView.ViewHolder viewHolder
                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
            TextView textViewName = (TextView) viewHolder.itemView.findViewById(R.id.foodName);
            String selectedName = (String) textViewName.getText();
            TextView price = (TextView) viewHolder.itemView.findViewById(R.id.foodPrice);
            String selectedPrice = (String) price.getText();
            ImageView imageView = (ImageView) viewHolder.itemView.findViewById(R.id.foodImage) ;

            Log.e("FOOD", "********" + selectedName);
            Intent intent = new Intent(MenuActivity.this, OrderActivity.class)
                    .putExtra("food", selectedName)
                    .putExtra("price", selectedPrice)
                    .putExtra("pic", String.valueOf(imageView));
            startActivity(intent);

        }
    }

}