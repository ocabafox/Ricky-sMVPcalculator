package com.android3.ocabafox.mvpcalculator.SecondActivity;

/**
 * Created by ocabafox on 7/18/2015.
 */
public class resultPresenter implements iResultPresentor, iResultListener{
    iResultView view;
    resultModel model;

    public resultPresenter(iResultView view){
        this.view = view;
        this.model = new resultModel();
    }

    @Override
    public void getIntent() {
        view.getMyIntent();
    }

    @Override
    public void decision(String error) {
        model.validation(this,error);
    }


    @Override
    public void successListener() {
        view.success();
    }

    @Override
    public void failedListener() {
        view.error();
    }
}
