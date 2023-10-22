package com.example.a4uprmb.people;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class People implements Parcelable {
    private final String name;
    private final String phone;
    private final String address;
    private final String city;
    private final String email;

    public People(String name, String phone, String address, String city, String email) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.email = email;
    }

    protected People(Parcel in) {
        name = in.readString();
        phone = in.readString();
        address = in.readString();
        city = in.readString();
        email = in.readString();
    }

    public static final Creator<People> CREATOR = new Creator<People>() {
        @Override
        public People createFromParcel(Parcel in) {
            return new People(in);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(phone);
        parcel.writeString(address);
        parcel.writeString(city);
    }
}
