package kmp;


public class KMP {
    public static void main(String[] args) {
        String patern = "ABABAAABABAA";
        String text = "ABABABAABABAAABABAA";
        Solution_kmp kmp = new Solution_kmp();
        boolean result = kmp.findPatern(text, patern);
        //System.out.println(result);

        String p2= "AD";
        String t2 = "DDAC";
        boolean result2 = kmp.findPatern(t2, p2);
        System.out.println(result2);

    }
}

class Solution_kmp {
    public boolean findPatern(String text, String pattern) {
        int[] next = makeNext(pattern);
        int i = 0; // index of text
        int j = 0; // index of pattern
        while(i < text.length() && j < pattern.length()) {
            if(text.length() - i < pattern.length() - j) return false;

            if(j == 0 && text.charAt(i) != pattern.charAt(j)) {
                i++;
            }else if( j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = next[j];
            }else {
                i++;
                j++;
            }
        }
        return true;
    }

    private int[] makeNext(String str) {
        int[] res = new int[str.length()];
        for(int i = 2; i < str.length(); i++) {
            res[i] = longestCommon(str, i  - 1);    
        }

        return res;
    }

    private int longestCommon(String str, int end) {
        if(str.length() <= 1 || end < 1 ) return 0;

        int len = end;
        while(len > 0) {
            String prefix = str.substring(0, len);
            String suffix = str.substring(end + 1 - len, end + 1);
            if(prefix.equals(suffix)) return len;
            len--;
        }
        return len;
    }
    
}
