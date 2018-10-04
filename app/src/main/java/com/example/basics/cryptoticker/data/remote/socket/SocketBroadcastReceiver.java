package com.example.basics.cryptoticker.data.remote.socket;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static android.content.Context.ACTIVITY_SERVICE;

public class SocketBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(!isServiceRunning(context))
            context.startService(new Intent(context, SocketService.class));

        Log.wtf("Socket service ","Checked");
    }

    private boolean isServiceRunning(Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)){
            if("com.example.basics.cryptoticker.data.remote.socket.SocketService".equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
