package com.android3.ocabafox.mvpcalculator.SecondActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android3.ocabafox.mvpcalculator.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ocabafox on 7/17/2015.
 */
public class Second_activity extends AppCompatActivity implements iResultView {
    String num1;
    String num2;
    String operator;
    String result;


    @Bind(R.id.tvNumber1) TextView getFirstNumber;
    @Bind(R.id.tvOperator) TextView getOperator;
    @Bind(R.id.tvNumber2) TextView getSecondNumber;
    @Bind(R.id.tvResult) TextView getResult;

    resultPresenter presentor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout_activity);
        ButterKnife.bind(this);
        presentor = new resultPresenter(this);
        presentor.getIntent();
        presentor.decision(result);
    }


    @Override
    public void error() {
        getResult.setText("Failed");
    }

    @Override
    public void success() {

    }

    @Override
    public void getMyIntent() {
        num1 = getIntent().getExtras().getString("firstnumber");
        num2 = getIntent().getExtras().getString("secondnumber");
        operator = getIntent().getExtras().getString("operator");
        result = getIntent().getExtras().getString("result");

        getFirstNumber.setText(num1);
        getOperator.setText(operator);
        getSecondNumber.setText(num2);
        getResult.setText(result);
    }
}
