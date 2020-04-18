package sort;

public class RadixSort {
    public  void sort(int []array){
        int max=get_max(array);
        int exp;
        for(exp=1;max/exp>0;exp*=10){
            count_sort(array,exp);
        }

    }

    public void count_sort(int []arr,int exp){
        int len=arr.length;
        int temp[]=new int[len];
        int []bucket=new int[10];
        for(int i=0;i<len;i++){
            bucket[(arr[i]/exp)%10]++;
        }
        for(int i=1;i<10;i++){
            bucket[i]+=bucket[i-1];
        }
        for (int i=len-1;i>=0;i--){
            temp[(bucket[(arr[i]/exp)%10]--)-1]=arr[i];
        }
        for (int i=0;i<len;i++){
            arr[i]=temp[i];
        }
    }

    public int get_max(int arr[]){
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return  max;
    }

    public static void main(String[] args) {
        int[] arr={21,32,221,12,3,142,6,2312,321,1};
        RadixSort sort=new RadixSort();
        sort.sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
