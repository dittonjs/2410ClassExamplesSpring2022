package com.usu.recyclerview;

import java.util.ArrayList;

public class ContactDatabase {

    static ArrayList<Contact> generateContacts(int amount) {
        ArrayList<Contact> contacts = new ArrayList<>();
        for(int i = 0; i < amount; i ++) {
            Contact contact = new Contact();
            contact.name = "Person " + (i + 1);
            contact.phoneNumber = "111000" + i;
            contacts.add(contact);
        }
        return contacts;
    }
}
