package com.example.isd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int firstMemberInt;
    public int secondMemberInt;

    public String mathOper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void num(View view){
        TextView textField = findViewById(R.id.textField);

        Button numBtn = findViewById(view.getId());

        textField.setText((String) textField.getText() + numBtn.getText());
    }

    public void mathOper(View view){
        TextView textField = findViewById(R.id.textField);
        TextView history = findViewById(R.id.history);

        String text = (String) textField.getText();

        if(!mathOper.equals("")){
            textField.setText(text.substring(0, text.length()-3));
        }

        mathOper = (String)((Button)findViewById(view.getId())).getText();
        firstMemberInt = Integer.parseInt((String)textField.getText());
        history.setText(firstMemberInt + " " + mathOper+ " ");
        textField.setText("");
    }

    public void eq(View view){
        TextView textField = findViewById(R.id.textField);
        TextView result = findViewById(R.id.result);
        TextView history = findViewById(R.id.history);

        secondMemberInt = Integer.parseInt((String)textField.getText());

        switch (mathOper){
            case "+":
                result.setText(Integer.toString(firstMemberInt + secondMemberInt));
                break;
            case "-":
                result.setText(Integer.toString(firstMemberInt - secondMemberInt));
                break;
            case "*":
                result.setText(Integer.toString(firstMemberInt * secondMemberInt));
                break;
            case "/":
                result.setText(Double.toString(firstMemberInt / (double)secondMemberInt));
                break;
            default:
                break;
        }
        history.setText((String)history.getText() + " " +secondMemberInt);
        textField.setText("");
        mathOper = "";
    }

    public void fullClear(View view){
        TextView textField = findViewById(R.id.textField);

        mathOper = "";
        firstMemberInt = 0;
        secondMemberInt = 0;

        textField.setText("");
    }
    public void clear(View view){
        TextView textField = findViewById(R.id.textField);
        TextView history = findViewById(R.id.history);

        String text = (String) textField.getText();

        if (!text.isEmpty()){
            if(!text.substring(text.length()-1, text.length()).matches("-?\\d+(\\.\\d+)?")){
                textField.setText(text.substring(0, text.length()-3));
                mathOper = "";
                return;
            } else {
                textField.setText(text.substring(0, text.length()-1));
            }
        }
    }
}