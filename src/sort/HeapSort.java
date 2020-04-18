package sort;

import java.util.Arrays;
import java.util.List;

public class HeapSort {
    public static int [] sort(int []sourceArray){
        int arr[]= Arrays.copyOf(sourceArray,sourceArray.length);
        int len=arr.length;
        buildMaxheap(arr,len);
        for(int i=len-1;i>0;i--){
            swap(arr,0,i);
            len--;
            heapify(arr,0,len);
        }
        return  arr;
    }

    private static void buildMaxheap(int[] arr, int len) {
        int middle= (int) Math.floor(len/2);
        for(int i=middle;i>=0;i--){
            heapify(arr,i,len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int left=2*i+1;
        int right=2*i+2;
        int large=i;
        if(left<len && arr[left]>arr[large]) large=left;
        if(right<len && arr[right]>arr[large]) large=right;
        if(large!=i){
            swap(arr,large,i);
            heapify(arr,large,len);
        }
    }

    private static void swap(int arr[],int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void main(String[] args) {
        int arr[]=HeapSort.sort(new int[]{32, 12, 21, 1, 43, 23, 6, 19});
        for (int a:arr
             ) {
            System.out.println(a);
        }
    }
}
