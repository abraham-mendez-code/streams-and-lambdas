package com.pluralsight;

import java.util.ArrayList;

public class AppStreams {

    public static void main(String[] args) {
        ArrayList<Character> characters = new ArrayList<Character>();
        characters.add(new Character("Luke Skywalker", 172, 77, "blue", "male"));
        characters.add(new Character("Darth Vader", 202, 136, "yellow", "male"));
        characters.add(new Character("Leia Organa", 150, 49, "brown", "female"));
        characters.add(new Character("Anakin Skywalker", 188, 84, "blue", "male"));

        // 1. Print names in all uppercase
        System.out.println("=== Names in UPPERCASE ===");

        // using a stream with the map method to work with each character nd convert its name to upper
        // process it in a for each loop to display the results
        characters.stream()
                        .map( (character) -> character.getName().toUpperCase()  )
                        .forEach( (name) -> System.out.println(name));

        // 2. Filter characters with mass > 80
        System.out.println("\n=== Characters with Mass > 80 ===");
        ArrayList<Character> filtered = new ArrayList<Character>();
        for (Character c : characters) {
            if (c.getMass() > 80) {
                filtered.add(c);
                System.out.println(c.getName() + " (" + c.getMass() + ")");
            }
        }

        // 3. Create a list of just names
        System.out.println("\n=== Character Names ===");
        ArrayList<String> names = new ArrayList<String>();
        for (Character c : characters) {
            names.add(c.getName());
        }
        for (String name : names) {
            System.out.println(name);
        }

        // 4. Check if any character has blue eyes
        boolean hasBlueEyes = false;
        for (Character c : characters) {
            if (c.getEyeColor().equalsIgnoreCase("blue")) {
                hasBlueEyes = true;
                break;
            }
        }
        if (hasBlueEyes) {
            System.out.println("\nSome characters have blue eyes");
        } else {
            System.out.println("\nNo characters have blue eyes");
        }

        // 5. Check if all characters are male
        boolean allMale = true;
        for (Character c : characters) {
            if (!c.getGender().equalsIgnoreCase("male")) {
                allMale = false;
                break;
            }
        }
        if (allMale) {
            System.out.println("All the characters are male");
        } else {
            System.out.println("Not all characters are male");
        }

        // 6. Calculate total mass
        int totalMass = 0;
        for (Character c : characters) {
            totalMass += c.getMass();
        }
        System.out.println("Total mass: " + totalMass);
    }


}