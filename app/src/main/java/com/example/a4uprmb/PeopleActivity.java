package com.example.a4uprmb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PeopleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        Button back = findViewById(R.id.button2);
        back.setOnClickListener(view -> onBackPressed());

    }

    @Override
    public Intent createIntent() {
        return null;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), EmailActivity.class));
    }
}