package com.example.a4uprmb;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;
    private final String activityName;

    public BaseActivity(){
        activityName = this.getClass().getSimpleName();
    }

    @Override
    public void onClick(View view) {
        if (intent != null){
            startActivity(intent);
        } else {
            Log.e(activityName, "Intent was recorded to be null");
        }
    }

    @Override
    public void setIntent(Intent intent) {
        this.intent = intent;
    }



    public abstract Intent createIntent();
}

