package com.example.simplemenuorderingapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simplemenuorderingapplication.R;

public class OrderActivity extends AppCompatActivity {
    TextView newString, price;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_item);

        newString = findViewById(R.id.selectedFoodTitle);
        price = findViewById(R.id.order_price);
        imageView = findViewById(R.id.selectedImage);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("food");
            String k = (String) b.get("price");
            String l = (String) b.get("pic");
            newString.setText(j);
            price.setText(k);
//            imageView.setImageURI(l);
        }
    }
}