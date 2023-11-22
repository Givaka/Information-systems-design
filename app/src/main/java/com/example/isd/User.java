package com.example.isd;

import androidx.annotation.NonNull;

public class User {
    private String name, age;

    public String getName(){
        return name;
    }

    public String getAge(){
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @NonNull
    @Override
    public String toString() {
        return  "User: " + name + " - " + age;
    }
}
