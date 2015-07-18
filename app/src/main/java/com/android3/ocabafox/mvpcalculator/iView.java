package com.android3.ocabafox.mvpcalculator;

/**
 * Created by ocabafox on 7/17/2015.
 */
public interface iView {
    void goToSecondActivity(String num1,String num2,String operator, String result);
    void errorSecondNumber_view();
    void errorFirstNumber_view();
    void clearNumber();
}
