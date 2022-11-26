package com.example.a20191cse0744;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView tv_details744;
    Button btnConfirm_744;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        btnConfirm_744 = findViewById(R.id.btn_confirm);
        tv_details744 = findViewById(R.id.tv_details);
        StringBuilder sb = new StringBuilder();
        sb.append("Customer Name : \t").append(getValue("name")).append("\n");
        sb.append("Customer Number : \t").append(getValue("number")).append("\n");
        sb.append("Items : \n").append(getValue("item")).append("\n");
        sb.append("Total : \t").append(getValue("total"));
        tv_details744.setText(sb.toString());
        btnConfirm_744.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(DetailsActivity.this).setTitle("Confirmed")
                        .setMessage("Order Confirmed")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                DetailsActivity.super.onBackPressed();
                                dialogInterface.dismiss();
                            }
                        });
                alert.create().show();
            }
        });
    }

    String getValue(String key) {
        return getIntent().getStringExtra(key);
    }
}