import java.util.Scanner;

public class InsertionSorting {

    public static void Insertion(int arr[]) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                --j;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your array size: ");
        int size = sc.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter your numbers: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Values before sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Insertion(arr);
        System.out.println("Values after sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
