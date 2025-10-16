import java.util.*;
public class mediumArrays {
    public static int[] moveZero(int[] arr, int[] arr1, int n) {
        int index = 0;
        // First, put all non-zero elements into arr1
        for(int i = 0; i < n; i++) {
            if(arr[i] != 0) {
                arr1[index++] = arr[i];
            }
        }
        // Then put all zeros at the end
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                arr1[index++] = arr[i];
            }
        }
        return arr1;
    }
       public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] arr;
            System.out.println("Enter the size of array:");
            int n = sc.nextInt();
            arr = new int[n];  // Initialize array with size n
            System.out.println("Enter The Numbers: ");
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println("The Numbers are: ");
            for(int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            int[] arr1 = new int[n];
            int[] result = moveZero(arr, arr1, n);
            System.out.println("\nArray after moving zeros to end: ");
            for(int num : result) {
                System.out.print(num + " ");
            }
        }
       }
}
    
