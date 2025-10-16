import java.util.*;

public class easyArrays {
    public static int countODD(int[] arr)
    {
        int count = 0;
        for(int num : arr)
        {
            if(num % 2 != 0) {
                count++;
            }
        }
        return count;
    }
    public static int maxx(int[] arr, int n)
    {
        int max = arr[0];
        for(int i=0; i<n; i++)
        {
            if(arr[i]>max)
            {
                max = arr[i];
            }
        }
        return max;
    }
    public static int frq(int[] arr, int n)
    {
        int freq=0;
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<=n; j++)
            {
                if(arr[i]==arr[j])
                {
                    freq++;
                }
            }
        }
        return freq;
    }
    public static int  
    public static void main(String[] args) {
        int[] arr;
        System.out.println("Enter the size of array:");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        arr = new int[n];  // Initialize array with size n
        System.out.println("Enter The Numbers: ");
        for(int i=0; i<n; i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("The Numbers are: ");
        for(int i=0; i<n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nCount of Odd Numbers: " + countODD(arr));
        System.out.println("Maximum Number: " + maxx(arr, n));
        System.out.println("Frequency of Numbers: " + frq(arr, n));
        sc.close();
    }
}
