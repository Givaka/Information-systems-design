package com.example.isd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        LayoutInflater inflater = getLayoutInflater();
        View laout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.toast_layout));

        TextView text = laout.findViewById(R.id.text);
        text.setText("Hello Android!");

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(laout);
        toast.show();
    }
}