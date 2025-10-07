import java.util.*;

public class AllPermutations {
    
    // Swap characters in char array
    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void permute(char[] arr, int index, int n) {
        if(index == n) {
            System.out.println(new String(arr));
            return;
        }
        
        for(int i = index; i < n; i++) {
            swap(arr, index, i);
            permute(arr, index + 1, n);
            swap(arr, index, i); // backtrack
        }
    } 
    
    public static void main(String[] args) {
        System.out.println("Enter Your String");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("All Permutations of " + str + " are:");
        permute(str.toCharArray(), 0, str.length());
        sc.close();
    }
}