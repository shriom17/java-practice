import java.util.*;
public class major {
    /**
     * @param args
     */
    public static void main(String [] args)
    {
        int[] arr;
        System.out.println("Enter the size of array:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr=new int[n];        
        System.out.println("Enter The Numbers: ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0; i<n; i++)
       {
        int count = 1; // Start with 1 for the current element
        for(int j=i+1; j<n; j++)
        {
            if(arr[i]==arr[j])
            {
                count++;
            }
        }
        if(count > n/2)
        {
            System.out.println("Majority element: " + arr[i]);
            return; // Exit after finding first majority element
        }
       } 
  }   
}
