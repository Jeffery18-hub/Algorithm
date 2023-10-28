package company.samsara;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q5 {
    public List<Integer> solution(String binaryString, String[] request) {
        int len_ = binaryString.length(); 
        char[] bs1 = binaryString.toCharArray();
        char[] bs2 = new char[len_];
        for(int i = 0; i < len_; ++i) {
            if(bs1[i] == '0') bs2[i] = '1';
            else {
                bs2[i] = '0';
            }
        }

        // cnt the 1s on all index
        int[] numOfOnes1 = new int[len_];
        int[] numOfOnes2 = new int[len_];
        for(int i = 0; i < len_; ++i) {
            if(i == 0) {
                if(bs1[i] == '1') numOfOnes1[i] = 1;
                if(bs2[i] == '1') numOfOnes2[i] = 1;
            }else {
                if(bs1[i] == '1') numOfOnes1[i] = numOfOnes1[i - 1] + 1;
                else{ 
                    numOfOnes1[i] = numOfOnes1[i - 1];
                }

                if(bs2[i] == '1') numOfOnes2[i] = numOfOnes2[i - 1] + 1;
                else {
                    numOfOnes2[i] = numOfOnes2[i - 1];
                }
            }
        }
        
        int whichOne = 1;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < request.length; ++i) {
            String req = request[i];
            if(req.equals("flip") && whichOne == 1) whichOne = 2;
            else if(req.equals("flip") && whichOne == 2) whichOne = 1;
            else {
                char lastChar = req.charAt(req.length() - 1);
                if(whichOne == 1) res.add(numOfOnes1[lastChar - '0']);
                else if(whichOne == 2) res.add(numOfOnes2[lastChar - '0']); 
            } 
        }

        return res;

    }

    public static void main(String[] args) {
        String bString = "0000101";
        String[] reqs = {"count:4", "count:6", "flip", "count:4", "flip", "count:2"};
        Q5 q5 = new Q5();
        List<Integer> result = q5.solution(bString, reqs);
        System.out.println(result.toString());
    }
    
}
