package com.android3.ocabafox.mvpcalculator.SecondActivity;

/**
 * Created by ocabafox on 7/18/2015.
 */
public class resultModel implements iResultModel {
    resultPresenter presenter;


    @Override
    public void validation(iResultListener listener, String validate) {
        if(validate.equals("error")){
            listener.failedListener();
        }
        else{
            listener.successListener();
        }
    }
}
