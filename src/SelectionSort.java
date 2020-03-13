import java.util.Arrays;

/**
 * Selection Sort
 * Step1: Find the smallest item in the array, swap it with the first item
 * Step2: Find the next smallest item in the array, swap it with the next item
 * Step3: Continue untill all items in the array are sorted
 * Time Complexity: O(n-square)
 * Space Complexity: O(1)
 */

class SelectionSort {
    public static void main(String[] args) {
        int [] test1 = new int[] {9, 8, 4, 6, 3, 5};
        int [] test2 = new int[] {1, 2, 3, 4, 5};
        int [] test3 = new int[] {1, 1, 1};

        sort(test1);
        Arrays.stream(test1).forEach(s -> System.out.print(s + " "));
        System.out.println();
        sort(test2);
        Arrays.stream(test2).forEach(s -> System.out.print(s + " "));
        System.out.println();
        sort(test3);
        Arrays.stream(test3).forEach(s -> System.out.print(s + " "));
    }

    public static void sort(int[] nums) {
        selectionsort(nums);
    }

    private static void selectionsort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minNum = nums[i];
            int minIdx = i;
            // Find the smallest item in the array and record its idx
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < minNum) {
                    minNum = nums[j];
                    minIdx = j;
                }
            }
            // Swap the smallest item with current item 
            swap(nums, i, minIdx);
        }
    }

    private static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}