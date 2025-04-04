package com.mapwrappers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users {

    private String name;
    private int age;

    public String ToString() {

        return "User{"
                + "name = " + name + "\n"
                + " age = " + age
                + "}";
    }
}