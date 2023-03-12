package com.pineda.adriana.android.background_work;

import android.app.IntentService;
import android.content.Intent;import android.util.Log;
import androidx.annotation.Nullable;

public class MyTestService extends IntentService {
  private static final String TAG = MyTestService.class.getCanonicalName();

  public MyTestService() {
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
  }
}
