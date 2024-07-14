
/**
 * The StudentMarksCalc class allows users to input the assignment name and 
 * marks for 30 students. It ensures valid marks that need to be between 0 
 * and 30. The program prints the assignment name and mark. It shows the 
 * highest mark, lowest mark, mean, and standard deviation.
 * Author: Barsha Dahal
 * Date: 14th July, 2024
 */

import java.util.Scanner;

public class StudentMarkCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Array for marks of 30 student
        float[] Marks = new float[5];  
        String Name;

        // Input Assignment name
        System.out.print("Enter assignment name: ");
        Name = scanner.nextLine();

        // Get marks for 30 students, ensure they are between 0 to 30
        for (int i = 0; i < Marks.length; i++) {
            float mark = -1;
            while (mark < 0 || mark > 30) {
                System.out.print("Enter mark for student " + (i + 1) + " "); // Give space betweem sentence and marks
                while (!scanner.hasNextFloat()) {
                    System.out.println("This is invalid input! Enter valid number."); // Print invalid input message
                    scanner.next(); 
                }
                mark = scanner.nextFloat();
                scanner.nextLine(); 
                if (mark < 0 || mark > 30) {
                    System.out.println("This is invalid marks as it must be between 0 and 30, Retry!"); // Print invalid marks message
                } else {
                    Marks[i] = mark;
                }
            }
        }

        System.out.println("These are marks for " + Name);

        // Show Assignment name and all Marks
        System.out.println("\nAssignment name: " + Name);
        System.out.println("Student has got following Marks:");
        for (int i = 0; i < Marks.length; i++) {
            System.out.println("Student " + (i + 1) + "- " + Marks[i]);   // Show each student's marks

        }

        
    }

}