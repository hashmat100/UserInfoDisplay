package com.sample11.main.network;

/**
 * Created by Ashmath Khan on 15-10-2018.
 * Class to store json info from get user info API
 * (Getters added only to the required fields now)
 */
public class GetUserInfoVO {

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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

}
