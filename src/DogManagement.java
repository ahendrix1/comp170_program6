/*-------------------------------------------------------------
# Program 6: MPLS Dog Management System using OOP Principles
**Programs 6 is similar in functionality to program 5**


    Course: COMP 170, Fall 1 2026
    System: GNU/Linux
    Author: Avery Hendrix
 */

/* TODO 
 * - class Dog()
 *      - constuctor
 *      - getDog(id) 
 *      - editDog(dog, attrib, new)
 *      - toString(dog)
 * - main
 *      - make dog array
 *      - import dogcsv
 *      - start while loop
    *      - check create update retrieve
    *      - idk. do those
 * - errors on if illegal dog, newdog is over 12
*   
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class DogManagement {
    public static class Dog {
        // In order of csv appearance
        private int id;
        private String name;
        private double weight;
        private int age;
        private String breed;

        public Dog(int i, String n, double w, int a, String b) {
            this.id = i;
            this.name = n;
            this.weight = w;
            this.age = a;
            this.breed = b;

        }

        public Dog() {
            this.id = 0;
            this.name = "null";
            this.weight = 0.0;
            this.age = 0;
            this.breed = "null";

        }

        public Dog Clone() {
            Dog clone = new Dog();

            clone.id = this.id;
            clone.name = this.name;
            clone.weight = this.weight;
            clone.age = this.age;
            clone.breed = this.breed;
            return clone;
        }
    }

    public static void main(String[] args) throws Exception {
        // csv read, appends to dog list with hard copies of
        // a temporary newDog. closes reader after parsing.
        ArrayList<Dog> dogList = new ArrayList<Dog>(12);
        String[] dogBuffer = new String[5];
        Scanner csvReader = new Scanner(new File("./src/doginfo.csv"));

        // eats first line into the header, to be printed later
        final String[] header = csvReader.nextLine().split(",");

        while (csvReader.hasNextLine()) {
            // splits the line into a buffer array
            dogBuffer = csvReader.nextLine().split(",");

            // temp. variables with typed vals
            int i = Integer.parseInt(dogBuffer[0]);
            double w = Double.parseDouble(dogBuffer[2]);
            int a = Integer.parseInt(dogBuffer[3]);

            Dog newDog = new Dog(i, dogBuffer[1], w, a, "Not Specified");
            dogList.add(newDog.Clone());

        }

        csvReader.close();
    }

}
