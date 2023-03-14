public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {100, 11, 2, 5,22,1,1,11};
        mergeSort(arr);
        for(int i=0; i<arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
    }

    // driver function
    public static void mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length-1);
    }

    public static void mergeSort(int[] arr, int[] temp, int low, int high){
        if(low < high){
            int mid = (low + high)/2;
            mergeSort(arr, temp, low, mid);
            mergeSort(arr, temp, mid+1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    public static void merge(int[] arr, int[] temp, int low, int mid, int high){
        int i = low;
        int j = mid+1;
        int k = low;
        while(i<=mid && j<=high){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=high){
            temp[k++] = arr[j++];
        }
        for(int m=low; m<=high; ++m){
            arr[m] = temp[m];
        }
    }


}