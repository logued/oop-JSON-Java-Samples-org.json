package org.example.sample2;           // Feb 2025

import org.json.JSONArray;
import org.json.JSONObject;

// Demonstrates:
// Creating a JSON String consisting of an object that has
// an array as a value (JSONArray) in one of its fields (key->value)
//

public class Main {

    public static void main(String[] args) {

//        The following JSON String represents student details in JSON format:
//
//        {                             // bracket means start of JSON object
//            "name":"Elizabeth",       // key=>value pairs
//            "age":19,
//            "hobbies": ["Golf","Tennis"]
//        }

        // In order to construct the above JSON String we:
        // 1. create a JSONObject  (as defined in the org.json library)
        // 2. add key->value pairs to the JSONObject, for name and age
        // 3. Create a JSON Array to store hobbies
        // 4. populate the JSONArray
        // 5. add the JSONArray to the JSONObject as a key->value pair, giving it the name "hobbies"
        // 6. convert it to a JSON String using (toString() )
        //
        JSONObject jsonObject = new JSONObject();
        // Adding key=>value pairs.  Keys must be strings, but values can have various types.
        jsonObject.put("name", "Elizabeth");
        jsonObject.put("age", 19);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put("Golf");
        jsonArray.put("Tennis");

        jsonObject.put("hobbies", jsonArray);

        String jsonString = jsonObject.toString();
        System.out.println("JSON String is: \n " + jsonString);

        //TODO Part A
        // 1. Add another hobby to the list of hobbies above
        // 2. Add a list of two "friends" to the object
        // 3. Convert to JSON String and output
        // 4. Check your result


        // BOOK DETAILS
        // Create a JSONObject with book details - containing various types of values
        JSONObject jsonObject2 = new JSONObject();
        // Adding key=>value pairs.  Keys must be strings, but values can have various types.
        jsonObject2.put("title", "Modern C++");
        jsonObject2.put("isbn", "345-0131872486");   // String value
        jsonObject2.put("price", 34.50);             // double value
        jsonObject2.put("year", 2021);               // int
        jsonObject2.put("recommended", true);        // boolean

        // authors is a list of Stings, so we need to create a JSONArray to store the list
        JSONArray jsonArray2 = new JSONArray();
        jsonArray2.put ("Lippman");
        jsonArray2.put("Moo");
        jsonObject2.put("authors", jsonArray);   // add the key=>value pair

        // Finally, convert the JSONObject into a JSON String
        String jsonString2 = jsonObject2.toString();

        System.out.println("\nJSON book data, with various types of values:");
        System.out.println(jsonString2);     // Note that order of fields is not same as original order.

        //TODO Part B
        // 1. add number of pages in book to the data
        // 2. add list of page numbers on which each chapter starts (e.g. 20,35,50,68)
        // 3. Convert to JSON String and output.

    }
}

