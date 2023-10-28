package company.samsara;

import java.util.Arrays;

public class Q4 {
    private int mostContinuous(int[] arr, int end) {
        int[] newArr = Arrays.copyOf(arr, end + 1);
        Arrays.sort(newArr);
        int maxCount = 1;
        int cnt = 1;
        for(int i=1; i<=end; i++) {
            if(newArr[i] == newArr[i-1] + 1) {
                cnt++;
            } else {
                if(cnt > maxCount) {
                    maxCount = cnt;
                }
                cnt = 1;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Q4 q4 = new Q4();
        int[] arr1 = {2,1,3};
        for(int i = 0; i < arr1.length; i++) {
            System.out.print( q4.mostContinuous(arr1, i)+ " ");
        }
    }
}
