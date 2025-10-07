import java.util.*;

public class simplenum {
    public static void print(int arr[],int n)
    {
        if(n==0)
        {
            return;
        }
        else
        {
            arr[n-1]=n;
            print(arr,n-1);
            System.out.println(arr[n-1]);
        }
    }
    public static int factorial(int n)
    {
        if(n == 0 || n == 1)
        {
            return 1;  // Base case: 0! = 1, 1! = 1
        }
        else
        {
            return n * factorial(n-1);  // Recursive case
        }
    }
    public static int power(int n, int p)
    {
        if(p==0)
        {
            return 1;
        }
        else
        {
            return n * power(n,p-1);
        }
    }
    public static void main(String[] args) 
    {
        int[] arr;
        System.out.println("Enter the size of array:");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        arr=new int[n];
        System.out.println("Enter the elements of array:");
        print(arr,n);
        System.out.println("Factorial of "+ n + "is: " + factorial(n) );
        System.out.println("Enter the power of n:");
        int p = sc.nextInt();
        System.out.println(n + " raised to power " + p + " is: " + power(n,p));
    }
}
