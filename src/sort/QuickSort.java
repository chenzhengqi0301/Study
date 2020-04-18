package sort;

import java.util.Arrays;

public class QuickSort{
    public static int [] sort(int sourceArray[]){
        int arr[]= Arrays.copyOf(sourceArray,sourceArray.length);
        return quickSort(arr,0,arr.length-1);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if(left<right){
            int partitionIndex=partition(arr,left,right);
            quickSort(arr,left,partitionIndex-1);
            quickSort(arr,partitionIndex+1,right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot=left;
        int index=pivot+1;
        for (int i=index;i<=right;i++){
            if (arr[i]<arr[pivot]){
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,pivot,index-1);
        return index-1;
    }

    private static void swap(int arr[], int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int arr[]={32,12,26,3,11,10,4,1,43,25};
        int arr2[]={3,2,1};
        int arr3[]={1,2,3};
        int result[]=QuickSort.sort(arr3);
        for (int i:result){
            System.out.println(i);
        }
    }

}
