import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {100, 11, 2, 5,22};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }


    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    static void selection(int[] arr){
        for(int i=0; i< arr.length-1; ++i){
            int min = arr[i];// min: the min value in the unsorted part
            for(int j=i+1; j< arr.length; ++j){
                if(arr[j] < min){
                    swap(arr,j, i);
                    min = arr[i];// update min after swap
                }
            }// after the inner loop, the min value is in the i-th pos
            // and the unsorted part is from i+1 to the end


        }

    }

}
