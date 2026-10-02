/*-------------------------------------------------------------
# Program 6: MPLS Dog Management System using OOP Principles
**Programs 6 is similar in functionality to program 5**


    Course: COMP 170, Fall 1 2026
    System: GNU/Linux
    Author: Avery Hendrix
 */

/* TODO 
 * x class Dog()
 *      x constuctor
 *      - getDog(id) 
 *      - editDog(dog, attrib, new)
 *      x toString(dog)
 * - main
 *      x make dog array
 *      x import dogcsv
 *      - start while loop
    *      - check create update retrieve
    *      - idk. do those
 * - errors on if illegal dog, newdog is over 12
*   
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public static class Dog {
    // in order of csv appearance
    private int id;
    private String name;
    private double weight;
    private int age;
    private String breed = "null";

    // default dog
    public Dog() {
        this.id = 0;
        this.name = "null";
        this.weight = 0.0;
        this.age = 0;
        this.breed = "null";

    }

    // string array -> dog
    public Dog(String[] dogBuffer) {

        this.id = Integer.parseInt(dogBuffer[0]);
        this.name = dogBuffer[1];
        this.weight = Double.parseDouble(dogBuffer[2]);
        this.age = Integer.parseInt(dogBuffer[3]);
        if (dogBuffer.length > 4) {
            this.breed = dogBuffer[4];
        } // hacky fix for the csv not having this

    }

    // dog -> dog
    public Dog Clone() {
        Dog clone = new Dog();

        clone.id = this.id;
        clone.name = this.name;
        clone.weight = this.weight;
        clone.age = this.age;
        clone.breed = this.breed;
        return clone;
    }

    // dog -> string array

    public String[] toString(Dog dog) {
        String[] stringArray = new String[5];

        stringArray[0] = Integer.toString(dog.id);
        stringArray[1] = dog.name;
        stringArray[2] = Double.toString(dog.weight);
        stringArray[3] = Integer.toString(dog.age);
        stringArray[4] = dog.breed;

        return stringArray;

    }
}

public class DogManagement {
    // general scanner
    static Scanner scn = new Scanner(System.in);
    // array list of dog objects
    static ArrayList<Dog> dogList = new ArrayList<Dog>(12);

    // reads csv and returns the header line, editing the dogList
    public static void readCSV() throws Exception {
        String[] dogBuffer = new String[5];
        Scanner csvReader = new Scanner(new File("./src/doginfo.csv"));
        // csv read, appends to dog list with hard copies of
        // a temporary newDog. closes reader after parsing.

        // eats first line
        csvReader.nextLine();

        while (csvReader.hasNextLine()) {
            // splits the line into a buffer array
            dogBuffer = csvReader.nextLine().split(",");

            Dog bufferDog = new Dog(dogBuffer);

            dogList.add(bufferDog.Clone());

        }
        csvReader.close();

    }

    // copied wholesale from provided code in program 5

    // Welcome method that outputs introductory text explaining program
    public static void welcome() {
        System.out.println(
                "Welcome, this program allows for a care attendant to be able to create, retrieve and update a dog record from the system.");
    }

    // Method to display prompt and return integer values
    public static int displayPrompt() {
        // Local Variables
        int menuOption;

        System.out.println("\nSelect a menu option:");
        System.out.println("\t1) Create a dog record");
        System.out.println("\t2) Display dog record");
        System.out.println("\t3) Update dog record");
        System.out.println("\t4) Exit Program");

        System.out.print("Enter selection here --> ");
        // INPUT
        menuOption = scn.nextInt();

        return menuOption;
    }

    // makes new dog interactively
    public static void newDog() {
        if (dogList.size() == 12) {
            System.out.println("Too many dogs.");
            return;
        }

        Dog bufferDog = new Dog();

        System.out.print("ID: ");
        bufferDog.id = scn.nextInt();

        System.out.print("Name: ");
        bufferDog.name = scn.next();

        System.out.print("Weight: ");
        bufferDog.weight = scn.nextDouble();

        System.out.print("Age: ");
        bufferDog.age = scn.nextInt();

        System.out.print("Breed: ");
        bufferDog.breed = scn.next();

        dogList.add(bufferDog.Clone());

    }

    // editDog
    // prints out single dog in pretty format
    public static void printDog(Dog dog) {
        System.out.printf("|%-4d|%-12s|%-7.2f|%-4d|%-12s|%n", dog.id, dog.name, dog.weight, dog.age, dog.breed);

    }

    public static void printList() {
        System.out.println("_____________________________________________");
        System.out.printf("|%-4s|%-12s|%-7s|%-4s|%-12s|%n", "ID", "Name", "Weight", "Age", "Breed");
        System.out.println("|-------------------------------------------|");
        for (Dog sDog : dogList) {
            printDog(sDog);
        }

        System.out.println("---------------------------------------------");

    }

    public static void main(String[] args) throws Exception {
        int selectAct;
        int selectDog;

        Boolean session = true;

        readCSV();

        // also reused, but edited
        welcome();

        while (session) {

            printList();

            selectAct = displayPrompt();

            switch (selectAct) {
                case 1: // create
                    newDog();
                    break;
                /*
                 * case 2: // print
                 * selectDog = getDog();
                 * if (selectDog != -1) {
                 * printDog(selectDog);
                 * } else {
                 * System.out.println("Bad dog.");
                 * }
                 * break;
                 * case 3: // update
                 * selectDog = getDog();
                 * if (selectDog != -1) {
                 * editDog(selectDog);
                 * } else {
                 * System.out.println("Bad dog.");
                 * }
                 * break;
                 */
                case 4:
                    session = false;
                    break;

                default:
                    System.out.println("Bad option.");
                    break;
            }
        }
    }

}
