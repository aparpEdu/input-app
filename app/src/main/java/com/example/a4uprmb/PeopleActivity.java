package com.example.a4uprmb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a4uprmb.people.People;
import com.example.a4uprmb.validation.PeopleValidation;
import com.example.a4uprmb.validation.ValidationHelper;
import com.example.a4uprmb.validation.Validator;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class PeopleActivity extends BaseActivity {

    TextInputLayout name, address, city, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        Button back = findViewById(R.id.button2);
        Button next = findViewById(R.id.button);
        name = findViewById(R.id.textInputLayout2);
        address = findViewById(R.id.textInputLayout3);
        city = findViewById(R.id.textInputLayout4);
        phone = findViewById(R.id.phone);
        TextView email = findViewById(R.id.textView);

        email.setText(getIntent().getStringExtra("email"));

        Validator validator = new Validator(new PeopleValidation(), next, name,
                address, city, phone);
        ValidationHelper.setListeners(validator, name, address, city, phone);

        back.setOnClickListener(view -> onBackPressed());
        next.setOnClickListener(view -> {
            setIntent(createIntent());
            onClick(next);
        });

    }

    @Override
    public Intent createIntent() {
        return new Intent(getApplicationContext(), InfoActivity.class)
                .putExtra("people", new People(
                        Objects.requireNonNull(name.getEditText()).getText().toString(),
                        Objects.requireNonNull(phone.getEditText()).getText().toString(),
                        Objects.requireNonNull(address.getEditText()).getText().toString(),
                        Objects.requireNonNull(city.getEditText()).getText().toString(),
                        getIntent().getStringExtra("email")));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), EmailActivity.class));
    }
}