package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

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
                        .forEach(System.out::println);

        // 2. Filter characters with mass > 80
        System.out.println("\n=== Characters with Mass > 80 ===");

        List<Character> heavyCharacters = characters.stream()
                .filter(character -> character.getMass() > 80)
                        .toList();

        heavyCharacters.forEach(character -> System.out.println(character.getName() + " - " + character.getMass() ));


        // 3. Create a list of just names
        System.out.println("\n=== Character Names ===");

        characters.stream()
                .map( character -> character.getName() )
                .forEach(name -> System.out.println(name));

        // 4. Check if any character has blue eyes
        boolean hasBlueEyes = characters.stream()
                .anyMatch( character -> character.getEyeColor().equalsIgnoreCase("blue"));
        if (hasBlueEyes) {
            System.out.println("\nSome characters have blue eyes");
        } else {
            System.out.println("\nNo characters have blue eyes");
        }

        // 5. Check if all characters are male
        boolean allMale = characters.stream()
                .allMatch(character -> character.getGender().equalsIgnoreCase("male"));

        if (allMale) {
            System.out.println("All the characters are male");
        } else {
            System.out.println("Not all characters are male");
        }

        // 6. Calculate total mass
        int totalMass = characters.stream()
                        .mapToInt(Character::getMass)
                        .sum();

        System.out.println("Total mass: " + totalMass);
    }


}