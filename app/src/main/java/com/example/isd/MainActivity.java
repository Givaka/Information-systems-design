package com.example.isd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCheckBoxClick(View view) {
        CheckBox java   = findViewById(R.id.java);
        CheckBox kotlin = findViewById(R.id.kotlin);
        TextView selection = findViewById(R.id.selection);

        String selectedItems = "";

        if (java.isChecked())     selectedItems += java.getText()   + " ";
        if (kotlin.isChecked())   selectedItems += kotlin.getText() + " ";

        selection.setText(selectedItems);

    }
}