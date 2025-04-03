package com.collections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private int code;
    private String name;

    @Override
    public boolean equals(Object obj) {

        boolean isEquals = false;
        if(obj instanceof User user) {

            if(this == user) isEquals = true;
            if(this.code == user.code && Objects.equals(this.name, user.name)) isEquals = true;
        }
            return isEquals;
    }

    public String ToString() {

        return String.format("{ 'code' : %s, 'name: %s", this.code, this.name);
    }
}