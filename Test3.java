package com.mario;

import org.json.JSONObject;

/**
 Person class represents a real world Person but encapsulated
 into an internal JSONObject attribute.
*/
class Person {
    private JSONObject _obj;

    public Person(String name, String surname,
        int age, double height, String eyeColor) {
        _obj.put("name", name);
        _obj.put("surname", surname);
        _obj.put("age", age);
        _obj.put("height", height);
        _obj.put("eyeColor", eyeColor);
    }

    // Get the internal name representation
    public String getName() {
        return _obj.getString("name");
    }

    // Get the intenral age representation
    public int getAge() {
        return _obj.getInteger("age");
    }
}

public class Test3 {
    public static void main(string[] args) {
        // Create mario object (JSON enconded)
        Person mario = new Person("Mario", "Moiane",
            70, 1.9, "black");

        // Get mario attributes
        String name = mario.getName();
        int age = mario.getAge();

        System.out.println("Name: ", name);
        System.out.println("Age: ", age);
    }
}