package BinarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3, 5}, 5));
    }

    public static int search(int[] nums, int target) {
        int minIndex = findMin(nums);
        if (nums[minIndex] == target) {
            return minIndex;
        }
        int leftBS = BS(nums, target, 0, minIndex);
        return leftBS != -1 ? leftBS : BS(nums, target, minIndex + 1, nums.length - 1);
    }

    public static int BS(int[] nums, int target, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
                return BS(nums, target, low, high);
            } else {
                low = mid + 1;
                return BS(nums, target, low, high);
            }
        }
        return -1;
    }

    public static int findMin(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            if (nums[low] <= nums[high]) {
                return low;
            }
            int mid = low + (high - low) / 2;
            int leftIndex = (mid - 1 + len) % len;
            int rightIndex = (mid + 1) % len;
            if (nums[mid] < nums[leftIndex] && nums[mid] < nums[rightIndex]) {
                return mid;
            } else if (nums[mid] < nums[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

}
