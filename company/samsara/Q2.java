package company.samsara;

import java.util.Arrays;

public class Q2 {

    private int biggerOne(int idx1, int idx2, int[] wins, int[] draws, int[] scored, int[] conceded) {
        int score1 = wins[idx1] * 3 + draws[idx1];
        int score2 = wins[idx2] * 3 + draws[idx2];
        if(score1 > score2) return idx1;
        else if(score2 > score1) return idx2;

        int goalDiff1 = scored[idx1] - conceded[idx1];
        int goalDiff2 = scored[idx2] - conceded[idx2];

        return goalDiff1 > goalDiff2? idx1:idx2;
    }

    public int[] solution(int[] wins, int[] draws, int[] scored, int[] conceded) {
        int highestIdx = biggerOne(0, 1, wins, draws, scored, conceded);
        int secondIdx = highestIdx == 0? 1:0;
        
        int teamsNum = wins.length;
        for(int i = 2; i < teamsNum; i++) {
            if(biggerOne(i, highestIdx, wins, draws, scored, conceded) == i) {
                int tmp = highestIdx;
                highestIdx = i;
                secondIdx = tmp;
            }else if(biggerOne(i, secondIdx, wins, draws, scored, conceded) == i && 
                biggerOne(i, highestIdx, wins, draws, scored, conceded) == highestIdx) {
                    secondIdx = i;
            }
        }

    
        return new int[] {highestIdx, secondIdx};
    }

    public static void main(String[] args){
        int[] wins = {2, 1, 0};
        int[] draws = {1, 5, 6};
        int[] scored = {20, 15, 10};
        int[] conceded = {20, 10, 15};
        Q2 q2 = new Q2();
        int[] res = q2.solution(wins, draws, scored, conceded);

        int[] wins2 = {3, 1, 2, 2};
        int[] draws2 = {1, 5, 4, 4};
        int[] scored2 = {30, 10, 20, 40};
        int[] conceded2 = {32, 13, 18, 37};
        int[] res2 = q2.solution(wins2, draws2, scored2, conceded2);

        System.out.println(Arrays.toString(res2));

    }
}
