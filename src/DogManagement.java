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
        private int id = 0;
        private String name = "null";
        private double weight = 0.0;
        private int age = 0;
        private String breed = "null";

        public Dog(int i, String n, double w, int a, String b) {
            this.id = i;
            this.name = n;
            this.weight = w;
            this.age = a;
            this.breed = b;

        }

    }

    public static void main(String[] args) throws Exception {
        Dog doggy = new Dog(12, "Doggy", 10.2, 10, "Maltese");
        ArrayList<Dog> dogList = new ArrayList<Dog>(12);

        Scanner csvReader = new Scanner(new File("./doginfo.csv"));

        csvReader.close();
    }

}
