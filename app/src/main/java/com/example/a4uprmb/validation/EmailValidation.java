package com.example.a4uprmb.validation;

import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class EmailValidation implements ValidationStrategy{
    @Override
    public void isValid(Button button, TextInputLayout... textInputLayout) {
        ValidationHelper validationHelper = new ValidationHelper();
        String email  =  Objects.requireNonNull(textInputLayout[0].getEditText()).getText().toString();
        if (validationHelper.isEmailValid(email)){
            textInputLayout[0].setError(null);
            button.setEnabled(true);
        } else {
            textInputLayout[0].setError("Must be a valid email");
            button.setEnabled(false);
        }
    }
}
