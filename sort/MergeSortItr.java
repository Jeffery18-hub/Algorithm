
// iterative
class MergeSortItr {
    public static void main(String[] args) {
        int[] arr = {10,1,2, 11,8, 2,5,2};
        int[] tmp = new int[arr.length];
        mergeSort(arr);
        for(int i=0; i<arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr){
        int[] tmp = new int[arr.length];
        mergeSortItr(arr, tmp);
    }

    public static void mergeSortItr(int[] arr, int[] tmp) {
        // variable size to control the size of the subarray
        // low to control the start index of the subarray
        for(int subSize=1; subSize< arr.length; subSize*=2){
            for (int low = 0; low < arr.length-subSize; low = low + 2*subSize){
                int mid = low + subSize -1;
                int high = Math.min(low + 2*subSize -1, arr.length-1);
                merge(arr, tmp, low, mid, high);

            }
        }

    }

    public static void merge(int[] arr, int[] tmp, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= high) {
            tmp[k++] = arr[j++];
        }
        for (int m = low; m <= high; ++m) {
            arr[m] = tmp[m];
        }
    }
}










