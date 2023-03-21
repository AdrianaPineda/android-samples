package com.pineda.adriana.android.background_work;

import android.app.Activity;import android.app.IntentService;
import android.content.Intent;import android.util.Log;
import androidx.annotation.Nullable;import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MyTestService2 extends IntentService {
    private static final String TAG = MyTestService2.class.getCanonicalName();
    public static final String ACTION = "com.pineda.adriana.intent.action.MyTestService2";

    public MyTestService2() {
        super("test-service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "***** onHandleIntent");

        // Sleep, to show thread in Android Device Monitor
        try{
            Thread.sleep(3000L);
        } catch (Exception e) {
            // Ignore
        }

        Log.d(TAG, "***** Done");

        String val = intent.getStringExtra("foo");

        Intent broadcastIntent = new Intent(ACTION);
        broadcastIntent.putExtra("resultCode", Activity.RESULT_OK);
        broadcastIntent.putExtra("resultValue", "My Result Value. Passed in "+ val);

        LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent);
        // or sendBroadcast(in) for a global broadcast
    }
}
