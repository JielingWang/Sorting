import java.util.Arrays;

/**
 * Counting Sort
 * Step1: Count the number of occurences for each key
 * Step2: Compute the starting index for each key
 * Step3: Go over the original array
 *        Put the key into the correct cell of new array
 * Time Complexity: O(N+R) N: number of items, R: size of range
 * Space Complexity: O(N)
 */

class CountingSort{
    public static void main(String[] args) {
        int[] test1 = new int[] {9, 8, 2, 7, 6, 3, 5, 2};
        int[] test2 = new int[] {1, 2, 3, 4, 5};
        int[] test3 = new int[] {1, 1, 1};
        int[] test4 = new int[] {32, 15, 2, 17, 19, 26, 41, 17, 17};

        sort(test1);
        Arrays.stream(test1).forEach(s -> System.out.print(s + " "));
        System.out.println();
        sort(test2);
        Arrays.stream(test2).forEach(s -> System.out.print(s + " "));
        System.out.println();
        sort(test3);
        Arrays.stream(test3).forEach(s -> System.out.print(s + " "));
        System.out.println();
        sort(test4);
        Arrays.stream(test4).forEach(s -> System.out.print(s + " "));
    }

    public static void sort(int[] nums) {
        countingsort(nums);
    }
    
    private static void countingsort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            max = Math.max(n, max);
            min = Math.min(n, min);
        }
        int count[] = new int[max - min + 1]; 
        int res[] = new int[nums.length];
        // find the number of occurences for each key
        for (int i = 0; i < nums.length; i++) { 
            count[nums[i] - min] ++;
        }
        // find the starting indices for each key
        for (int i = 1; i < count.length; i++) { 
            count[i] += count[i - 1]; 
        }
        // put every key in the correct index of result array
        for (int i = 0; i < nums.length; i++) {
            res[count[nums[i] - min] - 1] = nums[i];
            count[nums[i] - min] --;
        }
        for (int i = 0; i < nums.length; i++) { 
            nums[i] = res[i]; 
        } 
    }
}