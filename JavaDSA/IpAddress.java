
import java.util.ArrayList;

public class IpAddress {
    public ArrayList<String> generateIP(String s)
    {
        ArrayList<String> result = new ArrayList<>();
        solve(s, 0, "", 0, result);
        return result;
    }
    private void solve(String s, int index, String current, int segment, ArrayList<String> result)
    {
        // Base case: if we have 4 segments and used all characters
        if(segment == 4) {
            if(index == s.length()) {
                result.add(current.substring(1)); // Remove leading dot
            }
            return;
        }
        
        // Try segments of length 1, 2, and 3
        for(int i = 1; i <= 3; i++)
        {
            if(index + i > s.length())
                break;

            String part = s.substring(index, index + i);
            
            // Check if the part is valid
            if(isValidPart(part)) {
                // Recursively solve for the next segment
                solve(s, index + i, current + "." + part, segment + 1, result);
            }
        }
    }
    
    private boolean isValidPart(String part) {
        // Check for leading zeros (except single "0")
        if(part.startsWith("0") && part.length() > 1) {
            return false;
        }
        
        // Check if number is within valid range (0-255)
        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255;
    }
    
    public static void main(String[] args) {
        IpAddress ip = new IpAddress();
        
        // Test cases
        String[] testCases = {"25525511135", "0000", "1111", "192168001001"};
        
        for(String test : testCases) {
            System.out.println("Input: " + test);
            ArrayList<String> result = ip.generateIP(test);
            System.out.println("Valid IP addresses: " + result);
            System.out.println();
        }
    }
}
