/*-------------------------------------------------------------
# Program 6: MPLS Dog Management System using OOP Principles
**Programs 6 is similar in functionality to program 5**


    [REPLACE MY INFORMATION WITH YOURS]
    Course: COMP 170, Spring I 2023
    System: Visual Studio Code, Windows 10
    Author: C. Fulton
 */
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
    }

}
