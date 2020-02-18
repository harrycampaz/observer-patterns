package com.dezzapps.observer_patterns;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;

import com.dezzapps.observer_patterns.models.Observer;
import com.dezzapps.observer_patterns.models.Order;
import com.dezzapps.observer_patterns.models.Sandwich;

public class MainActivity extends AppCompatActivity {

    Sandwich sandwich = new Sandwich();
    Observer order = new Order(sandwich);

    int notificationID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onOrderClick(View v){
        sandwich.register(order);

        sendNotification(order.update());
    }


    public void onUpdateClick(View v){
        sandwich.setReady(true);
        sendNotification(order.update());
    }

    public void sendNotification(String message){
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Sandwich Builder")
                        .setContentText(message);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        manager.notify(notificationID, builder.build());

        notificationID++;
    }

}
