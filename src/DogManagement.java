/*-------------------------------------------------------------
# Program 6: MPLS Dog Management System using OOP Principles
**Programs 6 is similar in functionality to program 5**


    Course: COMP 170, Fall 1 2026
    System: GNU/Linux
    Author: Avery Hendrix
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Dog {
    // in order of csv appearance
    private int id = 0;
    private String name = "null";
    private double weight = 0.0;
    private int age = 0;
    private String breed = "null";

    // default dog uses above values
    public Dog() {
    }

    // string array -> dog. used for csv parsing
    public Dog(String[] dogBuffer) {

        this.id = Integer.parseInt(dogBuffer[0]);
        this.name = dogBuffer[1];
        this.weight = Double.parseDouble(dogBuffer[2]);
        this.age = Integer.parseInt(dogBuffer[3]);
        if (dogBuffer.length > 4) {
            this.breed = dogBuffer[4];
        } // hacky fix for the csv not having this

    }

    // dog -> dog. used to add buffers to list so they can be reused
    public Dog Clone() {
        Dog clone = new Dog();

        clone.id = this.id;
        clone.name = this.name;
        clone.weight = this.weight;
        clone.age = this.age;
        clone.breed = this.breed;
        return clone;
    }

    // dog -> string array. nvm!

    public String[] getDog() {
        String[] stringArray = new String[5];

        stringArray[0] = Integer.toString(this.id);
        stringArray[1] = this.name;
        stringArray[2] = Double.toString(this.weight);
        stringArray[3] = Integer.toString(this.age);
        stringArray[4] = this.breed;

        return stringArray;

    }

    // this cannot be right

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(Double weight) {
        this.weight = weight;

    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

}

public class DogManagement {
    static Scanner scn = new Scanner(System.in);
    static ArrayList<Dog> dogList = new ArrayList<Dog>(12);

    // reads csv, adding each line to the dogList
    public static void readCSV() throws Exception {
        String[] dogBuffer = new String[5];
        Scanner csvReader = new Scanner(new File("./src/doginfo.csv"));

        // eats first line
        csvReader.nextLine();

        while (csvReader.hasNextLine()) {
            // splits the line into a buffer array
            dogBuffer = csvReader.nextLine().split(",");
            Dog bufferDog = new Dog(dogBuffer);

            dogList.add(bufferDog.Clone());
            // so the bufferDog can be freed

        }
        csvReader.close();

    }

    // copied wholesale from provided code in program 5
    public static void welcome() {
        System.out.println(
                "Welcome, this program allows for a care attendant to be able to create, retrieve and update a dog record from the system.");
    }

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
        bufferDog.setID(scn.nextInt());

        System.out.print("Name: ");
        bufferDog.setName(scn.next());

        System.out.print("Weight: ");
        bufferDog.setWeight(scn.nextDouble());

        System.out.print("Age: ");
        bufferDog.setAge(scn.nextInt());

        System.out.print("Breed: ");
        bufferDog.setBreed(scn.next());

        dogList.add(bufferDog.Clone());

    }

    // editDog
    // prints out single dog in pretty format
    public static void printDog(Dog dog) {
        String[] dogArray = dog.getDog();
        System.out.printf("|%-4s|%-12s|%-7s|%-4s|%-12s|%n", dogArray[0], dogArray[1], dogArray[2], dogArray[3],
                dogArray[4]);

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
