package com.pineda.adriana.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.pineda.adriana.android.background_work.MyTestService;
import com.pineda.adriana.android.background_work.MyTestService2;
import com.pineda.adriana.android.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private AppBarConfiguration appBarConfiguration;
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    setSupportActionBar(binding.toolbar);

    NavController navController =
        Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
    appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

    binding.fab.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show();
          }
        });

    // Services: Demo 1
    //    Intent intent = new Intent(this, MyTestService.class);
    //    startService(intent);

    // Services: Demo 2
    IntentFilter filter = new IntentFilter(MyTestService2.ACTION);
    LocalBroadcastManager.getInstance(this).registerReceiver(testReceiver, filter);
    // Not needed in this case given the lifecycle, but it can be used to prevent crashes
    isRegistered = true;
    // or `registerReceiver(testReceiver, filter)` for a normal broadcast
    // Start the IntentService
    Intent intent = new Intent(this, MyTestService2.class);
    intent.putExtra("foo", "bar");
    startService(intent);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    // Unregister the listener when the application is paused
    if (!isRegistered) {
      // The if is needed, because we will get an exception if we try to unregister a non-registered
      // receiver
      LocalBroadcastManager.getInstance(this).unregisterReceiver(testReceiver);
      isRegistered = false;
    }
  }

  boolean isRegistered = false;

  private BroadcastReceiver testReceiver =
      new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
          int resultCode = intent.getIntExtra("resultCode", RESULT_CANCELED);
          if (resultCode != RESULT_OK) {
            return;
          }

          String resultValue = intent.getStringExtra("resultValue");

          // This can only be done in the UI thread
          //          TextView textView = (TextView) findViewById(R.id.my_textView);
          //          textView.setText(resultValue);
        }
      };

  // Services: Demo 3 -> Notification
  private void setShowNotificationButton() {
    Button button = (Button) findViewById(R.id.show_notification);
    button.setVisibility(View.VISIBLE);
    button.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {
      Intent intent = new Intent(MainActivity.this, MyTestService3.class);
      intent.putExtra(MyTestService3.MESSAGE, "Greetings from Class 48");
      startService(intent);
      finish();
    }});
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onSupportNavigateUp() {
    NavController navController =
        Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
    return NavigationUI.navigateUp(navController, appBarConfiguration)
        || super.onSupportNavigateUp();
  }
}
