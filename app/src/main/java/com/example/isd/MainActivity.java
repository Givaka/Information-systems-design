package com.example.isd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        EditText nameText       = findViewById(R.id.name);
        EditText companyText    = findViewById(R.id.company);
        EditText ageText        = findViewById(R.id.age);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name",     nameText.getText().toString());
        intent.putExtra("company",  companyText.getText().toString());
        intent.putExtra("age",      Integer.parseInt(ageText.getText().toString()));

        startActivity(intent);
    }
}