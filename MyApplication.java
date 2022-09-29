package com.rxjava2.android.medicinealert;

import android.annotation.SuppressLint;
import android.app.Application;

import com.rxjava2.android.medicinealert.model.Events;
import com.rxjava2.android.medicinealert.ui.rxbus.RxBus;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MyApplication extends Application {

    public static final String TAG = "MyApplication";
    private RxBus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        bus = new RxBus();
    }

    public RxBus bus() {
        return bus;
    }

    @SuppressLint("CheckResult")
    public void sendAutoEvent() {
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribe(aLong -> bus.send(new Events.AutoEvent()));
    }

}
