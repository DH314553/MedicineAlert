package com.rxjava2.android.medicinealert;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {

    public static Calendar calendar;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        Button backButton = findViewById(R.id.back);
        Intent backIntent = new Intent(AlarmActivity.this, MainActivity.class);
        LocalDateTime dateTime = LocalDateTime.now();
        int hour = dateTime.getHour();
        int minute = dateTime.getMinute();
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        TextView textView = findViewById(R.id.textView);
        if (hour == 11 && minute == 12) {
            calendar.set(Calendar.HOUR_OF_DAY, 8);
            textView.setText("朝のお薬の時間です。");
            textView.setTextSize(50);
        } else if (hour == 12 && minute == 0) {
            calendar.set(Calendar.HOUR_OF_DAY, 12);
            textView.setText("昼のお薬の時間です。");
            textView.setTextSize(50);
        } else if (hour == 19 && minute == 0) {
            calendar.set(Calendar.HOUR_OF_DAY, 19);
            textView.setText("夜のお薬の時間です。");
            textView.setTextSize(50);
        }
        backIntent.putExtra("タイム", calendar.getTimeInMillis());
        backButton.setOnClickListener(v -> {
            startActivity(backIntent);
        });
        backButton.setOnClickListener(v -> finish());
    }
}