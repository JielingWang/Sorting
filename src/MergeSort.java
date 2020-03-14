import java.util.Arrays;

/**
 * Top-down Merge Sort
 * Step1: If array is of size 1, return
 * Step2: Merge sort the left half
 * Step3: Merge sort the right half
 * Step4: Merge the two sorted halves
 * Time Complexity: O(NlogN)
 * Space Complexity: O(N)
 * Stable
 */

class MergeSort {
    public static void main(String[] args) {
        int [] test1 = new int[] {9, 8, 7, 6, 3, 5, 2};
        int [] test2 = new int[] {1, 2, 3, 4, 5};
        int [] test3 = new int[] {1, 1, 1};

        // sort(test1);
        Arrays.stream(sort(test1)).forEach(s -> System.out.print(s + " "));
        System.out.println();
        Arrays.stream(sort(test2)).forEach(s -> System.out.print(s + " "));
        System.out.println();
        Arrays.stream(sort(test3)).forEach(s -> System.out.print(s + " "));
    }

    public static int[] sort(int[] nums) {
        return mergesort(nums, 0, nums.length - 1);
    }

    private static int[] mergesort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            int[] left = mergesort(nums, start, mid);
            int[] right = mergesort(nums, mid + 1, end);
            int[] sorted = new int[end - start + 1];
            int i = 0, j = 0, p = 0;
            while (p <= end - start) {
                if (i >= left.length) {
                    sorted[p] = right[j];
                    j ++;
                } else if (j >= right.length) {
                    sorted[p] = left[i];
                    i ++;
                } else if (left[i] <= right[j]) {
                    sorted[p] = left[i];
                    i ++;
                } else {
                    sorted[p] = right[j];
                    j ++;
                }
                p ++;
            }
            return sorted;
        } else {
            int[] sorted = {nums[start]};
            return sorted;
        }
    }
}