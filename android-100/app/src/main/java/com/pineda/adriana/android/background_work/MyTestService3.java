package com.pineda.adriana.android.background_work;

import android.app.IntentService;
import android.app.NotificationManager;import android.content.Intent;import android.util.Log;
import androidx.annotation.Nullable;import androidx.core.app.NotificationCompat;import com.pineda.adriana.android.R;

public class MyTestService3 extends IntentService {
    private static final String TAG = MyTestService3.class.getCanonicalName();
    public static final String MESSAGE = "message";

    public MyTestService3() {
        super("test-service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "***** onHandleIntent");

        String externalMessage = intent.getStringExtra(MESSAGE);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("hello!")
                .setContentText(externalMessage)
                .setAutoCancel(true);
    }
}
