import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {10, 11, 2, 5,12,5,10,3};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void insertion(int[] arr){
        for( int i =1; i< arr.length; ++i ){
            for(int j=i; j>0 && arr[j]<arr[j-1]; --j){
                    swap(arr,j,j-1);
            }
        }

    }
}
