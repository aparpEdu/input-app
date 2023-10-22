package com.example.a4uprmb.validation;

import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class PeopleValidation  implements ValidationStrategy{

    ValidationHelper validationHelper;

    public PeopleValidation() {
        this.validationHelper = new ValidationHelper();
    }

    @Override
    public void isValid(Button button, TextInputLayout... textInputLayouts) {
        for (TextInputLayout textInputLayout : textInputLayouts){
            if(textInputLayout.getEditText() != null) {
                String text = textInputLayout.getEditText().getText().toString();

                if (text.isEmpty() || text.startsWith(" ")) {
                    textInputLayout.setError("Cannot be left empty");
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                    textInputLayout.setError(null);
                }
            }

        }
        if(validationHelper.isNameValid(Objects
                .requireNonNull(textInputLayouts[0].getEditText()).getText().toString())){
            textInputLayouts[0].setError(null);
            button.setEnabled(true);
        } else {
            textInputLayouts[0].setError("Name must be between 2-100 characters long");
            button.setEnabled(false);
        }

        if (validationHelper.isAddressValid(Objects.requireNonNull(textInputLayouts[1]
                .getEditText()).getText().toString())){
            textInputLayouts[1].setError(null);
            button.setEnabled(true);
        } else {
            textInputLayouts[1].setError("Address must be between 5-255 symbols long");
            button.setEnabled(false);
        }

        if (validationHelper.isCityValid(Objects.requireNonNull(textInputLayouts[2]
                .getEditText()).getText().toString())){
            textInputLayouts[2].setError(null);
            button.setEnabled(true);
        } else {
            textInputLayouts[2].setError("City must be between 5-150 characters long");
            button.setEnabled(false);
        }

        if(validationHelper.isPhoneValid(Objects.requireNonNull(textInputLayouts[3]
                .getEditText()).getText().toString())){
            textInputLayouts[3].setError(null);
            button.setEnabled(true);
        } else {
            button.setEnabled(false);
            textInputLayouts[3].setError("Phone must be a valid number that starts with 08");
        }
    }
}
