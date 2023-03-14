import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {100, 11, 2, 5,22};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    //helper function
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // bubble sort
    static void bubble(int[] arr){
        boolean flag = false; // flag: whether there is a swap in a round
        for(int i=0; i< arr.length-1; ++i){ // i: number of rounds
            for(int j=0; j< arr.length-1-i; ++j){ // j: number of comparisons
                if(arr[j]> arr[j+1]) {
                    flag = true;
                    swap(arr, j, j + 1);
                }
            }
            if(!flag) break; // if no swap in a round, then the array is sorted
            else flag = false;// reset flag
        }
    }

}
