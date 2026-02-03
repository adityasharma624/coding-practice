package Practice;

public class Strings {
    static void main() {
        String a = "Aditya";
        String b = "Aditya";
        // the string pool enables a and b to point to the same object "Aditya"
        System.out.println(a==b); // thus gives true, because both point to same object

        String c = new String("Aditya");
        String d = new String("Aditya");
        // this creates two separate objects
        System.out.println(c==d); // false

        // to check values
        System.out.println(c.equals(d));

        // System.out.println(56);
        // "out" is a variable of type PrintStream, and PrintStream class has a method named println.
        // println is basically .valueOf which gets the value of object and then the .toString method prints out the string.
        // the operator "+" is defined for primitives or one of the objects should be a String.
    }
}
