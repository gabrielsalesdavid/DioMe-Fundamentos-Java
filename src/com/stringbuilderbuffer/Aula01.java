package com.stringbuilderbuffer;

import java.util.HashMap;
import java.util.Map;

public class Aula01 {

    public static void main(String[] args) {

        String value = """
                {"name":"João","age":18}
                """;

        Map<String, String> map = new HashMap<>();

        value = value.replace("{", "")
                .replace("}", "")
                .replace("\"", "");
        String[] valueArr = value.split(",");

        for(String v : valueArr) {

            String[] keyValue = v.split(":");
            map.put(keyValue[0], keyValue[1]);
        }
        System.out.println(map);
    }
}