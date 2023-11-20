package kmp;

public class KMP {
    public static void main(String[] args) {
        Solution_kmp kmp = new Solution_kmp();
        // Test Case 1: Basic Match
        test(kmp, "THIS IS A TEST TEXT", "TEST", 10);

        // Test Case 2: No Match
        test(kmp, "A QUICK BROWN FOX JUMPS OVER THE LAZY DOG", "CAT", -1);

        // Test Case 3: Match at the Beginning
        test(kmp, "MATCH AT THE BEGINNING", "MATCH", 0);

        // Test Case 4: Match at the End
        test(kmp, "FINDING A MATCH AT THE END", "END", 23);

        // Test Case 5: Repeated Pattern
        test(kmp, "REPEATED REPEATED REPEATED", "REPEATED", 0);

        // Test Case 6: Overlapping Pattern
        test(kmp, "ABAABABAABAAB", "ABAABAAB", 5);

        // Test Case 7: Long Text
        test(kmp, "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG SEVERAL TIMES", "LAZY", 35);

        // Test Case 8: Pattern Longer than Text
        test(kmp, "SHORT", "LONGER PATTERN", -1);

        // Test Case 9: Pattern Equal to Text
        test(kmp, "EXACT MATCH", "EXACT MATCH", 0);

        // Test Case 10: Special Characters
        test(kmp, "SPECIAL$CHARACTERS#IN*TEXT", "CHARACTERS#", 8);

    }

    private static void test(Solution_kmp kmp, String text, String pattern, int expected) {
        int result = kmp.findPattern(text, pattern);
        if (result == expected) {
            System.out.println("Test passed for: \"" + pattern + "\" in \"" + text + "\"");
        } else {
            System.out.println("Test failed for: \"" + pattern + "\" in \"" + text + "\". Expected: " + expected + ", but got: " + result);
        }
    }
}

class Solution_kmp {
    public int findPattern(String text, String pattern) {
        int[] next = getNext(pattern);
        int t = 0; // index of text
        int p = 0; // index of pattern
        while(t < text.length() && p < pattern.length()) {
            if(text.charAt(t) != pattern.charAt(p)) {
                if(next[p] == -1) {
                    t++;
                } else {
                    p = next[p];
                }
            }else {
                t++;
                p++;
            }
        }

        if(p == pattern.length()) {
            return t - pattern.length();
        }

        return -1;
    }


    /*
     * next[j] = the longest proper prefix of pattern[0, j-1] 
     * that is also a suffix of pattern[0, j-1]
     */
    public int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while(i < pattern.length() - 1) { // no care about the last one
            if(j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    // public int[] makeNext(String pattern) {
    //     int[] next = new int[pattern.length()];
    //     for(int i = 1; i < pattern.length(); i++) {
    //         String subStr = pattern.substring(0, i);
    //         next[i] = longestCommon(subStr);    
    //     }
    //     next[0] = -1;
    //     return next;
    // }

    // public int longestCommon(String str) {
    //     int i = 1;
    //     int len = str.length();
    //     while(i < len) {
    //         String prefix = str.substring(0, len - i);
    //         String suffix = str.substring(i,  len);
    //         if(prefix.equals(suffix)) return len - i;
    //         i++;
    //     }
    //     return 0;
    // }
    
}
