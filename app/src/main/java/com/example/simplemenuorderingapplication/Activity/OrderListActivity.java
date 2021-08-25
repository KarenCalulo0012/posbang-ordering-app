package com.example.simplemenuorderingapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.simplemenuorderingapplication.R;

import Utils.AlertDialogManager;

public class OrderListActivity extends AppCompatActivity {
    Button checkOut;
    AlertDialogManager alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        alert = new AlertDialogManager();

        checkOut= findViewById(R.id.checkout_btn);


        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.showAlertDialog(OrderListActivity.this,
                        "ORDER SAVED",
                        "Do you want to Order Again?",
                        true);
//                dialogBox();
            }
        });
    }

    private void dialogBox() {


    }
}