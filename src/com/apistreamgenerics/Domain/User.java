package com.apistreamgenerics.Domain;

import java.util.List;

public record User(String name, int age, Sex sexo, List<Contact> contacts) {
}