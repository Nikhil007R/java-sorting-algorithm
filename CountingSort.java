import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {

    // Counting Sort function
    public static void countingSort(int[] arr, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Step 1: Count occurrences of each age
        for (int age : arr) {
            count[age - minAge]++;
        }

        // Step 2: Compute cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements in sorted order
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - minAge] - 1] = arr[i];
            count[arr[i] - minAge]--;
        }

        // Copy sorted values back to the original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input for number of students
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        int[] studentAges = new int[n];

        // Taking user input for student ages
        System.out.println("Enter the ages of students (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            studentAges[i] = sc.nextInt();
            if (studentAges[i] < 10 || studentAges[i] > 18) {
                System.out.println("Invalid age! Please enter an age between 10 and 18.");
                i--; // Ask for valid input again
            }
        }

        // Display original ages
        System.out.println("Original Ages: " + Arrays.toString(studentAges));

        // Sort ages using Counting Sort
        countingSort(studentAges, 10, 18);

        // Display sorted ages
        System.out.println("Sorted Ages: " + Arrays.toString(studentAges));

        sc.close();
    }
}
