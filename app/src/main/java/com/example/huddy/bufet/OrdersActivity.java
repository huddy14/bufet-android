package com.example.huddy.bufet;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OrdersActivity extends AppCompatActivity implements ServiceConnection {

    private OrdersService mService;
    private boolean isBound = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this,OrdersService.class);
        bindService(intent, this, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        OrdersService.myBinder binder = (OrdersService.myBinder) service;
        mService = binder.getService();
        isBound = true;
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        isBound = false;
    }
}
