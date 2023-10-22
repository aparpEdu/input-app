package com.example.a4uprmb.validation;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class ValidationHelper {

    public boolean isEmailValid(String email){
        return email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    }

    public static void setListeners(Validator validator, TextInputLayout... textInputLayouts){
        for (TextInputLayout textInputLayout: textInputLayouts) {
            Objects.requireNonNull(textInputLayout.getEditText()).addTextChangedListener(validator);
        }
    }
    public boolean isNameValid(String name) {
        return name.length() > 1 && name.length() < 101;
    }

    public boolean isAddressValid(String address) {
        return address.length() > 4 && address.length() < 256;
    }

    public boolean isCityValid(String city) {
        return city.length() > 4 && city.length() < 151;
    }

    public boolean isPhoneValid(String phone) {
        return phone.length() == 10 && phone.startsWith("08");
    }
}
