import java.util.Arrays;

/**
 * In-place Heap Sort
 * Step1: Bottom-up heapify input array:
 *        Sink nodes in reverse level order
 *        After sinking, gaurentee that tree rooted at position k is a heap
 * Step2: Repeat N times: 
 *        Delete largest item from the max heap, swapping root with last item in the heap
 * Time Complexity: O(NlogN)
 * Space Complexity: O(1)  Unstable
 */

class HeapSort{
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
        heapsort(nums);
    }

    private static void heapsort(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            heapify(nums, len, i);
        }
        for (int i = len - 1; i >= 0; i--) { 
            swap(nums, 0, i);
            heapify(nums, i, 0);
        } 
    }

    private static void heapify(int[] nums, int len, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < len && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < len && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, len, largest);
        }
    }

    private static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}