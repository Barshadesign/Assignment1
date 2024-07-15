
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
        float[] Marks = new float[30];  
        String Name;

    // Input Assignment name
    System.out.print("Enter assignment name: ");
        Name = scanner.nextLine();

    // Get marks for 30 students, ensure they are between 0 to 30
        for (int i = 0; i < Marks.length; i++) {
            //Invalid value initialization
        float mark = -1;
            while (mark < 0 || mark > 30) {
                System.out.print("Enter Student" + (i + 1) + " mark "); // Give space betweem sentence and marks
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


        // Show Assignment name and all Marks
        System.out.println("\nAssignment name: " + Name);
        System.out.println("Student has got following Marks:");
        for (int i = 0; i < Marks.length; i++) {
        System.out.println("Student" + (i + 1) + " = " + Marks[i]);   // Show each student's marks 

        }
        
        // Calculate highest and Lowest marks in array

        float highest = markHighest(Marks);
        float lowest = markLowest(Marks);
        
        // Show highest and lowest marks

        System.out.println("\nHighest Mark among all marks: " + highest);
        System.out.println("Lowest Mark among all marks: " + lowest);
        
        // Calculate mean and Standard deviation

        float mean = calcMean(Marks);
        float standardDeviation = calcStandardDeviation(Marks, mean);

        // Show mean and standard deviation
    System.out.printf("\nMean of all marks: %.2f\n", mean);
    System.out.printf("Standard deviation of all marks: %.2f\n", standardDeviation);

    scanner.close();
    }


    private static float markHighest(float[] marks) {
        //Start with first mark as highest
        float highest = marks[0];
        //Iterate through all mark
    for (int i = 1; i < marks.length; i++) {
            // If current marks is higher than markHighest, update highest
            if (marks[i] > highest) {
                highest = marks[i];
            }
    }
        //Return highest mark
    return highest;
    }

    private static float markLowest(float[] marks) {
        //Start with first mark as lowest
    float lowest = marks[0];
        //Iterate through all mark
        for (int i = 1; i < marks.length; i++) {
            // If current marks is lower than markLowest, update lowest
            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }
        //Return lowest mark
    return lowest;
    }   

// Function to calculate the mean of marks
    private static float calcMean(float[] marks) {
    float totalSum = 0;
    for (int i = 0; i < marks.length; i++) {
        totalSum += marks[i];
    }
float mean = totalSum / marks.length;
return mean;
}

    // Function to calculate the standard deviation of marks
private static float calcStandardDeviation(float[] marks, float mean) {
        float totalSquaredDifference = 0;

    // Suming squared differences from mean
        for (int i = 0; i < marks.length; i++) {
         float difference = marks[i] - mean;
            // Add the squared difference to the total
            totalSquaredDifference += difference * difference;
        }

        // Calculate average of squared difference(variance)
    float variance = totalSquaredDifference / marks.length;

        // Return standard deviation that is square root of variance
    return sqrt(variance);
    }

    // Function for calculating square root of number using iterative method
private static float sqrt(float number) {
        float oldEstimate;
        float newEstimate = number / 2;

        // Improve estimate and make it is accurate
        do {
        oldEstimate = newEstimate;
         newEstimate = (oldEstimate + (number / oldEstimate)) / 2;
        } while (oldEstimate != newEstimate);

    return newEstimate;
    }

}
