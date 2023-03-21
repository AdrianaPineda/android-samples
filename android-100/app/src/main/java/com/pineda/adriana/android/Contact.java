package com.pineda.adriana.android;

import java.util.ArrayList;
import java.util.List;

public class Contact {

    private String name;
    private boolean isOnline;

    public Contact(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
    }

    public String getName() {
        return name;
    }

    public boolean isOnline() {
        return isOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList(int numContacts) {
        ArrayList<Contact> contacts = new ArrayList<>();
        for (int i = 1; i <= numContacts; i++) {
          contacts.add(new Contact("Person " + ++lastContactId, i % 2 == 0));
        }

        return contacts;
    }

    private static final String[] NAMES = {
            "Bridget Kidd",
            "Carson Wong",
            "Matthias Mata",
            "Brynn Sheppard",
            "Duncan Daniels",
            "Karen Hughes",
            "Zion Moses",
            "Coleman Bray",
            "Anthony Glenn",
            "Gavin Maynard",
            "Gabriella Vincent",
            "Cecilia Mcmillan",
            "Essence Santana",
            "Allison Small",
            "Alivia Rhodes",
            "Makenzie Perez",
            "Mariam Goodwin",
            "Jayla Rocha",
            "Lorena Higgins",
            "Brennan Wu",
            "Kyson Dudley",
            "Kenny Browning",
            "Jameson Espinoza",
            "Rayna Copeland",
            "Alma Peters",
            "Martin Barnett",
            "Catherine Spencer",
            "Kolton Branch",
            "Duncan Herman",
            "Lilly Vargas",
            "Nash Gillespie",
            "Logan Ewing",
            "Gavin Ware",
            "Carleigh Miles",
            "Elena Henderson",
            "Rex Church",
            "Marcelo Acevedo",
            "Mariah Russo",
            "Gia Shaw",
            "Ximena Henry",
            "Karlie Mayer",
            "Uriel Eaton",
            "Kamila Quinn",
            "Marilyn Mayer",
            "Magdalena Lowery",
            "Demarcus Farmer",
            "Kenna Reese",
            "Alicia Velazquez",
            "Desirae Silva",
            "Alessandra Warner",
            "Madalynn Riley",
            "Delaney Greene",
            "Sincere Ward",
            "India Gregory",
            "America Ball",
            "Colten Sanchez",
            "Rayan Khan",
            "Adriel Dougherty",
            "Nathanael Armstrong",
            "Magdalena Shepard",
            "Garrett Arnold",
            "Hillary Savage",
            "Molly Howe",
            "Ryder Austin",
            "Phoenix Barrera",
            "Nyla Pacheco",
            "Kirsten Delgado",
            "Araceli Parker",
            "Jovanny Hale",
            "Malaki Stein",
            "Kaliyah Gray",
            "Steve Oliver",
            "Bobby Hall",
            "Ricardo Mora",
            "Jayvion Yu",
            "Peter Johnson",
            "Cheyanne Garcia",
            "Laura Yoder",
            "Miles Montgomery",
            "Princess Lang",
            "Nikhil Tate",
            "Paulina Wheeler",
            "Anthony Hobbs",
            "Jacob Watkins",
            "Alfredo English",
            "Madden Atkins",
            "Alissa Fletcher",
            "Leanna Rojas",
            "Fatima Quinn",
            "Marquise Schultz",
            "Carmelo Santiago",
            "Kadin Horne",
            "Azaria Buchanan",
            "Everett Nunez",
            "Joseph Cummings",
            "Alvin Oconnell",
            "Mara Walls",
            "Seamus Contreras",
            "Jan Barnett",
            "Heidi Chase"
    };

    public static ArrayList<Contact> getMeaningfulNamedContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        int i = 1;
        for (String name: NAMES) {
            contacts.add(new Contact(name, i++ % 2 == 0));
        }
        return  contacts;
    }
}
