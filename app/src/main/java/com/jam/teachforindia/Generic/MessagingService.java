package com.jam.teachforindia.Generic;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.jam.teachforindia.Activities.MainActivity;
import com.jam.teachforindia.R;


/**
 * Created by Jam on 27-02-2018.
 */

public class MessagingService extends FirebaseMessagingService {


    private static final String TAG = "123456";

    @Override
    public void onMessageReceived(final RemoteMessage remoteMessage) {

        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
                //scheduleJob();
            } else {
                // Handle message within 10 seconds
                //handleNow();
            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());

            Bitmap b = BitmapFactory.decodeResource(this.getResources(),R.drawable.pen);

//            NotificationManager m = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//            Notification noti = new NotificationCompat.Builder(this,"1")
//                    .setContentTitle("New mail from " + "Jamian")
//                    .setContentText(remoteMessage.getNotification().getBody())
//                    .setSmallIcon(R.drawable.net)
//                    .setLargeIcon(b)
//                    .build();
//
//
//            m.notify(123,noti);

            String CHANNEL_ID = "JAM";


            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.pen)
                    .setContentTitle(remoteMessage.getNotification().getTitle())
                    .setContentIntent(pendingIntent)
                    .setContentText(remoteMessage.getNotification().getBody())
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);//NotificationManager.from(this);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // Create the NotificationChannel, but only on API 26+ because
                // the NotificationChannel class is new and not in the support library
                CharSequence name = getString(R.string.app_name);
                String description = getString(R.string.app_name);
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_HIGH);
                channel.setDescription(description);
                notificationManager.createNotificationChannel(channel);
            }

            // Register the channel with the system


            notificationManager.notify(001,mBuilder.build());

        }

    }
}
