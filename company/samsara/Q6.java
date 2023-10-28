package company.samsara;

public class Q6 {
    private void dropBubbles(int[][] matrix, int targetCol) {
        int rows = matrix.length;
        int col =  targetCol == 0 ? 0 : targetCol-1;

        for(; col <= targetCol + 1; col++) {
            int slow = rows - 1;
            int fast = rows - 2;
            while(slow >= 0 && fast >= 0) {
                if(matrix[slow][col] != 0) {
                    fast--;
                    slow--;
                }else {
                    if(matrix[fast][col] != 0) {
                        int tmp = matrix[fast][col];
                        matrix[fast][col] = matrix[slow][col];
                        matrix[slow][col] = tmp;
                        slow--;
                        fast--; 
                    }else {
                        while(fast >= 0){
                            if(matrix[fast][col] != 0) break;
                            fast--;
                        }
                    }
                }
            }
            
        }
    }

    public void solution(int[][] matrix, int[][] ops) {
        int[][] directions = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for(int[] op: ops) {
            for(int[] dir : directions) {
                int[] newIdx = new int[]{op[0] + dir[0], op[1] + dir[1]};
                if(newIdx[0] >=0 && newIdx[1] >= 0 && 
                    newIdx[0] < matrix.length && newIdx[1] < matrix[0].length &&
                    matrix[newIdx[0]][newIdx[1]] == matrix[op[0]][op[1]]) { 
                    matrix[newIdx[0]][newIdx[1]] = 0;
                }
            }
            matrix[op[0]][op[1]] = 0;
            dropBubbles(matrix, op[1]);
        }
    }

    public static void main(String[] args) {
        Q6 q6 = new Q6();
        int[][] matrix = {{1,1,1,4,3}, {4,1,2,3,3}, {1,5,1,1,2}, {4,3,2,2,4}};
        int[][] ops = {{1,1}, {3,3}, {2,2}, {3,0}};
        q6.solution(matrix, ops);

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
