import java.util.Arrays;

/**
 * Quick Sort (Tree-way Quick Sort)
 * Step1: Partition around a pivot item (e.g. leftmost)
 * Step2: Quick sort left side, all keys < pivot
 * Step3: Quick sort right side, all keys >= pivot
 * Time Complexity: Average O(NlogN), Worst O(N-square)
 * Space Complexity: O(1)  Unstable
 * Partition algo: (pivot is the leftmost item)
 * Step1: Find pivot's correct position in [left+1, right-1]
 * Step2: Go over the array from left+1 to right-1,
 *        if nums[i] < pivot, expand left side
 *        if nums[i] > pivot, expend right side
 *        otherwise move on
 * Step3: Swap pivot with the rightmost left side item
 */

class QuickSort {
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
        quicksort(nums, 0, nums.length - 1);
    }

    private static void quicksort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pidx = partition(nums, start, end);
        quicksort(nums, start, pidx - 1);
        quicksort(nums, pidx + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int left = start;
        int right = end + 1;
        int i = start + 1;
        while (i < right) {
            if (nums[i] < pivot) {
                left ++;
                i ++;
            } else if (nums[i] > pivot) {
                swap(nums, right - 1, i);
                right --;
            } else {
                i ++;
            }
        }
        // for now: i == right
        // [start+1, left] < pivot
        // [right, end] > pivot
        // [left+1, right-1] == pivot
        swap(nums, start, left);
        return left;
    }

    private static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}