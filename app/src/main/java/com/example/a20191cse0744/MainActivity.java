package com.example.a20191cse0744;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    CheckBox cb_1_744;
    CheckBox cb_2_744;
    CheckBox cb_3_744;
    CheckBox cb_4_744;
    CheckBox cb_5_744;

    TextInputLayout qty1_744;
    TextInputLayout qty2_744;
    TextInputLayout qty3_744;
    TextInputLayout qty4_744;
    TextInputLayout qty5_744;

    TextInputLayout name_744;
    TextInputLayout number_744;
    Button btn_submit_744;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_submit_744 = findViewById(R.id.btn_submit);
        cb_1_744 = findViewById(R.id.cb_1);
        cb_2_744 = findViewById(R.id.cb_2);
        cb_3_744 = findViewById(R.id.cb_3);
        cb_4_744 = findViewById(R.id.cb_4);
        cb_5_744 = findViewById(R.id.cb_5);

        qty1_744 = findViewById(R.id.et_qty_1);
        qty2_744 = findViewById(R.id.et_qty_2);
        qty3_744 = findViewById(R.id.et_qty_3);
        qty4_744 = findViewById(R.id.et_qty_4);
        qty5_744 = findViewById(R.id.et_qty_5);
        name_744 = findViewById(R.id.et_name);
        number_744 = findViewById(R.id.et_mobile);

        btn_submit_744.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit_744();
            }
        });
    }

    private void submit_744() {
        StringBuilder sb = new StringBuilder();
        int total = getTotal744();
        if (total <= 0) {
            Toast.makeText(this, "Select at-least one item", Toast.LENGTH_SHORT).show();
            return;
        }

        String name = name_744.getEditText().getText().toString();
        String number = number_744.getEditText().getText().toString();
        sb.append(getValue744(cb_1_744, qty1_744, 50));
        sb.append(getValue744(cb_2_744, qty2_744, 250));
        sb.append(getValue744(cb_3_744, qty3_744, 200));
        sb.append(getValue744(cb_4_744, qty4_744, 100));
        sb.append(getValue744(cb_5_744, qty5_744, 200));

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("number", number);
        intent.putExtra("item", sb.toString());
        intent.putExtra("total", String.valueOf(total));
        startActivity(intent);
    }

    private int getRate(CheckBox cb, int rate, int qty) {
        if (cb.isChecked()) return rate * qty;
        return 0;
    }

    private int getTotal744() {
        int total = 0;
        total += getRate(cb_1_744, 50, getQty(qty1_744));
        total += getRate(cb_2_744, 250, getQty(qty2_744));
        total += getRate(cb_3_744, 200, getQty(qty3_744));
        total += getRate(cb_4_744, 100, getQty(qty4_744));
        total += getRate(cb_5_744, 200, getQty(qty5_744));
        return total;
    }

    private String getValue744(CheckBox cb, TextInputLayout layout, int rate) {
        StringBuilder sb = new StringBuilder();
        if (cb.isChecked()) {
            sb.append(cb.getText().toString());
            int qty = getQty(layout);
            sb.append("\t\t");
            sb.append(qty).append(" x ").append(rate).append(" = ₹ ").append(rate * qty);
            sb.append("\n");
        }

        return sb.toString();
    }

    private int getQty(TextInputLayout layout) {
        try {
            String qty = layout.getEditText().getText().toString().trim();
            return Integer.parseInt(qty);
        } catch (Exception e) {
            return 0;
        }
    }
}