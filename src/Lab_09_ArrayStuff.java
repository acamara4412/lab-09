import java.util.Random;
import java.util.Scanner;

public class Lab_09_ArrayStuff {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] dataPoints = new int[100];

        Random rnd = new Random();
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        System.out.println("--- Data Points Array ---");
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i] + " | ");
        }
        System.out.println("\n");

        int sum = 0;
        for (int val : dataPoints) {
            sum += val;
        }
        double average = (double) sum / dataPoints.length;
        System.out.println("The sum of the random array dataPoints is: " + sum);
        System.out.println("The average of the random array dataPoints is: " + average);
        System.out.println();

        int searchValue = SafeInput.getRangedInt(in, "Enter an integer value to search for", 1, 100);

        int count = 0;
        for (int val : dataPoints) {
            if (val == searchValue) {
                count++;
            }
        }
        System.out.println("The value " + searchValue + " was found " + count + " time(s) within the dataPoints array.\n");

        int searchVal2 = SafeInput.getRangedInt(in, "Enter another integer value to find its first position", 1, 100);
        int foundIndex = -1;

        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == searchVal2) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            System.out.println("The value " + searchVal2 + " was found at array index " + foundIndex + ".");
        } else {
            System.out.println("The value " + searchVal2 + " was not found in the array.");
        }
        System.out.println();

        int min = dataPoints[0];
        int max = dataPoints[0];

        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }

        System.out.println("The minimum value in the dataPoints array is: " + min);
        System.out.println("The maximum value in the dataPoints array is: " + max);
        System.out.println();

        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
    }

    public static double getAverage(double values[]) {
        if (values.length == 0) {
            return 0.0;
        }
        double total = 0;
        for (double val : values) {
            total += val;
        }
        return total / values.length;
    }

    public static double getAverage(int values[]) {
        if (values.length == 0) {
            return 0.0;
        }
        int total = 0;
        for (int val : values) {
            total += val;
        }
        return (double) total / values.length;
    }
}

class SafeInput {
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = low - 1;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("You must enter a value between " + low + " and " + high + ": " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer, not: " + trash);
            }
        } while (!done);

        return retVal;
    }
}