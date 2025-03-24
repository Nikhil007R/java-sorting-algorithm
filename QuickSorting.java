import java.util.Arrays;
import java.util.Scanner;

public class QuickSorting {

    // Quick Sort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            // Recursively sort left and right partitions
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition function (using the last element as pivot)
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot element
        int i = low - 1; // Pointer for smaller elements

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { // If current element is smaller than pivot
                i++;
                swap(arr, i, j);
            }
        }

        // Swap pivot into its correct position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Swap function
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input for number of products
        System.out.print("Enter the number of product prices: ");
        int n = sc.nextInt();
        int[] productPrices = new int[n];

        // Taking user input for product prices
        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            productPrices[i] = sc.nextInt();
        }

        // Display original prices
        System.out.println("Original Prices: " + Arrays.toString(productPrices));

        // Sort the prices using Quick Sort
        quickSort(productPrices, 0, n - 1);

        // Display sorted prices
        System.out.println("Sorted Prices: " + Arrays.toString(productPrices));

        sc.close();
    }
}
