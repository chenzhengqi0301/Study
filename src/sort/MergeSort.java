package sort;

import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int [] arr){
        if(arr.length<2) return arr;
        int middle=arr.length/2;
        int[] left= Arrays.copyOfRange(arr,0,middle);
        int[] right= Arrays.copyOfRange(arr,middle,arr.length);
        return merge(sort(left),sort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int i=0;
        int arr[]=new int [left.length+right.length];
        while(left.length>0&&right.length>0){
            if(left[0]<=right[0]){
                arr[i++]=left[0];
                left=Arrays.copyOfRange(left,1,left.length);
            }else{
                arr[i++]=right[0];
                right=Arrays.copyOfRange(right,1,right.length);
            }
        }
        while (left.length>0){
            arr[i++]=left[0];
            left=Arrays.copyOfRange(left,1,left.length);
        }
        while (right.length>0) {
            arr[i++] = right[0];
            right=Arrays.copyOfRange(right,1,right.length);
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[]={21,32,21,11,27,2,8,1,6};
        int arr2[]=MergeSort.sort(arr);
        for (int i:
             arr2) {
            System.out.println(i);
        }
    }
}
