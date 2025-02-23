package org.example.sample4;           // Feb 2025

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

// Demonstrates:
// Creating a JSON String from an ArrayList<Book> of book objects.
// Extracting each JSONObject individually from the JSONArray
// and accessing the key->value pairs from each JSONObject.

public class Main {

    public static void main(String[] args) {

        ArrayList<Book> bookList = new ArrayList<>();

        bookList.add(new Book("Modern C++","978-0131872486",
                34.50,2021,
                true, new String[]{"Bruce Eckel", "Jon Snow"}));

        bookList.add(new Book("Head First Java","675-0131872486",
                42.50,2008,
                false, new String[]{"K. Sierra", "B. Bates"}));

        // Use ArrayList of Book objects to create a JSONArray of JasonObjects
        // with key named "books"

        // The JSONObject constructor looks (reflects) on the bookList object
        // and for each method starting with "get" or "is", it creates a key from the
        // remaining letters to use as JSON key names
        // So, getYear() will result in field "year", isRecommended() will give "recommended"

        JSONObject jsonObject = new JSONObject();       // the parent container object "{"
        JSONArray jsonArray = new JSONArray(bookList);  // populate JASONArray from ArrayList
        jsonObject.put("books", jsonArray);             // put the JSONArray into the object

        String jsonString = jsonObject.toString();
        System.out.println("\nJson String:\n" + jsonString);

        ///TODO Part A
        /// 1. Add the User class to this sample4 folder (copy it in)
        /// 2. Create an ArrayList<User> and populate with 3 User objects
        /// 3. Convert to JSONArray and then to JSON String and print

        // ACCESSING INDIVIDUAL FIELDS from JSONObject
        // Let us extract individual values from the JSONObject using their keys.

        JSONArray jsonArray2 = jsonObject.optJSONArray("books"); // Get JASONArray from the main JSONObject

        for (int i = 0; i < jsonArray2.length(); i++) {  // iterate over the Book objects in JSONArray
            JSONObject jsonObject2  = jsonArray.getJSONObject(i);   // get one book object#
            // extract key->value pair data
            String title = jsonObject2.getString("title");
            System.out.println("\nTitle (String): " + title);
            String isbn = jsonObject2.getString("isbn");
            System.out.println("ISBN (String): " + isbn);
            double price = jsonObject2.getDouble("price");
            System.out.println("Price (double): "  + price);
            int year = jsonObject2.getInt("year");
            System.out.println("Year (int): " + year);
            boolean recommended = jsonObject2.getBoolean("recommended");
            System.out.println("Recommended (boolean): " + recommended);

            // Get the list part [], into a JSONArray
            // The value identified by the key "authors" is a JSONArray, so we assign
            // it to a reference of that type.
            JSONArray jsonArray3 = jsonObject2.getJSONArray("authors");

            // Iterate over the array extracting the elements (which are Strings)
            System.out.print("Authors: [ ");
            for (int j = 0; j < jsonArray3.length(); j++) {
                String author  = jsonArray3.getString(j);
                System.out.print(author + ", ");
            }
            System.out.println(" ]");

            ///TODO Part B
            /// 1. Using a for loop, iterate over the JSONArray of User objects
            ///    and access each JSONObject element. Access teh key->value pairs
            ///     of the JSONObject and display the data.
        }
    }
}

