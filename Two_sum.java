/* Lets go with brute force approach first
--->Try to add 2 nums in array until we get our desired target and return index
    But it takes to munch of TC -O(n^2) and  no issue with SC -o(n)

import java.util.*;

public class Two_sum {
    public static int[] twoSum_Bruteforce(int[] nums, int target) {
        for (int i = 0; i < nums.length;i++ ){
            for (int j = i + 1; j < nums.length; i++) {
                if (nums[i] == target - nums[j]) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the no of ele:");
        int n = sc.nextInt();
        int [] nums = new int[n];

        System.out.print("enter the array ele:");
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();

        System.out.print("Give the target value:");
        int target = sc.nextInt();

        int [] ans = twoSum_Bruteforce(nums,target);
        System.out.println(Arrays.toString(ans));
        
    }
}
*/


/* Now lets try a better approach , it can be done by binary search and 2 pointer
-->Binary search : sorting the array takes-- O(nlogn) and SC will reamins the same O(n)



import java.util.*;

public class Two_sum {
    public static int[] twoSum_BS(int[] nums, int target) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for (int i = 0; i < sorted.length; i++) {
            int complement = target - sorted[i];
            int idx = Arrays.binarySearch(sorted, i + 1, sorted.length, complement);
            if (idx >= 0) {
                int first = findIndex(nums, sorted[i], -1);
                int second = findIndex(nums, sorted[idx], first);
                return new int[]{first, second};
            }
        }
        return new int[]{-1, -1};
    }

    private static int findIndex(int[] nums, int value, int ignore) {
        for (int i = 0; i < nums.length; i++) {
            if (i != ignore && nums[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int[] ans = twoSum_BS(nums, target);
        System.out.println( Arrays.toString(ans));
        sc.close();
    }
}
*/

/*
import java.util.*;

public class Two_sum {
    public static int[] twoSumTwoPointer(int[] nums, int target) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int left = 0, right = sorted.length - 1;
        while (left < right) {
            int sum = sorted[left] + sorted[right];
            if (sum == target) {
                int first = findIndex(nums, sorted[left], -1);
                int second = findIndex(nums, sorted[right], first);
                return new int[]{first, second};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    private static int findIndex(int[] nums, int value, int ignore) {
        for (int i = 0; i < nums.length; i++) {
            if (i != ignore && nums[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int[] ans = twoSumTwoPointer(nums, target);
        System.out.println( Arrays.toString(ans));
        sc.close();
    }
}
*/

// traverse array once, storing seen nums in HashMap, for each num check if compl exists
// it takes -->O(1) on avg.  and then single pass --O(n) , total TC -->O(n)
import java.util.*;

public class Two_sum {
    public static int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int[] ans = twoSumHash(nums, target);
        System.out.println("HashMap Result: " + Arrays.toString(ans));
        sc.close();
    }
}








