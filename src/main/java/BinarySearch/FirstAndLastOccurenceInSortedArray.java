package BinarySearch;

public class FirstAndLastOccurenceInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{extractFirstOcc(nums, target,true), extractFirstOcc(nums, target,false)};
    }

    private static int extractFirstOcc(int[] nums, int target, boolean isFirst) {
        int occurence = -1;
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                occurence = mid;
                if(isFirst)
                    high = mid - 1;
                else
                    low=mid+1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return occurence;
    }
}
