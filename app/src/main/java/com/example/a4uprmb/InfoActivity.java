package com.example.a4uprmb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.a4uprmb.people.People;

import org.w3c.dom.Text;

public class InfoActivity extends BaseActivity {
    TextView email, name, phone, address, city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        email = findViewById(R.id.emailView);
        name = findViewById(R.id.textView2);
        phone = findViewById(R.id.textView5);
        address = findViewById(R.id.textView3);
        city = findViewById(R.id.textView4);
        Button back = findViewById(R.id.button3);
        Button map = findViewById(R.id.button4);

        People person = getIntent().getParcelableExtra("people");
        assert person != null;
        email.setText(person.getEmail());
        name.setText(person.getName());
        phone.setText(person.getPhone());
        address.setText(person.getAddress());
        city.setText(person.getCity());

        back.setOnClickListener(view -> onBackPressed());
        map.setOnClickListener(view -> {
            setIntent(createIntent());
            onClick(map);
        });


    }

    @Override
    public Intent createIntent() {
        String addressQuery = city.getText().toString() + " " + address.getText().toString();
        Uri searchQuery = Uri.parse("geo:0,0?q=" + Uri.encode(addressQuery));

        Intent intent = new Intent(Intent.ACTION_VIEW, searchQuery);
        intent.setPackage("com.google.android.apps.maps");
        return intent;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), PeopleActivity.class));
    }
}