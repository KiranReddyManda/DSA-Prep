package BinarySearch;

public class findPeakElement {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{3,4,3,2,1}));
    }

    public static int findPeakElement(int[] nums) {
        int len = nums.length;
        int res = 0;
        int low = 0;
        int high = len - 1;
        if(len==1){
            return 0;
        } else if (len==2 && nums[0] > nums[1]) {
            return 0;
        }else if (len==2 && nums[1] > nums[0]) {
            return 1;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && mid < len-1) {
                if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                    return mid;
                } else if (nums[mid] > nums[mid + 1]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (mid==0) {
                return nums[mid]>nums[mid+1] ? 0 :1;
            }else{
                return nums[len-1]>nums[len-2] ? len-1 :len-2;
            }
        }
        return res;
    }

}
