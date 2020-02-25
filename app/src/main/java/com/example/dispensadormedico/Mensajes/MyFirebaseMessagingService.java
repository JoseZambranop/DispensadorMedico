package com.example.dispensadormedico.Mensajes;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
import android.view.Menu;

import com.example.dispensadormedico.Menu.activity_menu;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Random;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public static final String TAG = MyFirebaseMessagingService.class.getSimpleName();
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String mensaje = remoteMessage.getData().get("mensaje");
        String hora = remoteMessage.getData().get("hora");
        String emisorname = remoteMessage.getData().get("emisor");
        String emisortoken = remoteMessage.getData().get("token_emisor");
        if(!emisortoken.equals( FirebaseInstanceId.getInstance().getToken())){
            showNotification2("noticia","noticia");
            Mensaje(mensaje,hora,emisorname);
            Log.d(TAG, "¡Mensaje recibido!");
        }
    }

    private void showNotification2(String cabezera, String cuerpo){
        Intent i = new Intent(this, activity_menu.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_ONE_SHOT);
        Uri soundNotification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setAutoCancel(true);
        builder.setContentTitle(cabezera);
        builder.setContentText(cuerpo);
        builder.setSound(soundNotification);
        //builder.setSmallIcon(R.drawable.android_firebase_notifications);
        builder.setTicker(cuerpo);
        builder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Random random = new Random();
        notificationManager.notify(random.nextInt(),builder.build());
    }

    private void Mensaje(String mensaje,String hora,String emisor){
       /* Intent i = new Intent(MainActivity.MENSAJEs);
        i.putExtra("key_mensaje",mensaje);
        i.putExtra("key_hora",hora);
        i.putExtra("key_emisor",emisor);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(i);*/
    }
}
