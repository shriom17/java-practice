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
    public static int sum(int arr[], int n)
    {
        if(n<=0)
        {
            return 0;
        }
        else
        {
            return arr[n-1] + sum(arr,n-1);
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
    public static int count(int c)
    {
        if(c<=0)
        {
            return 0;
        }
        else
        {
            return 1 + count(c/10);
        }
    }
    public static int fibo(int s)
    {
        if(s==0)
        {
            return 0;
        }
       else if(s==1)
        {
            return 1;
        } 
        else
        {
            return fibo(s-1) + fibo(s-2);
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
        System.out.println("Sum of first " + n + " natural numbers is: " + sum(arr,n));
        System.out.println("Enter a number to count digits:");
        int c = sc.nextInt();
        System.out.println("Number of digits in " + c + " is: " + count(c));
        System.out.println("Enter a number to find Fibonacci:");
        int s = sc.nextInt();
        System.out.println("Fibonacci of " + s + " is: " + fibo(s));
        sc.close();
    }
}
