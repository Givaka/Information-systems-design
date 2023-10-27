package com.example.isd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout layout = new ConstraintLayout(this);

        TextView textView = new TextView(this);
        textView.setText("Hello Android");
        textView.setTextSize(26);

        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams( ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;

        textView.setLayoutParams(layoutParams);
        layout.addView(textView);

        setContentView(layout);
    }
}