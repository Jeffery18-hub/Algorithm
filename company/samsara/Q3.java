package company.samsara;

import java.util.Arrays;

public class Q3 {
    private int getBeauty(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        if (newArr[0] > 1)
            return 1;

        for (int i = 0; i < arr.length - 1; i++) {
            if (newArr[i + 1] - newArr[i] > 1)
                return newArr[i] + 1;
        }

        return newArr[newArr.length - 1] + 1;
    }

    public int[][] solution(int[][] inputMatrix) {
        for (int j = inputMatrix[0].length / 2; j > 1; j--) {
            for (int i = 0; i < j - 1; i++) {
                int[] current = new int[] { inputMatrix[0][2 * i], inputMatrix[0][2 * i + 1],
                        inputMatrix[1][2 * i], inputMatrix[1][2 * i + 1] };

                int[] next = new int[] { inputMatrix[0][2 * (i + 1)], inputMatrix[0][2 * (i + 1) + 1],
                        inputMatrix[1][2 * (i + 1)], inputMatrix[1][2 * (i + 1) + 1] };

                // System.out.println(Arrays.toString(current) + ", " + Arrays.toString(next));

                int beautyCurr = getBeauty(current);
                int beautyNext = getBeauty(next);
                if (beautyCurr > beautyNext) {
                    // swap
                    // curr
                    inputMatrix[0][2 * i] = next[0];
                    inputMatrix[0][2 * i + 1] = next[1];
                    inputMatrix[1][2 * i] = next[2];
                    inputMatrix[1][2 * i + 1] = next[3];

                    // next
                    inputMatrix[0][2 * (i + 1)] = current[0];
                    inputMatrix[0][2 * (i + 1) + 1] = current[1];
                    inputMatrix[1][2 * (i + 1)] = current[2];
                    inputMatrix[1][2 * (i + 1) + 1] = current[3];

                }

                // for (int k = 0; k < inputMatrix.length; k++) {
                //     for (int m = 0; m < inputMatrix[k].length; m++) {
                //         System.out.print(inputMatrix[k][m] + " ");
                //     }
                //     System.out.println();
                // }

            }
        }

        return inputMatrix;
    }

    public static void main(String[] args) {
        int[][] input = { { 1, 2, 2, 3, 2, 10, 1, 2 }, { 3, 4, 10, 2, 5, 4, 4, 1 } };
        // Test case
        Q3 q3 = new Q3();
        int[][] res = q3.solution(input);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }
}
