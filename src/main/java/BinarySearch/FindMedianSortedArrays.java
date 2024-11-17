package BinarySearch;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int median = 0;
        int n = nums1.length;
        int m = nums2.length;
        int[] combinedArray = new int[n + m];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < n && j < m) {
            if(nums1[i]<nums2[j]){
                combinedArray[index++]=nums1[i++];
            }else {
                combinedArray[index++]=nums2[j++];
            }
        }
        while(i<n){
            combinedArray[index++]=nums1[i++];
        }
        while(j<m){
            combinedArray[index++]=nums2[j++];
        }
        if(combinedArray.length%2!=0){
            return combinedArray[index/2];
        }else{
            int midIndex= combinedArray.length/2;
            return (double) (combinedArray[midIndex] + combinedArray[midIndex-1]) /2;
        }
    }

}
