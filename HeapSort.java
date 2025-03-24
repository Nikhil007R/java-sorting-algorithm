import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {

    // Heap Sort function
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to the end
            swap(arr, 0, i);

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify function to maintain max heap property
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Root node
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    // Swap function
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input for number of applicants
        System.out.print("Enter the number of job applicants: ");
        int n = sc.nextInt();
        int[] salaries = new int[n];

        // Taking user input for salary demands
        System.out.println("Enter the expected salaries:");
        for (int i = 0; i < n; i++) {
            salaries[i] = sc.nextInt();
        }

        // Display original salaries
        System.out.println("Original Salaries: " + Arrays.toString(salaries));

        // Sort salaries using Heap Sort
        heapSort(salaries);

        // Display sorted salaries
        System.out.println("Sorted Salaries: " + Arrays.toString(salaries));

        sc.close();
    }
}
