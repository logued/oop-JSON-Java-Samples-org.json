package org.example.sample3;           // Feb 2025

import org.example.sample4.Book;
import org.json.JSONArray;
import org.json.JSONObject;

// Demonstrates:
// Creating a JSON String from a Java Book object.
// Extracting field values from a JSONObject, and JSONArray.

public class Main {

    public static void main(String[] args) {

        // create book object for this sample
        Book book1 = new Book(
                "Modern C++",
                "978-0131872486",
                34.50,
                2021,
                true,
                new String[]{"Bruce Eckel", "Jon Snow"});   // authors field

        // Convert Book object to a JSON String (i.e. a String that uses JSON structure)
        // We say that we "serialize" the object.
        // The JSONObject constructor looks (reflects) on the book1 object
        // and for each method starting with "get" or "is", it creates a key from the
        // remaining letters to use as JSON key names
        // So, getYear() will result in field "year", isRecommended() will give "recommended"

        JSONObject jsonObject = new JSONObject(book1);

        String jsonString = jsonObject.toString();
        System.out.println("\nJson String ):\n" + jsonString);

        ///TODO
        /// 1. Add the User class to this sample3 folder (copy it in)
        /// 2. Modify the User class so that it has getters for all fields.
        /// 3. Create a User object in main()
        /// 4. As per sample, convert User object into JSON String and print it out.

        // ACCESSING INDIVIDUAL FIELDS from JSONObject
        // Let us extract individual values from the JSONObject using their keys.

        String title = jsonObject.getString("title");
        System.out.println("\nTitle (String): " + title);
        String isbn = jsonObject.getString("isbn");
        System.out.println("ISBN (String): " + isbn);
        double price = jsonObject.getDouble("price");
        System.out.println("Price (double): "  + price);
        int year = jsonObject.getInt("year");
        System.out.println("Year (int): " + year);
        boolean recommended = jsonObject.getBoolean("recommended");
        System.out.println("Recommended (boolean): " + recommended);

        // Get the list part [], into a JSONArray
        // The value identified by the key "authors" is a JSONArray, so we assign
        // it to a reference of that type.

        JSONArray jsonArray = jsonObject.getJSONArray("authors");

        // Iterate over the array extracting the elements (which are Strings)
        System.out.print("Authors: [ ");
        for (int i = 0; i < jsonArray.length(); i++) {
            String author  = jsonArray.getString(i);
            System.out.print(author + ", ");
        }
        System.out.println(" ]");

        ///TODO
        /// 1. Add a field to the User class called "emails"
        /// 2. Add a second constructor that initialises all fields plus the new email field.
        /// 3. Create a User with two email addresses
        /// 4. Convert the User object into a JSONObject
        /// 5. Convert JSONObject into a JSON String, and display it
        /// 5. Extract all values from the JSONObject, and display them individually.

    }
}

