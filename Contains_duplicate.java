// Brute force --> looping to comapre each ele with others ,TC O(n^2)  space of O(1)

import java.util.*;

public class Contains_duplicate{
    public static boolean duplicate_bruteForce(int[]nums){
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int [] nums = new int[n];
        System.out.print("enter elements:");
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Bruteforce:" + duplicate_bruteForce(nums));
        sc.close();
    }
}




// sorting --->now instead of looping 2 times, lets sort array and
// compare side by side elements  --> takes TC O(nlogn) and SC O(1)
import java.util.*;
public class Contains_duplicate{
    public static boolean duplicates_sorting(int []nums){
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if (nums[i]==nums[i-1]) return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size");
        int n = sc.nextInt();
        int [] nums = new int[n];

        System.out.print("Enter ele:");
        for(int i=0;i<n;i++){
            nums[i]= sc.nextInt();
        }
        System.out.println("Sorting :"+ duplicates_sorting(nums));
        sc.close();
    }
}



// now for optimal method -- store seen numbers in set, if duplicate seen return true
// TC ->O(n) and SC -> O(n)
import java.util.*;
public class Contains_duplicate{
    public static boolean duplicate_hashSet(int []nums){
        HashSet<Integer> seen = new HashSet<>();
        for(int num : nums){
            if(seen.contains(num)){
                return true;
            }
            seen.add(num);
        }
        return false;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        System.out.print("enter the size:");
        int n = sc.nextInt();
        int [] nums = new int[n];

        System.out.print("Enter ele:");
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();

        System.out.println("Optimal method ->" + duplicate_hashSet(nums));
    }
}

