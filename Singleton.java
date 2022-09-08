package ru.alishev.springcourse;

/**
 * An example of a class that implements the Singleton pattern
 * Only one singleton class object can be used
 */
public class Singleton {
    // This static(!) variable will store a single object of the Singleton class
    private static Singleton instance;

    // Let's say our only object should have a value field
    private String value;

    // Getter method for field value
    public String getValue() {
        return value;
    }

    // IMPORTANT: Constructor must be private
    // We can't create a new Singleton object
    private Singleton(String value) {
        this.value = value;
    }

    // This static method will be called by the user to get the object of the Singleton class
    public static Singleton getInstance(String value) {
        // if a single object has not been created previously
        if (instance == null) {
            // the code here is executed only at the moment of the first call to the getInstance() method

            // create object once
            instance = new Singleton(value);
        }

        // all other calls to the getInstance() method return the same object to the user
        return instance;
    }
}

// Testing
class SingletonTest {
    public static void main(String[] args) {
        Singleton first = Singleton.getInstance("Hello!");
        Singleton second = Singleton.getInstance("Goodbye!");

        // true
        System.out.println(first == second);

        // Hello!
        System.out.println(first.getValue());

        // Hello!
        System.out.println(second.getValue());
    }
}