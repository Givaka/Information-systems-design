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

    public void onCheckBoxClick(View view){
        CheckBox checkBox = (CheckBox) view;
        TextView selection = findViewById(R.id.selection);

        if(checkBox.isChecked()){
            selection.setText("Включено");
            checkBox.setText("Выключить");
        } else {
            selection.setText("Выключено");
            checkBox.setText("Включить");
        }
    }
}