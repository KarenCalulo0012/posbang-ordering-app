package com.example.simplemenuorderingapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simplemenuorderingapplication.R;

public class OrderActivity extends AppCompatActivity {
    TextView newString, price, quantityNo, tax, total;
    ImageView imageView;
    ImageButton plus, minus;
    Button addToCart;
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_item);

        newString = findViewById(R.id.selectedFoodTitle);
        price = findViewById(R.id.order_price);
        imageView = findViewById(R.id.selectedImage);
        addToCart = findViewById(R.id.AddToCart_btn);
        plus = findViewById(R.id.plus_imgbtn);
        minus = findViewById(R.id.minus_imgbtn);
        quantityNo = findViewById(R.id.noOrderText);
        tax = findViewById(R.id.order_tax);
        total = findViewById(R.id.itemsTotalPrice);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("food");
            String k = (String) b.get("price");
            String l = (String) b.get("pic");
            String m = (String) b.get("tax");

            newString.setText(j);
            price.setText(k);
            tax.setText(m);

//            imageView.setImageURI(l);
        }

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                displayQuantity();
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity == 0){
                    Toast.makeText(getApplicationContext(), "CANT DECREASE TO ZERO", Toast.LENGTH_SHORT).show();
                }else {
                    quantity --;
                    displayQuantity();
                }
            }
        });



        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, OrderListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void displayQuantity() {
        quantityNo.setText(String.valueOf(quantity));
    }
}