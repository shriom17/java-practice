import java.util.Scanner;

public class BinaryStrings {

    public static void generateBinary(int n, int index, String c)
    {
        if(index==n)
        {
            System.out.println(c);
            return;
        }
        
            generateBinary(n, index+1, c+'0');
            generateBinary(n, index+1, c+'1');
    
        
    }
    public static void main(String[] args)
    {
        System.out.println("Enter the length of binary strings:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        generateBinary(n, 0, "");
    }
}
