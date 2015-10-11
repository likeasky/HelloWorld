package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private static final int REQUEST_CODE_ADD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop()");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart()");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu()");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected()");
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.action_add: {
                Intent intent = new Intent(this, AddActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ADD);
//                startActivity(intent);
                return true;
            }
            case R.id.action_form_grid: {
                Intent intent = new Intent(this, FormGridActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.action_form_linear: {
                Intent intent = new Intent(this, FormLinearActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.action_form_relative: {
                Intent intent = new Intent(this, FormRelativeActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.action_form_table: {
                Intent intent = new Intent(this, FormTableActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult()");
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD && resultCode == Activity.RESULT_OK) {
//            Anniversary anni = data.getExtras().getParcelable(AddActivity.EXTRA_NAME_ANNIVERSAY);
//            Log.d(TAG, "title:" + anni.getTitle() + ", calendar:" + anni.getCalendar() + ", isSolar:" + anni.getIsSolar());
            Anniversary anni = data.getParcelableExtra(AddActivity.EXTRA_NAME_ANNIVERSAY);

            dbhelper.insert(anni);
        }
    }
}
