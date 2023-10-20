package com.example.a4uprmb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends BaseActivity {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_email);
        editText = findViewById(R.id.email);
        button = findViewById(R.id.submit);
        createIntent();
        super.onClick(button);
    }

    @Override
    public Intent createIntent() {
        setIntent(new Intent(getApplicationContext(), PeopleActivity.class));
        return getIntent();
    }
}