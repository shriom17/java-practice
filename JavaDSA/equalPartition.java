import java.util.ArrayList;

public class equalPartition {
    
    // Method to check if array can be partitioned into two equal sum subsets
    public boolean canPartition(int[] arr) {
        int totalSum = 0;
        
        // Calculate total sum
        for(int num : arr) {
            totalSum += num;
        }
        
        // If total sum is odd, can't partition into equal parts
        if(totalSum % 2 != 0) {
            return false;
        }
        
        int target = totalSum / 2;
        return canPartitionHelper(arr, 0, target);
    }
    
    // Recursive helper method using backtracking
    private boolean canPartitionHelper(int[] arr, int index, int target) {
        // Base cases
        if(target == 0) {
            return true; // Found a subset with target sum
        }
        
        if(index >= arr.length || target < 0) {
            return false; // No more elements or target becomes negative
        }
        
        // Try including current element
        if(canPartitionHelper(arr, index + 1, target - arr[index])) {
            return true;
        }
        
        // Try excluding current element
        return canPartitionHelper(arr, index + 1, target);
    }
    
    // Method to find and return the actual partitions
    public ArrayList<ArrayList<Integer>> getEqualPartitions(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        if(!canPartition(arr)) {
            return result; // Return empty if partition not possible
        }
        
        int totalSum = 0;
        for(int num : arr) {
            totalSum += num;
        }
        
        int target = totalSum / 2;
        ArrayList<Integer> subset1 = new ArrayList<>();
        ArrayList<Integer> subset2 = new ArrayList<>();
        
        findPartitions(arr, 0, target, subset1, subset2, result);
        
        return result;
    }
    
    private void findPartitions(int[] arr, int index, int target, 
                               ArrayList<Integer> subset1, ArrayList<Integer> subset2,
                               ArrayList<ArrayList<Integer>> result) {
        
        if(index == arr.length) {
            if(target == 0 && !result.isEmpty() == false) { // Found first valid partition
                result.add(new ArrayList<>(subset1));
                result.add(new ArrayList<>(subset2));
            }
            return;
        }
        
        // Include current element in subset1
        if(target >= arr[index]) {
            subset1.add(arr[index]);
            findPartitions(arr, index + 1, target - arr[index], subset1, subset2, result);
            subset1.remove(subset1.size() - 1); // backtrack
        }
        
        // Include current element in subset2
        subset2.add(arr[index]);
        findPartitions(arr, index + 1, target, subset1, subset2, result);
        subset2.remove(subset2.size() - 1); // backtrack
    }
    
    public static void main(String[] args) {
        equalPartition ep = new equalPartition();
        
        // Test cases
        int[] arr1 = {1, 5, 11, 5};
        int[] arr2 = {1, 2, 3, 5};
        int[] arr3 = {1, 1, 3, 1};
        
        System.out.println("Array: [1, 5, 11, 5]");
        System.out.println("Can partition: " + ep.canPartition(arr1));
        System.out.println("Partitions: " + ep.getEqualPartitions(arr1));
        System.out.println();
        
        System.out.println("Array: [1, 2, 3, 5]");
        System.out.println("Can partition: " + ep.canPartition(arr2));
        System.out.println("Partitions: " + ep.getEqualPartitions(arr2));
        System.out.println();
        
        System.out.println("Array: [1, 1, 3, 1]");
        System.out.println("Can partition: " + ep.canPartition(arr3));
        System.out.println("Partitions: " + ep.getEqualPartitions(arr3));
    }
}
