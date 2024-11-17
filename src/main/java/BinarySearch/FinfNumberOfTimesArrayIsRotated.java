package BinarySearch;

public class FinfNumberOfTimesArrayIsRotated {

    public int findMin(int[] nums) {
        int index = 0;
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            int leftIndex = (mid - 1 + len) % len;
            int rightIndex = (mid + 1) % len;
            if (nums[mid] < nums[leftIndex] && nums[mid] < nums[rightIndex]) {
                return nums[mid];
            } else if (nums[mid] < nums[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
}
