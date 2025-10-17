import java.util.*;
public class mergeArray {
    public static void main(String[] args) {
        int[] arr1, arr2;
        int n, m;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of first array:");
        n=sc.nextInt();
        arr1 = new int[n];  // Initialize array with size n
        System.out.println("Enter The Numbers for first array: ");
        for(int i=0; i<n; i++)
        {
            arr1[i]=sc.nextInt();
        }
        System.out.println("The Numbers for first array are: ");
        for(int i=0; i<n; i++)
        {
            System.out.print(arr1[i] + " ");
        }
        System.out.println("\nEnter the size of second array:");
        m=sc.nextInt();
        arr2 = new int[m];  // Initialize array with size n
        System.out.println("Enter The Numbers for second array: ");
        for(int i=0; i<m; i++)
        {
            arr2[i]=sc.nextInt();
        }
        System.out.println("The Numbers for second array are: ");
        for(int i=0; i<m; i++)
        {
            System.out.print(arr2[i] + " ");
        }
        int[] merge = new int[n+m]; // Initialize array with size n+m
        for(int i=0; i<n; i++)
        {
            merge[i]=arr1[i];
        }
        for(int i=0; i<m; i++)
        {
            merge[n+i]=arr2[i];
        }
        System.out.println("\nThe Merged Array is: ");
        for(int i=0; i<n+m; i++)
        {
            System.out.print(merge[i] + " ");
        }
        
        sc.close();
    }
    
}
