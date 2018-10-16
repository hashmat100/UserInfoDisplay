package com.sample11.main.network;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.sample11.main.BR;

/**
 * Created by Ashmath Khan on 15-10-2018.
 * Class to store json info from get user info API
 * (Getters/Setters added only to the required fields now)
 */
public class GetUserInfoVO extends BaseObservable {

    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;

    private String phone;
    private String website;
    private Company company;

    public static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;
    }

    public static class Geo {
        private String lat;
        private String lng;
    }

    private static class Company {
        private String name;
        private String catchPhrase;
        private String bs;
    }

    @Bindable
    public int getId() {
        return id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }

}
