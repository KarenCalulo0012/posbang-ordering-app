package com.example.simplemenuorderingapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.simplemenuorderingapplication.Adapter.CategoryAdapter;
import com.example.simplemenuorderingapplication.Model.Categories;
import com.example.simplemenuorderingapplication.Model.Data.CategoryData;
import com.example.simplemenuorderingapplication.R;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
    public static View.OnClickListener myOnClickListener;
    private static RecyclerView recyclerView;
    private static ArrayList<Categories> data;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    CategoryData categoryData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        myOnClickListener = new MyOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.category_RV);
        layoutManager = new LinearLayoutManager(this);


        data = new ArrayList<Categories>();
        for (int i = 0; i < CategoryData.categoryName.length;i++){
            data.add(new Categories(
                    CategoryData.id[i],
                    CategoryData.categoryName[i],
                    CategoryData.categoryPic[i]
            ));
        }
        adapter = new CategoryAdapter(data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }


    public class MyOnClickListener implements View.OnClickListener {
        private final Context context;

        public MyOnClickListener(Context context) {
            this.context = context;

        }

        @Override
        public void onClick(View v) {
            int selectedItemPosition = recyclerView.getChildPosition(v);
            RecyclerView.ViewHolder viewHolder
                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
            TextView textViewName
                    = (TextView) viewHolder.itemView.findViewById(R.id.textViewName);
            String selectedName = (String) textViewName.getText();

            Log.e("KINEME", "********" + selectedName);
                    Intent intent = new Intent(CategoryActivity.this, MenuActivity.class)
                    .putExtra("category", selectedName);
            startActivity(intent);

        }
    }
}