package BinarySearch;

public class SplitArray {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{1,2,3,4,5},2));
    }
    public static int splitArray(int[] nums, int k) {
        int low=0;
        int high =0;
        for(int x: nums){
            low = Math.max(low,x);
            high +=x;
        }
        int res=0;
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(isValidSplit(nums,mid,k)){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }

    private static boolean isValidSplit(int[] nums, int mid, int k) {
        int totalSum =0;
        int chances =1;
        for(int x : nums){
            if(totalSum+x > mid){
                ++chances;
                totalSum=x;
                if(chances>k) return false;
            }else{
                totalSum+=x;
            }
        }
       return chances<=k;
    }

}
