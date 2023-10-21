package com.example.a4uprmb;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.a4uprmb.validation.Validator;
import com.google.android.material.textfield.TextInputLayout;

public class EmailActivity extends BaseActivity {
    EditText editText;
    TextInputLayout textInputLayout;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        editText = findViewById(R.id.email);
        textInputLayout = findViewById(R.id.textInputLayout);
        button = findViewById(R.id.submit);
        Validator validator = new Validator(textInputLayout, button);
        editText.addTextChangedListener(validator);
        button.setOnClickListener(view -> {
            setIntent(createIntent());
            onClick(button);
        });
    }

    @Override
    public Intent createIntent() {
        return new Intent(getApplicationContext(), PeopleActivity.class);
    }
}