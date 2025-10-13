import java.util.*;
public class StringOperations {

    public String reverse(String s1)
    {
        if(s1.length()<=1)
            return s1;
        else
            return reverse(s1.substring(1)) + s1.charAt(0);
    }

    public boolean isAnagram(String s1, String s2)    
    {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        if(s1.length()!=s2.length())
        {
            return false;
        }
        else
        {
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            return Arrays.equals(arr1, arr2);
        }
    }

    public static void main(String[] args)
    {
        String s1;
        System.out.println("Enter the string:");
        s1 = new Scanner(System.in).nextLine();
        StringOperations obj = new StringOperations();
        String reversed = obj.reverse(s1);
        System.out.println("Reversed: " + reversed);
        System.out.println("Enter the second string to check for anagram:");
        String s2 = new Scanner(System.in).nextLine();
        boolean isAnagram = obj.isAnagram(s1, s2);
        System.out.println("Is anagram: " + isAnagram);
    }
}
