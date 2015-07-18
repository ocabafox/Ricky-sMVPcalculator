package com.android3.ocabafox.mvpcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android3.ocabafox.mvpcalculator.SecondActivity.Second_activity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements iView {

    @Bind(R.id.first_number) EditText first_number;
    @Bind(R.id.second_number) EditText second_number;
    @Bind(R.id.toolbar) Toolbar toolbar;
    String number1,number2;

    Presentor presentor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        presentor = new Presentor(this);

    }

    @OnClick({R.id.btnPlus,R.id.btnMinus,R.id.btnMultiply,R.id.btnDivide,R.id.btnClear,R.id.btnExit})
    public void getClick(View view){
        if(view.getId() == R.id.btnPlus){
            number1 = first_number.getText().toString();
            number2 = second_number.getText().toString();

            presentor.validateNumbers(number1,number2,"+");
        }
        else if(view.getId() == R.id.btnMinus){
            number1 = first_number.getText().toString();
            number2 = second_number.getText().toString();

            presentor.validateNumbers(number1, number2, "-");
        }
        else if(view.getId() == R.id.btnMultiply){
            number1 = first_number.getText().toString();
            number2 = second_number.getText().toString();

            presentor.validateNumbers(number1, number2, "x");
        }
        else if(view.getId() == R.id.btnDivide){
            number1 = first_number.getText().toString();
            number2 = second_number.getText().toString();

            presentor.validateNumbers(number1, number2, "/");
        }
        else if(view.getId() == R.id.btnClear){
            first_number.setText("");
            second_number.setText("");

        }
        else if(view.getId() == R.id.btnExit){
            finish();
        }
    }


    @Override
    public void goToSecondActivity(String num1, String num2, String operant, String result) {
        Intent intent = new Intent(this, Second_activity.class);
        intent.putExtra("firstnumber",num1);
        intent.putExtra("secondnumber",num2);
        intent.putExtra("operator",operant);
        intent.putExtra("result",result);
        startActivity(intent);
    }

    @Override
    public void errorSecondNumber_view() {
        first_number.setError("Enter Second number");
    }

    @Override
    public void errorFirstNumber_view() {
        first_number.setError("Enter First number");
    }

    @Override
    public void clearNumber() {

        Toast.makeText(this,"Clear all",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        first_number.setFocusableInTouchMode(true);
        first_number.requestFocus();
    }
}
