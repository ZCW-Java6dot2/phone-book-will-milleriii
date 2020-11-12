package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {

        this.phonebook = map;
    }

    public PhoneBook() {

        phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        // .singletonList was mentioned during ALumni session and I googled an ex. of it for this case
        // saw multiple examples of it being used for phone # problems but not 100% confident in how it works
        phonebook.put(name, new ArrayList<>(Collections.singletonList(phoneNumber)));

    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, new ArrayList<>(Arrays.asList(phoneNumbers)));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        for (HashMap.Entry<String, List<String>> entry : phonebook.entrySet()) {
            if (entry.getValue().contains(name)){
                return true;
            }
        }

        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (HashMap.Entry<String, List<String>> entry : phonebook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)){
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
