public class QuickSort {


    public static void main(String[] args) {
        int[] arr = {10, 2, 9, 8, 2, 5, 22, 1, 1, 11};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    // randomly select a pivot
    public static int selectPivot(int[] arr, int low, int high) {
        return (int) (Math.random() * (high - low + 1)) + low;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivotIndex = selectPivot(arr, low, high);
        swap(arr, pivotIndex, high);
        int pivot = arr[high];
        int i = low;
        int j = high - 1;
        while (i <= j) {
//            //let i go first
//            while(i<=j && arr[i] <= pivot){
//                ++i;
//            }
//            //let j go second
//            while(i<=j && arr[j] > pivot){
//                --j;
//            }
//            if(i<j){
//                swap(arr, i, j);
//            }

            //let j go first
            while (i <= j && arr[j] > pivot) {
                --j;
            }
            //let i go second
            while (i <= j && arr[i] <= pivot) {
                ++i;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }

        //swap pivot to the right position
        swap(arr, i, high);

        return i;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
        return;
    }
}

