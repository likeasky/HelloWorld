package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddActivity extends AppCompatActivity {
    private final String TAG = "AddActivity";
    public static final String EXTRA_NAME_ANNIVERSAY = "com.example.helloworld.anniversary";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        final Spinner spinnerMonth = (Spinner) findViewById(R.id.spinnerMonth);
        String[] months = new String[12];
        for (int i = 0; i < 12; i++) {
            months[i] = i + 1 + "";
        }
        ArrayAdapter monthAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, months);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(monthAdapter);

        final Spinner spinnerDay = (Spinner) findViewById(R.id.spinnerDay);
        Integer[] days = new Integer[31];
        for (int i = 0; i < 31; i++) {
            days[i] = i + 1;
        }
        ArrayAdapter<Integer> dayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, days);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(dayAdapter);


        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        spinnerMonth.setSelection(monthAdapter.getPosition(Integer.toString(month)));
        spinnerDay.setSelection(dayAdapter.getPosition(Integer.valueOf(day)));

        Button btn = (Button) findViewById(R.id.btCancel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button btnConfirm = (Button) findViewById(R.id.btConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
           public void onClick(View view) {
               EditText etTitle = (EditText) findViewById(R.id.etTitle);
               String title = etTitle.getText().toString();
               if (TextUtils.isEmpty(title)) {
                   etTitle.setError(getString(R.string.formErrorTitle));
                   return;
               }

               Calendar calendar = new GregorianCalendar(2000, Integer.parseInt((String) spinnerMonth.getSelectedItem()), (int) spinnerDay.getSelectedItem());

               boolean isSolar = true;
               RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
               switch (radioGroup.getCheckedRadioButtonId()) {
                   case R.id.rbSolar:
                       isSolar = true;
                       break;
                   case R.id.rbLunar:
                       isSolar = false;
                       break;
               }

               Anniversary anni = new Anniversary(title, calendar, isSolar);

               Intent intent = new Intent();
               intent.putExtra(EXTRA_NAME_ANNIVERSAY, anni);
               setResult(Activity.RESULT_OK, intent);
               finish();
           }
        });
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
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected()");
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
}
