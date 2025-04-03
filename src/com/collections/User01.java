package com.collections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

import static java.util.Objects.hash;
import static java.util.Objects.isNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User01 {

    private int id;
    private String name;

    public String ToString() {

        return String.format("{ 'code' : %s, 'name: %s", this.id, this.name);
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this) return true;
        if((isNull(obj)) || (!(obj instanceof User01 user01))) return false;
        return this.id == user01.getId() && Objects.equals(user01.getName(), this.name);
    }

    public int hasCode() {

        return hash(this.id, this.name);
    }

    public int compareTo(User01 users) {

        int compareResult = 0;
        if(this.id < users.id) compareResult--;
        if(this.id > users.id) compareResult++;
        return compareResult;
    }
}