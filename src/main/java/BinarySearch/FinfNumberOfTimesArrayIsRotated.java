package BinarySearch;

public class FinfNumberOfTimesArrayIsRotated {

    public int findMin(int[] nums) {
        int index =0;
        int len = nums.length;
        int low =0; int high = len-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int leftIndex = (mid-1+len)%2;
            int rightIndex = (mid+1)%2;
            if(nums[mid] >leftIndex && nums[mid] > rightIndex){
                return nums[mid];
            }else if (nums[mid]<nums[high]){
                low=mid-1;
            }else{
                high=mid+1;
            }
        }
        return index;
    }
}
