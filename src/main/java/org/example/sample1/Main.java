package org.example.sample1;            // Feb 2025

// Demonstrates:
// Building JSON String by creating and populating a JSONObject
// and converting it to a JSON String ( by calling toString() ).

import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {

//        The following JSON String represents student details in JSON format
//
//        {                             // bracket means start of JSON object
//            "name":"Elizabeth",       // key=>value pairs
//            "age":19                  // keys must always be strings
//        }                             // values can have a variety of types

        // In order to construct the above JSON String we:
        // 1. create a JSONObject  (as defined in the org.json library)
        // 2. add key->value pairs to the JSONObject
        // 3. convert it to a JSON String using ( toString() )
        //
        JSONObject jsonObject = new JSONObject();

        // Adding key=>value pairs.  Keys must be strings, but values can have various types.
        jsonObject.put("name", "Elizabeth");
        jsonObject.put("age", 19);

        String jsonString = jsonObject.toString();

        System.out.println("JSON String is: \n " + jsonString);

        //TODO goes here
    }
}

///TODO
/// 1. Create a JSONObject that will represent Book data:
///    A Book has a title ("Big Java"), a price (45:50) and
///    a page count (360).
/// 2.Convert the JSONObject to a JSONString, and print it out.

