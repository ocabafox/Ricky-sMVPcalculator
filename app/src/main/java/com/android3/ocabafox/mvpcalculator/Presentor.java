package com.android3.ocabafox.mvpcalculator;

/**
 * Created by ocabafox on 7/17/2015.
 */
public class Presentor implements iPresentor,iListener {

    iView view;
    Model model;


    public Presentor(iView view){
        this.view = view;
        this.model = new Model();
    }

    @Override
    public void validateNumbers(String num1, String num2, String operant) {
        model.validate(this, num1, num2, operant);
        String firstNumber = model.convert(num1);
        String secondNumber = model.convert(num2);
        model.calculate(firstNumber,secondNumber,operant);
    }


    @Override
    public void errorFirstNumber() {
        view.errorFirstNumber_view();
    }

    @Override
    public void success(String num1, String num2,String ope, String result) {
        view.goToSecondActivity(num1, num2, ope, result);
    }


    @Override
    public void errorSecondNumber() {
        view.errorSecondNumber_view();
    }


}
