package com.example.a4uprmb.validation;

import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public interface ValidationStrategy {
    void isValid(Button button, TextInputLayout... textInputLayout);
}
