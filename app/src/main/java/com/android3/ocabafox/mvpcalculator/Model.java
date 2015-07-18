package com.android3.ocabafox.mvpcalculator;

import android.os.Handler;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by ocabafox on 7/17/2015.
 */
public class Model implements iModel {

    double temp;
    double res;
    String number1,number2,operant;
    String errorOrNot;

    @Override
    public void validate(final iListener listener, final String num1, final String num2, final String operant) {

        this.number1 = num1;
        this.number2 = num2;
        this.operant = operant;

        number1 = convert(num1);
        number2 = convert(num2);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(num1.trim().equals("")){
                    listener.errorFirstNumber();
                }
                else if(num2.trim().equals("")){
                    listener.errorSecondNumber();
                }
                else{
                    errorOrNot = calculate(number1,number2,operant);
                    listener.success(number1,number2,operant,errorOrNot);
                }
            }
        },1000);
    }


    public String calculate(String num1, String num2, String operant) {
        try {
            double number1, number2, result;
            number1 = Double.parseDouble(num1);
            number2 = Double.parseDouble(num2);
            if (operant.equals("+")) {
                result = number1 + number2;
                return "" + result;
            } else if (operant.equals("-")) {
                result = number1 - number2;
                return "" + result;
            } else if (operant.equals("/")) {
                result = number1 / number2;
                return "" + result;
            } else if (operant.equals("x")) {
                result = number1 * number2;
                return "" + result;
            } else {
                return "error";
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
            return "error";
        }
    }

    public String convert(String convert) {
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        Number number = null;
        try {
            number = format.parse(convert);
            return number.doubleValue() + "";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convert;
    }
}


