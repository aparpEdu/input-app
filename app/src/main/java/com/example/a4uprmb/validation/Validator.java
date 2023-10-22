package com.example.a4uprmb.validation;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class Validator implements TextWatcher {
    private final ValidationStrategy validationStrategy;
    private final TextInputLayout[] textInputLayout;
    private final Button button;

    public Validator(ValidationStrategy validationStrategy, Button button, TextInputLayout... textInputLayout) {
        this.validationStrategy = validationStrategy;
        this.button = button;
        this.textInputLayout = textInputLayout;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        validationStrategy.isValid(button, textInputLayout);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
