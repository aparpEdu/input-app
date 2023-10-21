package com.example.a4uprmb.validation;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class Validator implements TextWatcher {
    private final ValidationHelper validationHelper;
    private final TextInputLayout textInputLayout;
    private final Button button;

    public Validator(TextInputLayout textInputLayout, Button button) {
        this.button = button;
        this.validationHelper = new ValidationHelper();
        this.textInputLayout = textInputLayout;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        String email = textInputLayout.getEditText().getText().toString();
        if (!validationHelper.isEmailValid(email)){
            textInputLayout.setError("Please input valid email");
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
            textInputLayout.setError(null);
        }
    }
}
