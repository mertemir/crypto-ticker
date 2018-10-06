package com.example.basics.cryptoticker.ui.Alarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;

import com.example.basics.cryptoticker.App;
import com.example.basics.cryptoticker.R;
import com.example.basics.cryptoticker.data.db.entity.AlarmEntity;

public class AlarmChecker {

    public static void checkAlarms(Context context){

        App.cryptoDatabase.cryptoDao().getCoin().observeForever(coinData -> {
            if(!App.cryptoDatabase.alarmDao().getAlarmsList().isEmpty())
            {
                for (AlarmEntity a : App.cryptoDatabase.alarmDao().getAlarmsList())
                {
                    if(a.getAndHigher() == 1)
                    {
                        if(Double.parseDouble(coinData.getLast()) >= a.getPrice())
                        {
                            pushNotification(a, context);
                            App.cryptoDatabase.alarmDao().deleteAlarm(a);
                        }
                    }
                    else if(a.getAndHigher() == 0)
                    {
                        if(Double.parseDouble(coinData.getLast()) <= a.getPrice())
                        {
                            pushNotification(a, context);
                            App.cryptoDatabase.alarmDao().deleteAlarm(a);
                        }
                    }
                }
            }
        });

    }

    public static void pushNotification(AlarmEntity alarm, Context context)
    {
        NotificationManager notif=(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notify=new Notification.Builder
                (context).setContentTitle("Bitcoin Alarm").setContentText("Your alarm at $" + alarm.getPrice() + " has triggered.")
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.btc))
                .setSmallIcon(R.drawable.alarm_notification)
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(Notification.PRIORITY_MAX).build();

        notify.flags |= Notification.FLAG_AUTO_CANCEL;
        notif.notify(0, notify);
    }
}
