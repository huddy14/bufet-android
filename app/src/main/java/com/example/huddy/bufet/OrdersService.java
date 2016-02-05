package com.example.huddy.bufet;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class OrdersService extends Service {

    private final IBinder mBinder = new myBinder();
    public OrdersService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class myBinder extends Binder
    {
        OrdersService getService()
        {
            return OrdersService.this;
        }
    }
}
