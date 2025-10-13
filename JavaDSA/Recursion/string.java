public class string {

    public String reverse(String s1)
    {
        if(s1.length()<=1)
            return s1;
        else
            return reverse(s1.substring(1)) + s1.charAt(0);
    }
    public static void main(String[] args)
    {
        String s1 ="hello";
        string obj = new string();
        String reversed = obj.reverse(s1);
        System.out.println(reversed);
    }
}
