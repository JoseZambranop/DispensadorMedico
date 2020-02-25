package com.example.dispensadormedico.Mensajes;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    public static final String TAG = MyFirebaseInstanceIdService.class.getSimpleName();
    public static final String TOPIC_GLOBAL = "global";
    public MyFirebaseInstanceIdService() {}
    @Override
    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
    Log.d(TAG, "Token: " + token);
    FirebaseMessaging.getInstance().subscribeToTopic(TOPIC_GLOBAL);
    enviarTokenAlServidor(token);
}
private void enviarTokenAlServidor(String token) {
    // Enviar token al servidor
    }
    }