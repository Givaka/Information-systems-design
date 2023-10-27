package com.example.isd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View plusBtnView    = findViewById(R.id.plus_button);
        View minusBtnView   = findViewById(R.id.minus_button);

        TextView clicksText = findViewById(R.id.clicksText);

        Button plusBtn  = plusBtnView.findViewById(R.id.clickBtn);
        Button minusBtn = minusBtnView.findViewById(R.id.clickBtn);

        plusBtn.setText("+");
        minusBtn.setText("-");

        plusBtn.setOnClickListener(v -> {clicksText.setText(++clicks + " Clicks");});
        minusBtn.setOnClickListener(v -> {clicksText.setText(--clicks + " Clicks");});
    }
}